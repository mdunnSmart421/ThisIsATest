package com.o2.finance.external.boa;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;
import java.security.cert.Certificate;
import java.text.DecimalFormat;
import java.util.Calendar;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import sun.misc.BASE64Encoder;
import sun.misc.CharacterEncoder;

import com.o2.finance.exception.unchecked.RuntimeFinanceException;
import com.o2.finance.model.UserTO;
import com.o2.finance.properties.ApplicationProperties;
import com.o2.finance.properties.PropertyManager;
import com.o2.finance.service.SystemTimeServiceImpl;
import com.o2.finance.service.TimeService;
import com.o2.finance.util.BaseConverter;
import com.o2.finance.util.LuhnCalculator;

/**
 * Class used to handle the building of a Bank of America request URL containing
 * encrypted and signed data packets.
 * 
 * @author SWatson
 *
 */
public class BACNameValuePairBuilder
{

    public static final int     ARI_TYPE_BFID            = 1;
    public static final int     ARI_TYPE_UID             = 2;
    
    private static final String SIGNED_DATA_PACKET       = "SDP";
    private static final String ENCRYPTED_KEY            = "EK";
    private static final String CUSTOMER_DATA            = "CD";
    private static final String APPLICATION_REF          = "ARI";
    private static final String PRODUCT_OFFER_CODE       = "POC";
    private static final String AD_CODE                  = "AD";
    private static final String DATE_TIME                = "DT";
    private static final String RETURN_URL               = "RU";
    private static final String PARTNER_KEY              = "PARTNER";
    private static final String PARTNER_VALUE            = "INTERNET_ATT_O2";
    private static final String BAC_NAME_VALUE_DELIMITER = "|";
    private static final String SDP_PARAM_DELIMITER      = "&";
    private static final String SDP_PARAM_OPERAND        = "=";

    private static final int    KEY_LENGTH               = 256;

    private static final int    ARI_LENGTH               = 16;
    private static final DecimalFormat DT_PADDING        = new DecimalFormat("0000000000000000000");

    Logger log = LogManager.getLogger( this.getClass() );

    private TimeService      clock;
    private CharacterEncoder encoder;
    private String           encryptAlgorithm;
    private String           encryptTransport;
    private String           keyEncryptAlogrithm;
    private String           initialisationVector;
    private String           digestAlgorithm;
    private String           signatureAlgorithm;
    private String           keyStore;
    private String           keyStoreType;
    private String           keyStorePasswd;
    private String           keyStoreAlias;
    private String           productOfferCode;
    private String           advertCode;


    private String bacKeyStore;
    private String bacStoreType;
    private String bacStorePassword;
    private String bacKeyAlias;


    static
    {
        // Add provider that supports RSA Cipher Encryption
        Provider rsaSupport = new BouncyCastleProvider();
        String name = rsaSupport.getName();
        Security.removeProvider(name);
        Security.addProvider(rsaSupport);
    }

    /**
     * Default constructor
     */
    public BACNameValuePairBuilder()
    {
        this(new SystemTimeServiceImpl());
    }

    /**
     * @param clock
     * @param encoder
     */
    protected BACNameValuePairBuilder(TimeService clock)
    {
        this(clock, new BASE64Encoder());
    }

    /**
     * @param clock
     * @param encoder
     */
    private BACNameValuePairBuilder(TimeService clock, CharacterEncoder encoder)
    {
        this.clock = clock;
        this.encoder = encoder;
        init();
    }




   public static void main( String[] args )
    {
        BACNameValuePairBuilder bac = new BACNameValuePairBuilder(
                new TimeService()
                {
                    public long currentTimeInMillis()
                    {
                       return  Calendar.getInstance().getTimeInMillis();
                    }
                },
                  new BASE64Encoder(),
                "AES",
                "AES/CBC/PKCS5Padding",
                "RSA/ECB/PKCS1Padding",
                 "1111111111111111",
                "SHA-512",
                "SHA512withRSA",
                "/finance/keystores/o2finance-keys",
                "jks",
                "password",
                "importkey",
                 "poc123456",
                 "12345"
        );

        bac.generateARI( 130000000072516L, ARI_TYPE_BFID );

    }




    /**
     * @param clock
     * @param encoder
     * @param encyptAlgorithm
     * @param keyEncryptAlogrithm
     * @param initialisationVector
     * @param digestAlgorithm
     * @param signatureAlgorithm
     * @param keyStore
     * @param keyStoreType
     * @param keyStorePasswd
     * @param keyStoreAlias
     */
    private BACNameValuePairBuilder(TimeService clock,
                                   CharacterEncoder encoder,
                                   String encyptAlgorithm,
                                   String encryptTransport,
            String keyEncryptAlogrithm,
            String initialisationVector,
            String digestAlgorithm,
            String signatureAlgorithm,
            String keyStore,
            String keyStoreType,
            String keyStorePasswd,
            String keyStoreAlias,
            String productOfferCode,
            String advertCode)
    {
        this.clock = clock;
        this.encoder = encoder;
        this.encryptAlgorithm = encyptAlgorithm;
        this.encryptTransport = encryptTransport;
        this.keyEncryptAlogrithm = keyEncryptAlogrithm;
        this.initialisationVector = initialisationVector;
        this.digestAlgorithm = digestAlgorithm;
        this.signatureAlgorithm = signatureAlgorithm;
        this.keyStore = keyStore;
        this.keyStoreType = keyStoreType;
        this.keyStorePasswd = keyStorePasswd;
        this.keyStoreAlias = keyStoreAlias;
        this.productOfferCode = productOfferCode;
        this.advertCode = advertCode;
    }

    /**
     * Orchestration method that builds a Map of all request query parameters
     * required to send a Bank of America credit card application request.
     * 
     * @param user          - User applying for the credit card
     * @param ariSeed       - Seed used to generate the ARI
     * @param ariType       - ARI type 1 = BFID, 2 = UID
     * @param callbackUrl   - URL for BOA to forward to on completion
     * @return Map containing request parameters and values
     */
    public String createDataPacket(UserTO user, long ariSeed, int ariType, String callbackUrl)
    {
        log.info( "createDataPacket start." );

        StringBuffer toSign = new StringBuffer();

        String sdp = null;


        // Url encode callbackUrl
        callbackUrl = URLEncoder.encode( callbackUrl );
        String userDataPacket = "";
        try
        {

            // Load O2 key pair
            KeyPair keys           = loadKeyPair();

            // load BAC public key
            PublicKey bac          = loadBACPublicKey();


            // Generate symmetric key
            SecretKey secret       = generateSecret();

            // Generate user data
            String data            = userToString(user);

            // Encrypt symmetric key
            String encryptedSecret = encryptSecret(secret, bac);

            // Encrypt the user data
            String encryptedUser   = encryptUserData(data, secret);


            long timestamp         = clock.currentTimeInMillis();


            // Create ARI
            String ari = generateARI(ariSeed, ariType);
            
            // Build the data packet to be signed
            userDataPacket =  createUserDataPacket( callbackUrl,  encryptedSecret, encryptedUser, timestamp, ari );

            // Sign the datapacket
            sdp = sign(userDataPacket, keys);

        }
        catch (IOException ioe)
        {
            throw new RuntimeException(ioe);
        } 
        catch (GeneralSecurityException gse)
        {
            throw new RuntimeException(gse);
        }


        // generate parameter values.
        String params = userDataPacket + SDP_PARAM_DELIMITER + SIGNED_DATA_PACKET + SDP_PARAM_OPERAND + sdp;

        log.debug( "Param string: " + params );

        log.info( "createDataPacket ends." );

        return params;
    }


    /***
     * Creates the datapacket that is to be signed.
     * @param callbackUrl
     * @param encryptedSecret
     * @param encryptedUser
     * @param timestamp
     * @param ari
     * @return
     */
    private String createUserDataPacket( String callbackUrl,  String encryptedSecret, String encryptedUser, long timestamp, String ari )
    {

        StringBuffer toSign = new StringBuffer();

        toSign.append(APPLICATION_REF);
        toSign.append(SDP_PARAM_OPERAND);
        toSign.append(ari);

        toSign.append( SDP_PARAM_DELIMITER );
        toSign.append( PRODUCT_OFFER_CODE );
        toSign.append( SDP_PARAM_OPERAND);
        toSign.append(productOfferCode);

        toSign.append( SDP_PARAM_DELIMITER );
        toSign.append( AD_CODE );
        toSign.append( SDP_PARAM_OPERAND );
        toSign.append(advertCode);

        toSign.append( SDP_PARAM_DELIMITER );
        toSign.append(CUSTOMER_DATA );
        toSign.append( SDP_PARAM_OPERAND );
        toSign.append(encryptedUser);

        toSign.append( SDP_PARAM_DELIMITER );
        toSign.append( ENCRYPTED_KEY );
        toSign.append( SDP_PARAM_OPERAND );
        toSign.append(encryptedSecret);

        toSign.append( SDP_PARAM_DELIMITER );
        toSign.append( RETURN_URL );
        toSign.append( SDP_PARAM_OPERAND );
        toSign.append(callbackUrl);

        toSign.append( SDP_PARAM_DELIMITER );
        toSign.append( DATE_TIME );
        toSign.append( SDP_PARAM_OPERAND );
        toSign.append(DT_PADDING.format(timestamp));

        toSign.append( SDP_PARAM_DELIMITER );
        toSign.append( PARTNER_KEY );
        toSign.append( SDP_PARAM_OPERAND );
        toSign.append(PARTNER_VALUE);

        return toSign.toString();

    }

    /**
     * Creates a new private key using the configured algorithm, this
     * will be used to encrypt the user data.  The BOA spec. states
     * that a new key is required for each request. 
     * 
     * @return SecretKey
     * @throws NoSuchAlgorithmException
     */
    protected SecretKey generateSecret()
    throws NoSuchAlgorithmException
    {
        log.info( "generateSecret start." );

        log.debug( "Generating key with algorithm: " + encryptAlgorithm );

        KeyGenerator keygen = KeyGenerator.getInstance(encryptAlgorithm);


        log.debug( "Key length: " + KEY_LENGTH );
        keygen.init(KEY_LENGTH);


        SecretKeySpec keySpec = new SecretKeySpec( keygen.generateKey().getEncoded(), "AES" );

//        log.debug( "Secret key (base64 encoded): " +  encoder.encode( keySpec.getEncoded() ) );

        log.info( "generateSecret ends." );

        return keySpec;

    }

    /**
     * Encrypts the string <i>userData</i> with the provided secret.
     * 
     * @param userData  - data string to be encrypted
     * @param secret    - private key
     * @return String - encrypted value
     * @throws GeneralSecurityException
     */
    protected String encryptUserData(String userData, SecretKey secret) 
    throws GeneralSecurityException
    {
        log.info( "encryptUserData start." );

        IvParameterSpec ivspec = new IvParameterSpec(initialisationVector.getBytes());

        log.debug( "Encrypt user data using " + encryptTransport);

        Cipher          cipher = Cipher.getInstance(encryptTransport);
        cipher.init(Cipher.ENCRYPT_MODE, secret, ivspec);

        byte[] cipherBytes =  cipher.doFinal( userData.getBytes() );

        String cipherText = encoder.encode( cipherBytes );

        // url encode
        cipherText = URLEncoder.encode( cipherText );


        log.info( "encryptUserData ends." );

        return cipherText;

    }

    /**
     * Encrypts the secret which in turn was used to encrypt the user data.
     * BOA's public key is used to encrypt the secret, this allows BOA to
     * decrypt the key using their private key, and use the result to
     * decrypt the user data.
     * 
     * @param secret    - Secret used to encrypt the user data
     * @param pub       - Public key to be used for encryption of the secret
     * @return String -encrypted key
     * @throws GeneralSecurityException
     * @throws IOException
     */
    protected String encryptSecret( SecretKey secret, PublicKey pub )
    throws GeneralSecurityException, 
           IOException
    {
        log.info( "encryptSecret start." );

        log.debug( "Encrypting secret key using: " + keyEncryptAlogrithm );

        Cipher cipher = Cipher.getInstance(keyEncryptAlogrithm);

        cipher.init(Cipher.ENCRYPT_MODE, pub);

        String encoded = encoder.encode( cipher.doFinal( secret.getEncoded() ) );

        // URL Encode
        encoded = URLEncoder.encode( encoded );

        log.debug( "Encoded EK: " + encoded );

        log.info( "encryptSecret ends." );

        return encoded;
    }

    /**
     * Signs a string of data with the private key from the
     * shared key pair.
     * 
     * This method creates a digest of the data and signs that
     * digest.
     * 
     * @param str   - string to be signed
     * @param keys  - key pair containing the private key to be used.
     * @return String - signed data.
     * @throws GeneralSecurityException
     */
    protected String sign(String str, KeyPair keys) 
    throws GeneralSecurityException
    {
        log.info( "sign start." );

        log.debug( "Data to sign: " + str );
        log.debug( "Signature Algorithm: " + signatureAlgorithm);

        Signature signature = Signature.getInstance( signatureAlgorithm );
        signature.initSign( keys.getPrivate() );
        signature.update( str.getBytes( ) );

        String encodedSignature = encoder.encode( signature.sign() );


        // url encode signature
        encodedSignature = URLEncoder.encode( encodedSignature );

        log.debug( "Encoded Signature: " + encodedSignature );

        log.info( "sign ends." );

        return encodedSignature;

//        MessageDigest md = MessageDigest.getInstance(digestAlgorithm);
//        md.update(str.getBytes());
//
//        Signature sig = Signature.getInstance(signatureAlgorithm);
//        sig.initSign(keys.getPrivate());
//        sig.update(md.digest());
//
//        return encoder.encode(sig.sign());
    }

    /**
     * Load the private/public key pair from our key store.
     * 
     * @return KeyPair
     * @throws GeneralSecurityException
     * @throws IOException
     */
    protected KeyPair loadKeyPair() 
    throws GeneralSecurityException, 
           IOException
    {
        log.info( "loadKeyPair start." );

        KeyPair     pair = null;
        InputStream is   = this.getClass().getResourceAsStream(keyStore);
        if (is != null)
        {
            KeyStore store = KeyStore.getInstance(keyStoreType);
            store.load(is, keyStorePasswd.toCharArray());
            Key key = store.getKey(keyStoreAlias, keyStorePasswd.toCharArray());
            if (key instanceof PrivateKey)
            {
                Certificate cert = store.getCertificate(keyStoreAlias);
                pair = new KeyPair(cert.getPublicKey(), (PrivateKey) key);
            }
        } 
        else
        {
        	RuntimeFinanceException error = new  RuntimeFinanceException(this.getClass(), "loadKeyPair" , "Cannot load keystore " + keyStore , null);
            log.error( error.getMessage(), error );
            throw error;
        }

        log.info( "loadKeyPair ends." );
        return pair;
    }

    /**
     * Load BOA's public key which will have been stored within a local
     * key store. 
     * 
     * @return PublicKey
     * @throws GeneralSecurityException
     * @throws IOException
     */
    protected PublicKey loadBACPublicKey() 
    throws GeneralSecurityException, 
           IOException
    {
        log.info( "loadBACPublicKey start." );

        PublicKey key = null;
        InputStream is = this.getClass().getResourceAsStream(bacKeyStore);
        if (is != null)
        {
            KeyStore store = KeyStore.getInstance(bacStoreType);
            store.load(is, bacStorePassword.toCharArray());
            Certificate cert = store.getCertificate(bacKeyAlias);
            key = cert.getPublicKey();
        } else
        {
            throw new RuntimeException("Unable to load keystore from [" + keyStore + "]");
        }

        log.debug( "BAC Public key (base64 encoded): " + encoder.encode( key.getEncoded() ) );

        log.info( "loadBACPublicKey ends." );

        return key;
    }

    /**
     * Generates the ARI from a seed.
     * 1. prepend integer representing ari type to seed
     * 2. append checksum (Luhn) to 1.
     * 3. convert 2 to to base36
     * 4. Left pad 3 with '0' characters
     * 

     * 
     * @param seed  user identifier
     * @param ariType Type of identifier
     * @return
     */
    protected String generateARI(long seed, int ariType)
    {
        log.info( "generateARI start." );

        log.debug( "O2 Reference Identifier type:  " + ariType);
        
        // prepend ariType
        String ari = Integer.toString( ariType ) + seed;


        // compute checksum and append
        String checksum = LuhnCalculator.generateCheckDigit( new BigInteger( ari ) );

        ari = ari + checksum;

        // base-36 encode
        ari = BaseConverter.toBase36( new BigInteger(ari) );

        // pad
        ari = org.apache.commons.lang.StringUtils.leftPad(ari, ARI_LENGTH);
        ari = ari.replace( ' ','0' );

        log.debug( "Padded ARI: " + ari );

        log.info( "generateARI ends." );

        return ari;
    }

    
    /**
     * Create user request parameter string as per the BOA specification document.
     * 
     * @param user
     * @return
     */
    protected String userToString(UserTO user)
    {

        log.info( "userToString start." );

        StringBuffer buff = new StringBuffer();
        buff.append("title=").append(getString(user.getTitle())).append(BAC_NAME_VALUE_DELIMITER);
        buff.append("firstName=").append(getString(user.getForename())).append(BAC_NAME_VALUE_DELIMITER);
        buff.append("Surname=").append(getString(user.getLastname())).append(BAC_NAME_VALUE_DELIMITER);
        buff.append("birthday=").append(Integer.toString(user.getBirthDay())).append(BAC_NAME_VALUE_DELIMITER);
        buff.append("birthMonth=").append(Integer.toString(user.getBirthMonth())).append(BAC_NAME_VALUE_DELIMITER);
        buff.append("birthYear=").append(Integer.toString(user.getBirthYear())).append(BAC_NAME_VALUE_DELIMITER);
        buff.append("email=").append(getString(user.getAlternativeEmail() )).append(BAC_NAME_VALUE_DELIMITER);
        buff.append("emailVerify=").append(getString(user.getAlternativeEmail())).append(BAC_NAME_VALUE_DELIMITER);
        String house = getString(user.getHouseNumber());
        if (house.length() == 0)
        {
            house = getString(user.getHouseName());
        }
        buff.append("findAddressHouseOrFlatNumberName=").append(house).append(BAC_NAME_VALUE_DELIMITER);
        buff.append("findAddressPostalCode=").append(getString(user.getPostcode())).append(BAC_NAME_VALUE_DELIMITER);
        buff.append("mobileno=").append(getString(user.getMsisdn())).append(BAC_NAME_VALUE_DELIMITER);
        buff.append("gender=").append(getString(user.getGender())).append(BAC_NAME_VALUE_DELIMITER);
        buff.append(user.getCustomerNumber() != null ? user.getCustomerNumber().toString() : "");
        log.debug("User data for handoff url [" + buff.toString() + "]");

        log.info( "userToString ends." );

        return buff.toString();
    }

    private void init()
    {
        log.info( "init start." );
        ApplicationProperties props = PropertyManager.getApplicationProperties();
        encryptAlgorithm            = props.getBacEncryptionAlgoritm();
        encryptTransport            = props.getBacEncryptionTransport();
        initialisationVector        = props.getBacEncryptionVector();
        keyEncryptAlogrithm         = props.getBacKeyEncryptionAlgoritm();
        digestAlgorithm             = props.getBacDigestAlgoritm();
        signatureAlgorithm          = props.getBacSignatureAlgoritm();
        keyStore                    = props.getO2KeyStore();
        keyStoreType                = props.getO2KeyStoreType();
        keyStorePasswd              = props.getO2KeyStorePasswd();
        keyStoreAlias               = props.getO2KeyAlias();
        productOfferCode            = props.getBoaProductOfferCode();
        advertCode                  = props.getBacAdvertCode();

        bacKeyStore                 = props.getBACPublicKeyStore();
        bacStoreType                = props.getBACPublicKeyStoreType();
        bacStorePassword            = props.getBACPublicKeyStorePasswd();
        bacKeyAlias                 = props.getBACPublicKeyAlias();



        log.info( "init ends." );
    }

    private String getString(String str)
    {
        return str != null ? str.trim() : "";
    }
}

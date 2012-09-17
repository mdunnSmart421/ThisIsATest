package com.o2.finance.external.boa;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;
import java.text.DecimalFormat;
import java.util.Iterator;


import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import sun.misc.BASE64Encoder;
import sun.misc.CharacterEncoder;

import com.o2.finance.model.UserTO;
import com.o2.finance.properties.PropertyManager;
import com.o2.finance.service.TimeService;
import com.o2.finance.util.BaseConverter;
import com.o2.finance.util.LuhnCalculator;

public class BACNameValuePairBuilderTest extends TestCase
{
    private BACNameValuePairBuilder bac;
    private TimeService             clock;
    private CharacterEncoder        encoder;

    protected void setUp() throws Exception
    {
        Provider rsaSupport = new BouncyCastleProvider();
        String   name       = rsaSupport.getName();
        
        Security.removeProvider(name);
        Security.addProvider(rsaSupport);
        
        clock = new TimeService()
        {
            public long currentTimeInMillis()
            {
                return 1234567890L;
            };
        };
        bac     = new BACNameValuePairBuilder(clock);
        encoder = new BASE64Encoder();
    }

    public void testLoadBACPublicKey() throws Exception
    {
        PublicKey key = bac.loadBACPublicKey();
        Assert.assertNotNull("Public Key is null", key);
    }

    public void testLoadKeyPair() throws Exception
    {
        KeyPair key = bac.loadKeyPair();
        Assert.assertNotNull("Key Pair is null", key);
        Assert.assertNotNull("Public Key is null", key.getPublic());
        Assert.assertNotNull("Private Key is null", key.getPrivate());
    }

    public void testGenerateSecret() throws Exception
    {
        String algorithm = PropertyManager.getApplicationProperties().getBacEncryptionAlgoritm();
        SecretKey key = bac.generateSecret();
        Assert.assertNotNull("SecretKey is null", key);
        Assert.assertEquals(algorithm, key.getAlgorithm());
    }

    public void testSecretEncryption() throws Exception
    {
        String algorithm = PropertyManager.getApplicationProperties().getBacEncryptionAlgoritm();
        String keyAlgorithm = PropertyManager.getApplicationProperties().getBacKeyEncryptionAlgoritm();
        
        KeyGenerator secgen = KeyGenerator.getInstance(algorithm);
        SecretKey secret = secgen.generateKey();
        
        KeyPairGenerator keygen = KeyPairGenerator.getInstance(keyAlgorithm);
        KeyPair keys = keygen.generateKeyPair();
        
        PublicKey pub = keys.getPublic();
        
        Cipher cipher = Cipher.getInstance(keyAlgorithm);
        cipher.init(Cipher.ENCRYPT_MODE, pub);
        cipher.update(secret.getEncoded());
        
        String expected = encoder.encode(cipher.doFinal());
        String actual = bac.encryptSecret(secret, pub);
        Assert.assertEquals(expected, actual);
    }

    public void testSign() throws Exception
    {
        String str = "my test string";
        String keyAlgorithm = PropertyManager.getApplicationProperties().getBacKeyEncryptionAlgoritm();
        String digest = PropertyManager.getApplicationProperties().getBacDigestAlgoritm();
        String signature = PropertyManager.getApplicationProperties().getBacSignatureAlgoritm();
        
        KeyPairGenerator keygen = KeyPairGenerator.getInstance(keyAlgorithm);
        KeyPair keys = keygen.generateKeyPair();
        
        MessageDigest md = MessageDigest.getInstance(digest);
        md.update(str.getBytes());
        
        Signature sig = Signature.getInstance(signature);
        sig.initSign(keys.getPrivate());
        sig.update(md.digest());
        
        String expected = encoder.encode(sig.sign());
        String actual = bac.sign(str, keys);
        Assert.assertEquals(expected, actual);
    }

    public void testEncryptUserData() throws Exception
    {
        Iterator itr = Security.getAlgorithms("Cipher").iterator();
        while (itr.hasNext())
        {
            System.out.println(itr.next());
        }
        
        String str = "my user data";
        String algorithm = PropertyManager.getApplicationProperties().getBacEncryptionAlgoritm();
        String transport = PropertyManager.getApplicationProperties().getBacEncryptionTransport();
        String vector = PropertyManager.getApplicationProperties().getBacEncryptionVector();
        
        KeyGenerator secgen = KeyGenerator.getInstance(algorithm);
        SecretKey secret = secgen.generateKey();
        
        Cipher cipher = Cipher.getInstance(transport);
        IvParameterSpec ivspec = new IvParameterSpec(vector.getBytes());
        
        cipher.init(Cipher.ENCRYPT_MODE, secret, ivspec);
        cipher.update(str.getBytes());
        
        String expected = encoder.encode(cipher.doFinal());
        String actual = bac.encryptUserData(str, secret);
        Assert.assertEquals(expected, actual);
    }

    public void testUserTOToString()
    {
        UserTO user = new UserTO();
        user.setTitle("Mr");
        user.setForename("Simon");
        user.setLastname("Watson");
        user.setBirthDay(3);
        user.setBirthMonth(1);
        user.setBirthYear(1968);
        user.setAccountManagerEmail("swatson@smart421.com");
        user.setHouseNumber("12");
        user.setPostcode("IP1 1PI");
        user.setMsisdn("447912000000");
        user.setGender("M");
        user.setCustomerNumber(new Integer(123456789));
        
        String expected = "title=Mr|firstName=Simon|Surname=Watson|birthday=3|"
                + "birthMonth=1|birthYear=1968|email=swatson@smart421.com|"
                + "emailVerify=swatson@smart421.com|findAddressHouseOrFlatNumberName=12|"
                + "findAddressPostalCode=IP1 1PI|mobileno=447912000000|gender=M|" + "123456789";
        String actual = bac.userToString(user);
        
        Assert.assertEquals(expected, actual);
    }

    public void testGenerateARI()
    {
        int    input      = 123456;
        String padded     = new DecimalFormat("0000000000000000000000").format(input);
        padded            = Integer.toString(BACNameValuePairBuilder.ARI_TYPE_UID) + padded;
        String checkDigit = LuhnCalculator.generateCheckDigit(new BigInteger(padded));
        padded            = padded + checkDigit;
        
        String expected   = BaseConverter.toBase36(new BigInteger(padded));
        String actual     = bac.generateARI(input, BACNameValuePairBuilder.ARI_TYPE_UID);
        
        Assert.assertEquals(expected, actual);
    }
    
    public void testCreateDataPacket() throws Exception
    {
        UserTO user = new UserTO();
        user.setTitle("Mr");
        user.setForename("Simon");
        user.setLastname("Watson");
        user.setBirthDay(3);
        user.setBirthMonth(1);
        user.setBirthYear(1968);
        user.setAccountManagerEmail("swatson@smart421.com");
        user.setHouseNumber("12");
        user.setPostcode("IP1 1PI");
        user.setMsisdn("447912000000");
        user.setGender("M");
        user.setCustomerNumber(new Integer(123456789));
        
        int    input      = 123456;
        String padded     = new DecimalFormat("0000000000000000000000").format(input);
        padded            = Integer.toString(BACNameValuePairBuilder.ARI_TYPE_UID) + padded;
        String checkDigit = LuhnCalculator.generateCheckDigit(new BigInteger(padded));
        padded            = padded + checkDigit;
        String ari        = BaseConverter.toBase36(new BigInteger(padded));

        String dt = new DecimalFormat("0000000000000000000").format(clock.currentTimeInMillis());
        String url = "http://callback.co.uk";
        String data = "title=Mr|firstName=Simon|Surname=Watson|birthday=3|"
                + "birthMonth=1|birthYear=1968|email=swatson@smart421.com|"
                + "emailVerify=swatson@smart421.com|findAddressHouseOrFlatNumberName=12|"
                + "findAddressPostalCode=IP1 1PI|mobileno=447912000000|gender=M|" + "123456789";
        
        String poc = PropertyManager.getApplicationProperties().getBoaProductOfferCode();
        String ad = PropertyManager.getApplicationProperties().getBacAdvertCode();
        
        StringBuffer str = new StringBuffer();
        str.append( "ARI=" ).append( ari ).append( "&" );
        str.append( "POC=" ).append( poc ).append( "&" );
        str.append( "AD=" ).append( ad ).append( "&" );
        str.append( "CD=" + "encrypted[" ).append( data ).append( "]" + "&" );
        str.append("EK=encrypted secret&");
        str.append( "RU=" ).append( url ).append( "&" );
        str.append( "DT=" ).append( dt ).append( "&" );
        str.append("PARTNER=INTERNET_ATT_O2");
        
        String keyAlgorithm = PropertyManager.getApplicationProperties().getBacKeyEncryptionAlgoritm();
        String digest = PropertyManager.getApplicationProperties().getBacDigestAlgoritm();
        String signatureAlgo = PropertyManager.getApplicationProperties().getBacSignatureAlgoritm();
        
        KeyPairGenerator keygen = KeyPairGenerator.getInstance(keyAlgorithm);
        final KeyPair keys = keygen.generateKeyPair();
        
//        MessageDigest md = MessageDigest.getInstance(digest);
//        md.update(str.toString().getBytes());
        
        Signature sig = Signature.getInstance(signatureAlgo);
        sig.initSign(keys.getPrivate());
        sig.update(str.toString().getBytes());

        String signature = encoder.encode(sig.sign());
        signature = URLEncoder.encode(signature);

        String expected = str.append("&SDP=").append( signature ).toString();

//        Map map = new LinkedHashMap();
//        map.put("ARI", ari);
//        map.put("POC", poc);
//        map.put("AD", ad);
//        map.put("SDP", expected);
//        map.put("CD", "encrypted[" + data + "]");
//        map.put("EK", "encrypted secret");
//        map.put("RU", url);
//        map.put("DT", dt);
//        map.put("PARTNER", "INTERNET_ATT_O2");
        
        bac = new BACNameValuePairBuilder(clock)
        {
            protected String encryptSecret(SecretKey secret, PublicKey pub) 
            throws GeneralSecurityException, IOException
            {
                return "encrypted secret";
            }

            protected String encryptUserData(String userData, SecretKey secret) 
            throws GeneralSecurityException
            {
                return "encrypted[" + userData + "]";
            }

            protected KeyPair loadKeyPair() 
            throws GeneralSecurityException, IOException
            {
                return keys;
            }
        };


        // TODO - fix test




//
//        String actual = bac.createDataPacket(user, 123456, BACNameValuePairBuilder.ARI_TYPE_UID, url);
//        Assert.assertEquals(expected    , actual);
    }
}

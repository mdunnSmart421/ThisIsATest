package com.o2.finance.properties;

import java.util.List;

import com.certicom.net.ssl.internal.GetIntegerAction;

/**
 * Purpose: com.o2.finance.properties User: D Smith Date: 17/03/2011
 */
public class ApplicationProperties extends FinanceProperties
{
    private static final String FILE_LOCATION = "/finance/application.properties";
    private final static String AUTH_LOCATION = "authorise.from.request";
    
    private final static String AXIS2_CONFIG                  = "axis2.config";
    private final static String AXIS2_REPOSITORY              = "axis2.repository";
    private final static String AXIS2_RAMPART_POLICY          = "axis2.rampart.policy";

    private final static String PAA_SERVICE_END_POINT         = "paa.service.end.point";
    private final static String PAA_AUTH_TOKEN_COOKIE         = "paa.auth.token.cookie";
    private final static String PAA_AUTH_USERID_COOKIE        = "paa.auth.userid.cookie";
    private final static String PAA_WS_SECURITY_ON            = "paa.auth.ws.security.on";
    private final static String PAA_WS_SECURITY_USERNAME      = "paa.auth.ws.security.username";
    private final static String PAA_WS_SECURITY_PASSWD        = "paa.auth.ws.security.passwd";

    private final static String TWO_WAY_SSL_KEYSTORE          = "two.way.ssl.keystore";
    private final static String TWO_WAY_KEYSTORE_PASSWD       = "two.way.ssl.keystore.passwd";
    private final static String TWO_WAY_TRUSTED_STORE         = "two.way.ssl.trusted.store";
    private final static String TWO_WAY_CLIENT_KEY_FILE       = "two.way.ssl.identity.key.file";
    private final static String TWO_WAY_CLIENT_KEY_PASSWORD   = "two.way.ssl.identity.key.password";



    private final static String TWO_WAY_TRUSTED_STORE_PASSWD  = "two.way.ssl.trusted.store.passwd";
    private final static String TWO_WAY_CHECK_HOST            = "two.way.ssl.check.host.name";
    
    private final static String REGISTRATION_DOMAIN_KEY = "registration.domain";
    private final static String CUSTCARE_SEARCH_LIMIT_KEY = "custcare.search.limit";
    private final static String SEARCH_CUSTOMER_BY_MSISND_COUNT_KEY = "search.customer.by.msisdn.count";
    private final static String REGISTRATION_CANCEL_PROTOCOL = "registration.cancel.link.protocol.setting";
    private final static String REGISTRATION_CANCEL_URL = "registration.cancel.link.setting";
    private final static String SEND_VERIFICATON_WAIT = "verification.code.max.wait.minutes";
    private final static String O2_LOGIN_PAGE_URL = "o2.login.page.url";
    private final static String AVATAR_SERVICE_END_POINT = "avatar.service.end.point";
    private final static String OTAC_SERVICE_END_POINT = "otac.service.end.point";
    private final static String PAF_SERVICE_END_POINT = "paf.service.end.point";
    private final static String REGISTRATION_SERVICE_END_POINT = "registration.service.end.point";
    private final static String REGISTRATION_SERVICE_XML_DATE_FORMAT = "registration.service.xml.date.format";
    private final static String O2_KEY_STORE = "o2.key.store";
    private final static String O2_KEY_STORE_TYPE = "o2.key.store.type";
    private final static String O2_KEY_STORE_PASSWD = "o2.key.store.password";
    private final static String O2_KEY_ALIAS = "o2.key.store.alias";
    private final static String BAC_PUBLIC_KEY_STORE = "bac.public.key.store";
    private final static String BAC_PUBLIC_KEY_STORE_TYPE = "bac.public.key.store.type";
    private final static String BAC_PUBLIC_KEY_STORE_PASSWD = "bac.public.key.store.password";
    private final static String BAC_PUBLIC_KEY_ALIAS = "bac.public.key.store.alias";
    private final static String BAC_DIGEST_ALGORITHM = "bac.digest.algorithm";
    private final static String BAC_SIGNATURE_ALGORITHM = "bac.signature.algorithm";
    private final static String BAC_ENCRYPTION_ALGORITHM = "bac.encrypt.algorithm";
    private final static String BAC_KEY_ENCRYPTION_ALGORITHM = "bac.key.encrypt.algorithm";
    private final static String BAC_ENCRYPTION_VECTOR = "bac.encrypt.vector";
    private final static String BAC_ENCRYPTION_TRANSPORT = "bac.encrypt.transport";
    private final static String BOA_POC = "boa.product.offer.code";
    private final static String BOA_AD = "boa.advert.code";
    private final static String SMS_SERVICE_ENDPOINT = "sms.service.end.point";
    private final static String SMS_SERVICE_TTL = "sms.service.ttl";
    private final static String SMS_SERVICE_RECEIPT_URL = "sms.service.receipt.url";
    private final static String SMS_SERVICE_MT_PROFILE = "sms.service.mt.profile";
    private final static String SMS_SERVICE_MESSAGE_TYPE = "sms.service.message.type";
    private final static String SMS_SERVICE_APPLICATION_REFERENCE = "sms.service.application.reference";
    private final static String O2_LOGIN_NEW_USER_URL = "o2.login.new.user.url";
    private final static String O2_LOGIN_NEW_USER_RETURN_URL = "o2.login.new.user.return.url";
    private final static String O2_LOGIN_NEW_USER_FAILURE_URL = "o2.login.new.user.failure.url";
    private final static String ONLINE_CUSTOMER_SERVICE_ENDPOINT = "onlineCustomer.service.end.point";
    private final static String ONLINE_WS_SECURITY_ON = "onlineCustomer.auth.ws.security.on";
    private final static String ONLINE_WS_SECURITY_USERNAME = "onlineCustomer.auth.ws.security.username";
    private final static String ONLINE_WS_SECURITY_PASSWD = "onlineCustomer.auth.ws.security.passwd";

    private final static String SOA_WS_SECURITY_ON = "soa.auth.security.on";
    private final static String SOA_WS_SECURITY_USERNAME = "soa.auth.security.username";
    private final static String SOA_WS_SECURITY_PASSWORD = "soa.auth.security.passwd";

    private final static String SMS_SEND_MESSAGE = "sms.send.message";

    private final static String SPLASH_URI = "splash.uri";
    private final static String SPLASH_WHITELIST = "splash.whitelist";
    private final static String SPLASH_ALL_KEYWORD = "splash.all.keyword";
    private final static String SPLASH_ALL_MOBILE_KEYWORD = "splash.all.mobile.keyword";
    private final static String SPLASH_PAGE_URL = "splash.page.url";
    
    private final static String ORANGE_SEARCH_SERVICE_ENDPOINT = "orange.search.service.end.point";    
    private final static String ORANGE_SEARCH_SERVICE_WS_SECURITY_PASSWORD = "orange.search.service.ws.security.password";
    private final static String ORANGE_SEARCH_SERVICE_IDENTITIES_EXCEEDED_ERROR_CODE = "orange.search.service.identities.exceeded.error.code";

    protected String getPropertyFile()
    {
        return FILE_LOCATION;
    }

    public String getO2LoginPageUrl()
    {
        return getProperty(O2_LOGIN_PAGE_URL);
    }

    public boolean getAuthFromRequest()
    {
        return getBooleanProperty(AUTH_LOCATION);
    }

    public String getRegistrationDomain()
    {
        return getProperty(REGISTRATION_DOMAIN_KEY);
    }

    public int getCustCareSearchLimit()
    {
        return getIntProperty(CUSTCARE_SEARCH_LIMIT_KEY);
    }

    public int getSearchCustomerByMsisdnCount()
    {
        return getIntProperty(SEARCH_CUSTOMER_BY_MSISND_COUNT_KEY);
    }

    public String getPaaServiceEndPoint()
    {
        return getProperty(PAA_SERVICE_END_POINT);
    }

    public String getPaaAuthTokenCookie()
    {
        return getProperty(PAA_AUTH_TOKEN_COOKIE);
    }

    public String getPaaAuthUserIdCookie()
    {
        return getProperty(PAA_AUTH_USERID_COOKIE);
    }

    public boolean getPaaWsSecurityOn()
    {
        return getBooleanProperty(PAA_WS_SECURITY_ON);
    }
    
    public String getPaaWsSecurityUsername()
    {
        return getProperty(PAA_WS_SECURITY_USERNAME);
    }
    
    public String getPaaWsSecurityPasswd()
    {
        return getProperty(PAA_WS_SECURITY_PASSWD);
    }

    public String getTwoWaySSLClientKeystore()
    {
        return getProperty(TWO_WAY_SSL_KEYSTORE);
    }

    public String getTwoWaySSLClientKeystorePasswd()
    {
        return getProperty(TWO_WAY_KEYSTORE_PASSWD);
    }

    public String getTwoWaySSLClientTrustedStore()
    {
        return getProperty(TWO_WAY_TRUSTED_STORE);
    }

    public String getTwoWaySSLClientTrustedStorePasswd()
    {
        return getProperty(TWO_WAY_TRUSTED_STORE_PASSWD);
    }

    public boolean getTwoWaySSLClientCheckHostname()
    {
        return getBooleanProperty(TWO_WAY_CHECK_HOST);
    }

    public String getRegistrationCancelProtocol()
    {
        return getProperty(REGISTRATION_CANCEL_PROTOCOL);
    }

    public String getRegistrationCancelUrl()
    {
        return getProperty(REGISTRATION_CANCEL_URL);
    }

    public String getOtacServiceEndPoint()
    {
        return getProperty(OTAC_SERVICE_END_POINT);
    }

    public String getPafServiceEndPoint()
    {
        return getProperty(PAF_SERVICE_END_POINT);
    }

    public int getSendVerificationWait()
    {
        return getIntProperty(SEND_VERIFICATON_WAIT);
    }

    public String getAvatarServiceEndPoint()
    {
        return getProperty(AVATAR_SERVICE_END_POINT);
    }

    public String getRegistrationServiceXmlDateFormat()
    {
        return getProperty(REGISTRATION_SERVICE_XML_DATE_FORMAT);
    }

    public String getRegistrationServiceEndPoint()
    {
        return getProperty(REGISTRATION_SERVICE_END_POINT);
    }

    public String getBACPublicKeyStore()
    {
        return getProperty(BAC_PUBLIC_KEY_STORE);
    }

    public String getBACPublicKeyStoreType()
    {
        return getProperty(BAC_PUBLIC_KEY_STORE_TYPE);
    }

    public String getBACPublicKeyStorePasswd()
    {
        return getProperty(BAC_PUBLIC_KEY_STORE_PASSWD);
    }

    public String getBACPublicKeyAlias()
    {
        return getProperty(BAC_PUBLIC_KEY_ALIAS);
    }

    public String getBacDigestAlgoritm()
    {
        return getProperty(BAC_DIGEST_ALGORITHM);
    }

    public String getBacSignatureAlgoritm()
    {
        return getProperty(BAC_SIGNATURE_ALGORITHM);
    }

    public String getBacEncryptionAlgoritm()
    {
        return getProperty(BAC_ENCRYPTION_ALGORITHM);
    }

    public String getBacKeyEncryptionAlgoritm()
    {
        return getProperty(BAC_KEY_ENCRYPTION_ALGORITHM);
    }

    public String getBacEncryptionVector()
    {
        return getProperty(BAC_ENCRYPTION_VECTOR);
    }

    public String getBacEncryptionTransport()
    {
        return getProperty(BAC_ENCRYPTION_TRANSPORT);
    }

    public String getBoaProductOfferCode()
    {
        return getProperty(BOA_POC);
    }

    public String getBacAdvertCode()
    {
        return getProperty(BOA_AD);
    }

    public String getO2KeyStore()
    {
        return getProperty(O2_KEY_STORE);
    }

    public String getO2KeyStoreType()
    {
        return getProperty(O2_KEY_STORE_TYPE);
    }

    public String getO2KeyStorePasswd()
    {
        return getProperty(O2_KEY_STORE_PASSWD);
    }

    public String getO2KeyAlias()
    {
        return getProperty(O2_KEY_ALIAS);
    }

    public String getSmsServiceEndpoint()
    {
	return getProperty(SMS_SERVICE_ENDPOINT);
    }
    
    public String getSmsServiceTtl()
    {
    	return getProperty(SMS_SERVICE_TTL);
    }
    
    public String getSmsServiceReceiptUrl()
    {
	return getProperty(SMS_SERVICE_RECEIPT_URL);
    }
    
    public String getSmsServiceMtProfile()
    {
	return getProperty(SMS_SERVICE_MT_PROFILE);
    }
    
    public String getSmsServiceMessageType()
    {
	return getProperty(SMS_SERVICE_MESSAGE_TYPE);
    }
    
    public String getSmsServiceApplicationReference()
    {
	return getProperty(SMS_SERVICE_APPLICATION_REFERENCE);
    }

    public String getAxis2Config()
    {
        return getProperty(AXIS2_CONFIG);
    }

    public String getAxis2Repository()
    {
        return getProperty(AXIS2_REPOSITORY);
    }

    public String getAxis2RampartPolicy()
    {
        return getProperty(AXIS2_RAMPART_POLICY);
    }


    public String getNewUserPostLoginUrl()
    {
        return getProperty( O2_LOGIN_NEW_USER_URL );
    }
    
    public String getNewUserPostLoginReturnUrl()
    {
        return getProperty( O2_LOGIN_NEW_USER_RETURN_URL );
    }
    
    public String getNewUserPostLoginFailureUrl()
    {
        return getProperty( O2_LOGIN_NEW_USER_FAILURE_URL );
    }

    public String getOnlineCustomerServiceEndpoint()
    {
        return getProperty( ONLINE_CUSTOMER_SERVICE_ENDPOINT );
    }


    public boolean getOnlineWsSecurityOn()
    {
        return getBooleanProperty( ONLINE_WS_SECURITY_ON );
    }

    public String getOnlineWsSecurityUsername()
    {
        return getProperty( ONLINE_WS_SECURITY_USERNAME );
    }

    public String getOnlineWsSecurityPasswd()
    {
        return getProperty( ONLINE_WS_SECURITY_PASSWD );
    }

    public boolean getSoaWsSecurityOn()
    {
        return getBooleanProperty( SOA_WS_SECURITY_ON );
    }


    public String getSoaWsSecurityUsername()
    {
        return getProperty( SOA_WS_SECURITY_USERNAME );
    }

    public String getSoaWsSecurityPassword()
    {
        return getProperty( SOA_WS_SECURITY_PASSWORD );
    }

    public String getTwoWayClientKeyFile()
    {
        return getProperty(TWO_WAY_CLIENT_KEY_FILE);
    }


    public String getTwoWayClientKeyPassword()
    {
        return getProperty( TWO_WAY_CLIENT_KEY_PASSWORD );
    }


    public boolean getSendMessage()
    {
        return getBooleanProperty(SMS_SEND_MESSAGE, "true" );
    }

    /**
     * Returns the URI that triggers the splash file reload
     * @return String URI
     */
    public String getSplashUri()
    {
	return getProperty(SPLASH_URI);
    }
    
    /**
     * Returns the property value showing all IP addresses allowed to splash
     * @return String of IP addresses
     */
    public String getSplashWhitelist()
    {
	return getProperty(SPLASH_WHITELIST);
    }
    
    /**
     * Returns the comma separated list of IP addresses allowed to splash
     * @return List of IP addresses
     */
    public List getSplashWhiteListList()
    {
	return getListProperty(SPLASH_WHITELIST);
    }

    /**
     * Returns keyword used to determine if all of a product or device should be splashed
     * @return the splashAllKeyword
     */
    public String getSplashAllKeyword()
    {
        return getProperty(SPLASH_ALL_KEYWORD);
    }
    
    /**
     * Returns keyword used to determine if all mobile devices should be splashed
     * @return the splashAllKeyword
     */
    public String getSplashAllMobileKeyword()
    {
        return getProperty(SPLASH_ALL_MOBILE_KEYWORD);
    }

    /**
     * Returns url for the location of the splash page
     * @return the splashPageUrl
     */
    public String getSplashPageUrl()
    {
        return getProperty(SPLASH_PAGE_URL);
    }

    /**
     * Returns the Orange Search Service Endpoint URL
     * @return the Orange Search Service Endpoint URL
     */
	public String getOrangeSearchServiceEndpoint() {
		return getProperty(ORANGE_SEARCH_SERVICE_ENDPOINT);
	}

	/**
	 * Returns the Orange Search Service WS security password
	 * @return the Orange Search Service WS security password
	 */
	public String getOrangeSearchServiceWsSecurityPassword() {
		return getProperty(ORANGE_SEARCH_SERVICE_WS_SECURITY_PASSWORD);
	}
	
	/**
	 * Returns the error code associated with Orange Search Service Identities limit exceeded
	 * @return the error code associated with Orange Search Service Identities limit exceeded
	 */
	public String getOrangeSearchServiceIdentitiesExceededErrorCode() {
		return getProperty(ORANGE_SEARCH_SERVICE_IDENTITIES_EXCEEDED_ERROR_CODE);
	}
            
}

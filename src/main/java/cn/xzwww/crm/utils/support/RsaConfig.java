package cn.xzwww.crm.utils.support;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RsaConfig {
	
	private static String rsaPrivateKey;
	private static String rsaPublicKey;
	private static String rsaPartnerId;
	
	@Value("#{config['rsa.private.key']}")
	private static void setRsaPrivateKey(String rsaPrivateKey) {
		RsaConfig.rsaPrivateKey = rsaPrivateKey;
	}
	
	@Value("#{config['rsa.public.key']}")
	private static void setRsaPublicKey(String rsaPublicKey) {
		RsaConfig.rsaPublicKey = rsaPublicKey;
	}
	
	@Value("#{config['partner.id']}")
	private static void setRsaPartnerId(String rsaPartnerId) {
		RsaConfig.rsaPartnerId = rsaPartnerId;
	}

	public static String getRsaPrivateKey() {
		return rsaPrivateKey;
	}

	public static String getRsaPublicKey() {
		return rsaPublicKey;
	}

	public static String getRsaPartnerId() {
		return rsaPartnerId;
	}
	
}

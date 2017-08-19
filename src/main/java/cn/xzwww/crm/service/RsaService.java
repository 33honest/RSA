package cn.xzwww.crm.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.xzwww.crm.utils.RSAUtils;

@Service
public class RsaService {
	
	@Value("#{config['rsa.private.key']}")
	private String rsaPrivateKey;
	
	@Value("#{config['rsa.public.key']}")
	private String rsaPublicKey;
	
	public String getPrivateKey(){
		
		return rsaPrivateKey;
	}
	
	public String sign(String data){
		String sign = null;
		
		try {
			sign = RSAUtils.sign(data.getBytes(), rsaPrivateKey);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sign;
	}
	
	public boolean verify(String sign, String data){
		boolean status = false;
		
		try {
			status = RSAUtils.verify(data.getBytes(), rsaPublicKey, sign);
			return status;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
	
}

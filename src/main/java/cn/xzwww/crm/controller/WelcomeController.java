package cn.xzwww.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xzwww.crm.service.RsaService;
import cn.xzwww.crm.utils.support.RsaConfig;

@Controller
@RequestMapping("/")
public class WelcomeController {
	
	@Autowired
	private RsaService rsaService;
	
	@RequestMapping("welcome")
	@ResponseBody
	public String welcome(){
		
//		String rsaPrivateKey = rsaService.getPrivateKey();
//    	System.out.println(rsaPrivateKey);
		String source = "{\"gmt_create\":\"20170813171542\",\"gmt_payment\":\"20170813171542\",\"inner_trade_no\":\"101150261479727862926\",\"notify_type\":\"trade_status_sync\",\"outer_trade_no\":\"4995264-1\",\"trade_amount\":\"485.00\",\"trade_status\":\"PAY_FINISHED\",\"version\":\"1.0\"}";
		
		String sign = rsaService.sign(source);
		System.out.println("签名：" + sign);
		
		boolean verify = rsaService.verify(sign, source);
		System.out.println("校验结果：" + verify);
		
		return "Welcome";
	}
	
}

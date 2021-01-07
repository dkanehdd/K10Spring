package com.kosmo.k10spring;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import env.UserConnection;

@Controller
public class EnvironmentController {

	@RequestMapping("/environment/main1")
	public String main1(Model model) {
		//1.스프링 컨테이너 생성
		ConfigurableApplicationContext ctx =
				new GenericXmlApplicationContext();
		//2.Environment객체 생성
		ConfigurableEnvironment env = ctx.getEnvironment();
		//3.외부파일을 읽어올 준비를 한다.
		MutablePropertySources propertySources = 
				env.getPropertySources();
		
		String adminIdStr = "";
		String adminPwStr = "";
		
		try {
			//4. 외부파일의 경로를 지정한후 addLast()로 프로퍼티소스를 추가한다.
			String envPath = "classpath:EnvAdmin.properties";
			propertySources.addLast(new ResourcePropertySource(envPath));
			//5. 파일의 내용을 읽어 변수에 저장한다.
			adminIdStr = env.getProperty("admin.id");
			adminPwStr = env.getProperty("admin.pw");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("adminID", adminIdStr);
		model.addAttribute("adminPW", adminPwStr);
		
		return "05Environment/main1";
	}
	
	@RequestMapping("/environment/main2")
	public String main2(Model model) {
		
		AbstractApplicationContext ctx  =
				new GenericXmlApplicationContext("classpath:EnvAppCtx.xml");
		
		UserConnection userCon = 
				ctx.getBean("userConnection", UserConnection.class);
		
		model.addAttribute("mainUserId", userCon.getMainUserId());
		model.addAttribute("mainUserPw", userCon.getMainUserPw());
		model.addAttribute("subUserId", userCon.getSubUserId());
		model.addAttribute("subUserPw", userCon.getSubUserPw());
		
		return "05Environment/main2";
	}
}

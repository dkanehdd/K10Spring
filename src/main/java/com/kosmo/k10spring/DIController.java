package com.kosmo.k10spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import di.AppConfiguration;
import di.AvengersInfo;
import di.AvengersVO;
import di.BMIInfoView;
import di.CalculatorDTO;

@Controller
public class DIController {

	//DI를 이용한 간단한 사칙연산 계산기 구현
	@RequestMapping("/di/myCalculator")
	public String myCal(Model model) {
		
		/*
		ApplicationContext파일의 위치를 문자열에 저장한다.
		물리적경로는 /src/main/resources 디렉토리 하위이다.
		webapp하위의 resources 디렉토리와 혼동하지 않도록 주의한다.
		 */
		String configLocation = "classpath:DIAppCtxCalculator.xml";
		
		/*
		스프링컨테이너 생성 : xml파일을 파싱하여 파싱된 내용을 기반으로
		 ctx참조변수를 생성한다.
		*/
		AbstractApplicationContext ctx =
				new GenericXmlApplicationContext(configLocation);
		
		/*
		XMl설정파일에서 생성한 빈을 getBean()을 통해 주입받아 참조변수에 할당한다.
		new 연산자를 통해 생성한것과 동일하지만 외부 설정파일에서
		미리 생성한것을 주입(injection)받아 사용하고 있다.
		 */
		CalculatorDTO myCal = 
				ctx.getBean("myCal", CalculatorDTO.class);
		/*
		주입받은 빈을 통해 사칙연산을 수행하고, 결과값을 model객체에 
		저장한 후 view로 전달한다.
		 */
		model.addAttribute("addResult", myCal.add());
		model.addAttribute("subResult", myCal.sub());
		model.addAttribute("mulResult", myCal.mul());
		model.addAttribute("divResult", myCal.div());
		
		return "04DI/myCalculator";
	}
	//체질량 지수 계산하기
	@RequestMapping("/di/myBMICal")
	public String bmiCal(Model model) {
		//xml 설정파일을 기반으로 스프링 컨테이너 생성
		String configLoc = "classpath:DIAppCtxBMICal.xml";
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext(configLoc);
		//빈 주입
		BMIInfoView myInfo = ctx.getBean("myInfo", BMIInfoView.class);
		ctx.close();
		//빈을 통한 메소드 호출 및 결과 저장
		String myBMIResult = myInfo.getInfo();
		model.addAttribute("myBMIResult", myBMIResult);
		
		return "04DI/myBMICal";
	}
	
	@RequestMapping("/di/myAvengers")
	public ModelAndView myAvengers() {
		
		String configLocation = "classpath:DIAppCtxAvengers.xml";
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext(configLocation);
		
		//캡틴 빈을 주입받은후 정보출력을 위해 문자열을 저장함
		AvengersInfo avengersInfo = ctx.getBean("AvengersInfo1", AvengersInfo.class);
		String captainAmerica = avengersInfo.AvengersView();
		
		//아이언맨 빈을 주입받은후 정보출력을 위해 setter를 호출한다.
		AvengersVO avengers = ctx.getBean("hero2", AvengersVO.class);
		avengersInfo.setAvengers(avengers);
		String ironMan = avengersInfo.AvengersView();
		
		//model객체에 정보저장과 뷰에대한 설정을 동시에 처리
		ModelAndView mv = new ModelAndView();
		mv.setViewName("04DI/myAvengers");
		mv.addObject("captainAmerica", captainAmerica);
		mv.addObject("ironMan", ironMan);
		//컨테이너 해제
		ctx.close();
		
		return mv;
	}
	@RequestMapping("/di/myAnnotation")
	public ModelAndView myAnnotation() {
		
		//빈을 생성할 Java파일을 가져와서 스프링 컨테이너를 생성한다.
		AnnotationConfigApplicationContext aCtx = 
				new AnnotationConfigApplicationContext(AppConfiguration.class);
		//빈을 주입받음
		BMIInfoView mem1 = aCtx.getBean("member1", BMIInfoView.class);
		//출력할 문자열 처리
		String str1 = "이름:" + mem1.getName()+"<br/>";
		str1 += "취미:"+mem1.getHobbys()+"<br/>";
		str1 += "신장:"+mem1.getHeight()+"<br/>";
		str1 += "몸무게:"+mem1.getWeight()+"<br/>";
		str1 += "BMI결과 : "+ mem1.bmiCalculation();
		
		BMIInfoView mem2 = 
				aCtx.getBean("member2", BMIInfoView.class);
		String str2 = "이름:" + mem2.getName()+"<br/>";
		str2 += "취미:"+mem2.getHobbys()+"<br/>";
		str2 += "신장:"+mem2.getHeight()+"<br/>";
		str2 += "몸무게:"+mem2.getWeight()+"<br/>";
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("memberInfo1", str1);
		mv.addObject("memberInfo2", str2);
		
		mv.setViewName("04DI/myAnnotation");
		return mv;
	}
}

package com.kosmo.k10spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	/*
	Step2 : 요청명을 통해 컨트롤러를 찾아 매필된 메소드를 호출한다.
		컨트롤러에서는 매핑명을 통해 메소드를 호출하므로 메소드명은
		중복되지 않는 정도의 이름을 사용하면 된다.
	 */
	@RequestMapping("/home/helloSpring")
	public String helloSpring(Model model) {
		
		/*
		Spring에서는 4가지 영영과 비슷한 model객체를 사용해서 속성을 저장한다.
		사용법은 거의 비슷하다.
		 */
		String firstMessage = "My First SPRING MVC 컨트롤러";
		model.addAttribute("firstMessage", firstMessage);
		
		/*
		View의 이름을 반환한다. 해당 뷰의 이름은 ViewResolver가 조립하여
		최종적으로 뷰를 웹브라우저에 출력한다. 
		*/
		return "HelloSpring";
	}
	
	
}

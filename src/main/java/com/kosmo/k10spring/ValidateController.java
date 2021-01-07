package com.kosmo.k10spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import common.MemberDTO;
import common.MemberValidator;

@Controller
public class ValidateController {
	
	//회원가입 페이지 매핑
	@RequestMapping("/validate/memberRegist.do")
	public String memberRegist() {
		return "03Validate/memberRegist";
	}
	
	//회원가입페이지의 폼값을 전송받아 검증하는 메소드
	@RequestMapping("/validate/registProc.do")
	public String registProc(
			@ModelAttribute("mInfo") MemberDTO memberDTO,
			BindingResult result,
			Model model
			) {
		/*
		파라미터 첫번째 : 폼값을 커맨드객체를 통해 한번에 받은후 어노테이션으로
			모델객체에 저장시의 속성값을 변경함.
		두번째 : BindingResult객체는 validator를 통해 폼값을 검증한 후
			해당 결과를 전송받을 객체로, 폼값에 문제가 있다면 해당 객체를 통해
			확인할 수 있다.
		세번째 : 데이터를 저장할 Model객체
		 */
		
		//폼값 검증 완료시 이동할 페이지의 경로
		String viewPage = "03Validate/memberDone";
		/*
		유효성 검증을 위해 정의한 클래스의 객체를 생성한 후 전송된
		폼값을 저장한 커맨드객체를 통해 폼값의 유효성 체크를 실시한다.
		매개변수로 유효성체크를 할 커맨드객체와 바인딩결과(검증결과)를
		저장한 객체를 인자로 전달한다.
		 */
		MemberValidator validator = new MemberValidator();
		validator.validate(memberDTO, result);
		
		if(result.hasErrors()) {
			System.out.println("유효성 체크 실패 :"+result.toString());
			//검증 실패의 경우 model객체에 에러메세지를 저장한 후
			model.addAttribute("formError","폼값 유효성체크에 실패하였습니다.");
			//가입페이지로 다시 돌아간다.
			viewPage = "03Validate/memberRegist";
		}
		return viewPage;
	}
}

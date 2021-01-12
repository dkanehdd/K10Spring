package component.scan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
컨트롤러와 모델사이의 중재자 역학을 하는 서비스객체라는 뜻으로 붙히는 어노테이션.
명시적인 의미이며, servlet-context.xml에 component-scan에
추가되어 있으면 스프링이 시작될때 자동으로 빈이 생성된다.
 */
@Service
public class MyService {

	public MyService() {
		System.out.println("MyService 생성자호출");
	}
	
	//DAO객체를 자동주입받는다.
	MyDAO myDAO;
	@Autowired
	public void setMyDAO(MyDAO myDAO) {
		this.myDAO = myDAO;
		System.out.println("setMyDAO()호출-MyService");
	}
	
	public void execute() {
		myDAO.selectList();
	}
}

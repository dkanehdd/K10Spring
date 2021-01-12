package component.scan;

import org.springframework.stereotype.Repository;

/*
저장소의 역할을 하는 객체라는 뜻으로 붙히는 어노테이션.
명시적인 의미이며, servlet-context.xml에 component-scan에
추가되어 있으면 스프링이 시작될때 자동으로 빈이 생성된다.
 */
@Repository
public class MyDAO {

	public MyDAO() {
		System.out.println("MyDAO생성자 호출");
	}
	
	public void selectList() {
		System.out.println("리스트를 출력합니다.");
	}
}

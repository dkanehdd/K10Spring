package env;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/*
XML설정파일의 역할을 대신하는 클래스로 정의한다.
 */
@Configuration
public class EnvApplicationConfig {

	
	//@value : 멤버변수 초기값을 어노테이션으로 정의한다.
	@Value("${board1.user}") //프로퍼티 파일의 속성을 EL로 표현함.
	private String board_user;
	
	@Value("${board1.pass}")
	private String board_pass;
	
	@Value("${board2.driver}")
	private String board_driver;
	
	@Value("${board2.url}")
	private String board_url;
	
	/*
	외부파일의 경로 설정 및 읽어오기
	*/
	@Bean
	public static PropertySourcesPlaceholderConfigurer Properties() {
		//1. 프로퍼티 파일을 읽어오기 위한 객체생성
		PropertySourcesPlaceholderConfigurer config = 
				new PropertySourcesPlaceholderConfigurer();
		//2. 프로퍼티 파일의 위치를 설정하기 위한 Resource타입의 객체 생성
		Resource[] locations = new Resource[2];
		// classpath:설정파일.xml 과 동일한 설정
		locations[0] = new ClassPathResource("EnvBoard1.properties");
		locations[1] = new ClassPathResource("EnvBoard2.properties");
		
		//3.설정된 위치의 config참조변수의 매개변수로 파일을 읽어옴
		config.setLocations(locations);
		return config;
	}
	
	//프로퍼티 소스를 통해 읽어온 값으로 빈을 생성함
	@Bean
	public BoardConnection boardConfig() {
		
		//DTO객체를 생성하고 setter()를 통해 초기값 설정
		BoardConnection bconn = new BoardConnection();
		
		bconn.setUser(board_user);
		bconn.setPass(board_pass);
		bconn.setDriver(board_driver);
		bconn.setUrl(board_url);
		
		return bconn;
	}
}

package env;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
public class EnvApplicationConfig {

	@Value("${board1.user}")
	private String board_user;
	
	@Value("${board1.pass}")
	private String board_pass;
	
	@Value("${board1.driver}")
	private String board_driver;
	
	@Value("${board1.url}")
	private String board_url;
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer Properties() {
		PropertySourcesPlaceholderConfigurer config = 
				new PropertySourcesPlaceholderConfigurer();
		
		Resource[] locations = new Resource[2];
		
		locations[0] = new ClassPathResource("EnvBoard1.properties");
		locations[1] = new ClassPathResource("EnvBoard2.properties");
		
		config.setLocations(locations);
		return config;
	}
	
	@Bean
	public BoardConnection boardConfig() {
		BoardConnection bconn = new BoardConnection();
		
		bconn.setUser(board_user);
		bconn.setPass(board_pass);
		bconn.setDriver(board_driver);
		bconn.setUrl(board_url);
		
		return bconn;
	}
}

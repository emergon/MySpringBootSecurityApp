package emergon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MySpringBootSecurityAppApplication 
//        extends SpringBootServletInitializer
{

	public static void main(String[] args) {
		SpringApplication.run(MySpringBootSecurityAppApplication.class, args);
	}

//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return super.configure(builder.); //To change body of generated methods, choose Tools | Templates.
//    }

        
}

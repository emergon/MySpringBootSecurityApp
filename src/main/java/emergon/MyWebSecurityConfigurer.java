package emergon;

import emergon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class MyWebSecurityConfigurer extends WebSecurityConfigurerAdapter{

    @Autowired
    UserService userService;
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
//        auth.inMemoryAuthentication()
//                .withUser("user").password("{noop}1234").roles("USER")
//                .and()
//                .withUser("admin").password("{noop}1234").roles("USER", "ADMIN")
//                .and()
//                .withUser("teacher").password("{noop}1234").roles("TEACHER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()//Restrict access based on HttpServletRequest
                .antMatchers("/admin/**").hasRole("ADMIN")//Only Admin has access to /admin
                .antMatchers("/teacher/**").hasRole("TEACHER")
                .antMatchers("/").authenticated()
                
                .and()
                .formLogin()//We are changing the process of login
                .loginPage("/loginPage")//Show my form at this URL
                .loginProcessingUrl("/authenticate")//When submit button is pressed the request will be sent to this URL
                .permitAll()//Allow everyone to see login page. Don't have to be logged in.
                
                .and().logout().permitAll()
                
                .and().exceptionHandling().accessDeniedPage("/access-denied")
                ;
    }
    
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }
    
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
}

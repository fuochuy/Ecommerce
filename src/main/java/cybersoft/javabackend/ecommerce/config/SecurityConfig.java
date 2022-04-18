package cybersoft.javabackend.ecommerce.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import cybersoft.javabackend.ecommerce.user.service.CustomUserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	 	//@Autowired
	  //  GoogleOAuth2SuccessHandler googleOAuth2SuccessHandler;

	    @Autowired
	    CustomUserDetailService customUserDetailService;

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	    	 http
             //permit all url
             .authorizeRequests()
             .antMatchers("/swagger-ui.html").permitAll()
 			.antMatchers("/swagger-ui/**").permitAll()
 			.antMatchers("/openapi/**").permitAll()
 			.antMatchers("/api/login").permitAll()
 			.antMatchers("/api/users").permitAll()
 			.antMatchers("/api/**").permitAll()
 			.antMatchers("/**").permitAll()
 			.anyRequest().authenticated()

            
             //check login
             .and()
             .formLogin()
             .loginPage("/login")
             .usernameParameter("username")
             .passwordParameter("password")
             .defaultSuccessUrl("/shop")
             .failureUrl("/login?error= true")

             //when you logout
             .and()
             .logout()
             .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
             .logoutSuccessUrl("/login")
             .invalidateHttpSession(true)
             .deleteCookies("JSESSIONID")

             //declare exeption
             .and()
             .exceptionHandling().accessDeniedPage("/403")

             //thymeleaf already has token, so disable csrf
             .and()
             .csrf()
             .disable();
     http.headers().frameOptions().disable();
	    }//config authenication & authorization

	    @Bean
	    public PasswordEncoder bCryptPasswordEncoder(){
	        return new BCryptPasswordEncoder();
	    }//ma hoa password

	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(customUserDetailService).passwordEncoder(bCryptPasswordEncoder());
	    }//chon class quan li thong tin account

	    @Override
	    public void configure(WebSecurity web) throws Exception {
	        web.ignoring().antMatchers("/resources/**",
	                "/static/**",
	                "/img/**",
	                "/fonts/**",
	                "/css/**",
	                "/scss/**",
	                "/js/**");
	    }//bo qua authen cac package nay

}

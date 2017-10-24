package com.example;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// READ THIS TO UNDERSTAND THIS PROJECT
// https://spring.io/guides/tutorials/spring-boot-oauth2/
@SpringBootApplication
@EnableOAuth2Sso // http://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/security/oauth2/client/EnableOAuth2Sso.html
@RestController
public class ZbethtranDemoBootOauth2Application extends WebSecurityConfigurerAdapter {
	
	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
	    http
	      .antMatcher("/**")
	      .authorizeRequests()
	        .antMatchers("/", "/login**", "/webjars/**").permitAll()
	      .anyRequest().authenticated();
	  }
	  
	  // /5-bethtran-demo-boot-oauth2/BethDocs/Debugging-an-app/Debugging-NOTES.txt
	  // application.yml must be set as followed so that we can see the debug logging
	  // logging:
	  //   level:
	  //     com.example: DEBUG	  
	  // logging
	  Logger logger = LoggerFactory.getLogger(this.getClass());
	  // https://spring.io/guides/tutorials/spring-boot-oauth2/
	  // search for "Note the use of @RestController and @RequestMapping"
	  @RequestMapping("/user")
	  public Principal user(Principal principal) {
		  logger.debug("BETHHHH @RequestMapping /user " + principal.toString());
	    return principal;
	  }
	public static void main(String[] args) {
		SpringApplication.run(ZbethtranDemoBootOauth2Application.class, args);
	}
}

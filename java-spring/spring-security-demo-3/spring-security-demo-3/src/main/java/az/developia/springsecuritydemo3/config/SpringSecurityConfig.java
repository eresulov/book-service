package az.developia.springsecuritydemo3.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@EnableWebSecurity
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	// ilk once configure override edirik
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.OPTIONS, "**").permitAll().anyRequest().authenticated().and().httpBasic();
//cross cors disable etmeliyik basqa ip de port da olanlar cagira bilsin deye 
	//authorizeRequests() gelen sorgulari yoxla 
		//HttpMethod.OPTIONS acib yoxlamasi emeliyatidir ve "/**" butun sorgulara baxilmaga icazedir 
	}

}

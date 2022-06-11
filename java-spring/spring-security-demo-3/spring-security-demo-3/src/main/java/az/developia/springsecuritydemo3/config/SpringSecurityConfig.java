package az.developia.springsecuritydemo3.config;

import javax.sql.DataSource;eclise

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@EnableGlobalMethodSecurity( prePostEnabled = true)
@EnableWebSecurity
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	// ilk once configure override edirik
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
		.antMatchers(HttpMethod.OPTIONS, "/**").permitAll().
		antMatchers(HttpMethod.POST, "/users/signup/**").permitAll().
		anyRequest().authenticated().and().httpBasic();
		//csrf web proqramin melumat alis verisini qadagan edir
//cross cors disable etmeliyik basqa ip de port da olanlar cagira bilsin deye 
		// authorizeRequests() gelen sorgulari yoxla
		// HttpMethod.OPTIONS acib yoxlamasi emeliyatidir ve "/**" butun sorgulara baxilmaga icazedir
		//permitall acmaqdir sign up acilir
	}

	@Autowired
	private DataSource ds;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(ds);

	}
}

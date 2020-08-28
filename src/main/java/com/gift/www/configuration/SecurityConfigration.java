package com.gift.www.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfigration extends WebSecurityConfigurerAdapter {

//    private final CustomOAuth2UserService customOAuth2UserService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().headers().frameOptions().disable().and().authorizeRequests()
				.antMatchers("/**", "/assets/**", "/h2-console/**", "/kakaologin").permitAll()
//                .antMatchers("/api/v1/**").hasRole(Role.USER.name())
				.anyRequest().authenticated().and().logout().logoutSuccessUrl("/");
	}

}
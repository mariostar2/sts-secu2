package com.green.study4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	PasswordEncoder encode() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http)throws Exception {
		http.csrf(csrf ->csrf.disable());
		
		//auth에 올라온 값들을 승인하는 즉시 통과시킴 .permitAll(
		//.authenticated() 403 -- 권한이 없습니다
		http.authorizeHttpRequests(auth -> auth
				//양쪽 페이지 비교해서 로그인 통과 
				.requestMatchers("/","/join","/css/**","/js/**").permitAll()
				//어드민 폴더 및 하위 폴더는 어드민만 접근가능 / 단일 제약조건: (hasRole)
				//.requestMatchers("/admin/**").hasRole("ADMIN")
				//맴버 폴더 및 하위 폴더는 맴버 및 어드민만 접근 가능 / 다중 제약조건: (hasAnyRole)
				//.requestMatchers("/member/**").hasAnyRole("MEMBER","ADMIN")
				.anyRequest().authenticated()
				)
				.formLogin(form -> form
						//로그인 성공시 나의 페이지로 이동
						.defaultSuccessUrl("/member/mypage",true)
						.permitAll()
				);
		
		return http.build();
	}
}

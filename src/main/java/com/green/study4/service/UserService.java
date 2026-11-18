package com.green.study4.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.green.study4.dto.UserDto;
import com.green.study4.entity.User;
import com.green.study4.repository.UserRepository;

import ch.qos.logback.core.encoder.Encoder;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepository userRepository;
	private final PasswordEncoder encoder;
	
	
	public void regist(UserDto dto) {
		//리포지토리에 컨트롤러로 부터 받은 데이터 전달하기
		User entity = dto.entityFromDto();
		//dto --> entity
		String encodedPw = encoder.encode(dto.getPassword());
		entity.setPassword(encodedPw);
		//Role 부여 - MEMBER
		entity.setRole("ROLE_ADMIN");
		//userRepository.findById(1L);
		User savedEntity = userRepository.save(entity);
		System.out.println("savedEntity :" + savedEntity);
	}

	
}

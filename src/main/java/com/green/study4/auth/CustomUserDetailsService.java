package com.green.study4.auth;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.green.study4.entity.User;
import com.green.study4.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService{
	
	private final UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user =userRepository.findByUsername(username).orElseThrow(
				() -> new UsernameNotFoundException("회원이 존재하지 않습니다")
				);
		
		return new CustomUserDetails(user);
	}

}

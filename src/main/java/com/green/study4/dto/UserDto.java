package com.green.study4.dto;

import com.green.study4.entity.User;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDto {
	private Long uno;
	private String username;
	private String password;
	private String name;
	private String role;

	//등록을 위해 dto 반환
	//등록을 위해 dto -> entity 변환
	public User entityFromDto() {
	    User user = new User();
	    user.setUsername(this.username);
	    user.setPassword(this.password);
	    user.setName(this.name);
	    return user;
	}

	

	
}

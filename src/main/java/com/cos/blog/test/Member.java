package com.cos.blog.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
//get,set both
@Data
//constructor
//@AllArgsConstructor  
//@RequiredArgsConstructor 
// 일부분이 final 을 안쓸때..
@NoArgsConstructor(force = true)
// 빈생성자 

public class Member {

	private int id;
	private final String userName;
	private final String password;
	private final String email;

	@Builder // 객체를 자동 증가하는것을 만들때..
	public Member(int id, String userName, String password, String email) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
	}

}

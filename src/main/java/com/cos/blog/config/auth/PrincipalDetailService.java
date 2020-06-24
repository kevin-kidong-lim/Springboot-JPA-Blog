package com.cos.blog.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

@Service
public class PrincipalDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	// 스프링이 로그인 요청을 가로칠때, username, password 변수 2개를 가로채는데
	// password 부분 처리는 알아서 함.
	// 하지만 username 이 db 에 인는지만 확인 해줘야햠. 이 함수에서 확ㅇ니 ..

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("PrincipalDetailService loadUserByUsername: " + username);
		// TODO Auto-generated method stub
		User principal = userRepository.findByUsername(username).orElseThrow(() -> {
			return new UsernameNotFoundException("No search username" + username);
		});
		return new PrincipalDetail(principal); // 이때 ...시큐리티 세션에 유저정보가 저장됨.
	}

}

package com.cos.blog.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cos.blog.model.User;

// 스프링 시큐리티가 로그인 요청을 가로채서 로그인을 진행하고
// 완료가 되면 UserDetails 타입의 오브젝트를 스프링 시큐리티의 고유한 세션저장소에 저장을 해준다.
public class PrincipalDetail implements UserDetails {
	private User user; // 콤포지션 이라고 함; 객체를 내부에 갖고 있는것, User 객체를 갖교 있다.

	public PrincipalDetail(User user) {
		this.user = user;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		System.out.println("PrincipalDetail userName" + user.getUsername());
		return user.getUsername();
	}

	// 계정이 만료 되지 않았는지 리턴한다. ( true : 만료 안됨 )
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	// 계정이 잠겨 있는지 지턴 ( true: 잠기지 않았다 )
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	// 비밀번확 만료 되었는지 확인 ( true : 만료 안됨 )
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	// 계정 활성화(사용가능)인지 리턴 ( true: 활성화)
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	// 계정 권한 목록을 리턴한다. ( 권한이 여러개 있을수 있어서 루프를 돌아야 하는데 우리는 한개만 )
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collectors = new ArrayList<>();
//		collectors.add(new GrantedAuthority() {
//			@Override
//			public String getAuthority() {
//				// TODO Auto-generated method stub
//				return "ROLE_"+ user.getRole(); //ROLE_USER OR ROLE_ADMIN  형식으로 리턴됨.
//			}
//		});
		// 자바에서 객체는 메서드를 파라메터로 못넣고, 오브젝트만 넣을수 있다.
		// 람다식으로 해경 ..
		collectors.add(() -> {
			return "ROLE_" + user.getRole();
		});
		return collectors;
	}
}

package com.cos.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cos.blog.config.auth.PrincipalDetailService;

// 빈으로 등록해야 함.
// 스프링 컨테이너에서 객체를 관리 할 수 있게 한다 >> 빈등록
@Configuration // 설정파일으로.. 빈 등록(스프링 컨테이너에서 객체를 관리) 하겠다
@EnableWebSecurity // 컨트롤로에 도착하기전에 필터링, 컨트롤러에 가기전에 시큐리티 필터 추가 == 스프링 시큐리티가 활성화 되어 있는데, 어떤 설정을 해당
					// 파일에서 하겠다.
// 시큐리티에 필터가 등록 된다 . 설정은 여기 클래스에서 한다.
@EnableGlobalMethodSecurity(prePostEnabled = true) // 특정주소로 접근을 하면 권한 및 인증을 미리 체크 하겠다 .
// 보통 위에 3개 어노테이션은 세트로 많이 사용함.
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private PrincipalDetailService principalDetailService;

	@Bean // IoC 가 됨.
	public BCryptPasswordEncoder encodePWD() {
		//
		String encPassword = new BCryptPasswordEncoder().encode("1234");
		return new BCryptPasswordEncoder();
	}

	// 시큐리티가 대신 로그인해주는데 패스워드를 가로채기 위해
	// 해당 패스워드가 뭘로 해쥐가 되어 있는지 알아야 같은 해쥐로 암호화 해서 db 에 있는 해쉬랑 비교할수 있다
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());
		super.configure(auth);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.csrf().disable() // csrf 토큰 비홠겅화(테스트시 걸어둠)
				.authorizeRequests()
				// .antMatchers("/auth/loginForm","/auth/joinForm")
				.antMatchers("/", "/auth/**", "/js/**", "/css/**", "/image/**") // auth/** 이하는 모두 접속 가능
				.permitAll() // 모두 접속 가능
				.anyRequest() // 이외 다른 요청은
				.authenticated() // 인증 되야 한다.
				.and().formLogin().loginPage("/auth/loginForm") // 로그인 되지 않을때는 이 페이지로 간다.
				.loginProcessingUrl("/auth/loginProc") // 스프링시큐리티가 해당 주소로 요청이 오는 로그인을(username, password) 가로채서 대신 로그인
														// 해준다 .
														// userDetail type의 오브젝트를 만들어 줘야 한다.
				.defaultSuccessUrl("/");

	}

}

package com.cos.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.blog.model.User;

//DAO
//자덩 Bean 등록 가능, 필요한 곳에서 DI 해서 사용가능한다.
// @Repository 생략가능 
public interface UserRepository extends JpaRepository<User, Integer> {

	// 로그인을 위한 함수를 만든다.
	// JSP 네이밍 전략
	// select * from user where username = ? and password =? 가 자동 동작한다.
//	User findByUserNameAndPassword(String userName, String password);

//	@Query(value="select * from user where username = ? and password =?", nativeQuery=true)
//	User login(String userName, String password);
	// select * from user where username = 1?
	Optional<User> findByUsername(String username);

}

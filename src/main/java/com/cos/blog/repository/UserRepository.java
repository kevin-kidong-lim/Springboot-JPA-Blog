package com.cos.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cos.blog.model.User;

//DAO
//자덩 Bean 등록 가능, 필요한 곳에서 DI 해서 사용가능한다.
// @Repository 생략가능 
public interface UserRepository extends JpaRepository<User, Integer>{

}

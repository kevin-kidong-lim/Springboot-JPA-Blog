package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// User 클래스가 mysql에 테이블에 자동 생성 시킨다 .
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // builder pattern
//@DynamicInsert // null 값은 제외하고 등록 한다.
// 어노테이션이 계속 늘어난다 ..
@Entity
public class User {
	// id, createDate 는 자동 등록됨.
	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 db 의 넘버링 전략 사용
	private int id; // sequence , auto_increment
	// unique=true
	@Column(nullable = false, length = 30)
	private String username;

	@Column(nullable = false, length = 100) // 123456 > hash encoding
	private String password;

	@Column(nullable = false, length = 50)
	private String email;

//	@ColumnDefault("'user'")
	@Enumerated(EnumType.STRING)
	private RoleType role; // Enum을 쓰는게 좋다 . 도메인을 만들수 있다 // Admin, User, Manager

	@CreationTimestamp // 시작 자동 입력됨.
	@Column(updatable = false)
	private Timestamp createDate;

}

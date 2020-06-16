package com.cos.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder  // builder pattern
@Entity
public class Board {
	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 db 의 넘버링 전략 사용 auto_increment
	private int id; // sequence , auto_increment
	@Column(nullable = false, length=1000)
	private String title;
	
	@Lob // 대용량 데이터 
	private String content; // summer note library <html> 태그가 섞여서 들어감.
	
	@ColumnDefault("0")  // 기본 세팅값 .
	private int count; //
	
	// EAGET 무조건 가져와 .
	@ManyToOne(fetch=FetchType.EAGER) // 연관관계를 맺어 준다. Many = Board, One = User
	@JoinColumn(name="userId")
    private User userId; // DB는 오브젝트를 저장하지 못해 FK를 사용한다, 자바는 오브젝트를 저장할수 있다.
    
	//LAZY 필요할때 있으면 가져와 ..EAGER 무조건 가져와 
	@OneToMany(mappedBy="board", fetch=FetchType.EAGER) // 연관관계의 주인이 아니다(난 포링키 이다) 컬럼을 만들지 않는다.
	private List<Reply> reply;
	
	@CreationTimestamp
	private Timestamp createDate;
}
	

package com.cos.blog.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

// servie 사용 이유 
// 1.트랜젝션 관리
// 2. 의미 : 한 묶음(그룹) ;;  예) 입금 과 출금 ( 내역 한번에 업데이트 처리 )
//		둘다 성공해야 커밋, 실패시 롤백 .
@Service  //  스프링이 컴포넌트 스캔을 통해서 빈에 등록을 해줌. IoC를 해준다 .
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public int save(User user) {
		try {
			userRepository.save(user);
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("UserServie save error:" + e.getMessage());
		}
		return -1;
	}
}


package com.cos.blog.test;

import java.util.List;
import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

@RestController
public class DemmyControllerTest {
	// 메모리에 같이 로딩 된다 . , DI 의존성 주입 .
	@Autowired
	private UserRepository userRepository;

	@DeleteMapping("/dummy/user/{id}")
	public String delete(@PathVariable int id) {
		try {
			userRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			return "delete faile, no search id: " + id;
		}

		return "deleted id:" + id;
	}

	// email, password update
	@Transactional
	@PutMapping("/dummy/user/{id}")
//	public User upateUser(@PathVariable int id, User requestUser) {  // form 
	public User upateUser(@PathVariable int id, @RequestBody User requestUser) { // Json
		System.out.println("id: " + id);
		System.out.println("password" + requestUser.getPassword());
		System.out.println("email: " + requestUser.getEmail());
		// 첫번째 업데이트 방법
		// userName 은 값이 널 로 같이 업데이트 된다..
//		requestUser.setId(id);
//		userRepository.save(requestUser);
		// 두번째 업데이트 방법
		// 람다식은 함수를 넣을수 있다..
		User user = userRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("No user id: " + id);
		});
		user.setPassword(requestUser.getPassword());
		user.setEmail(requestUser.getEmail());
//		userRepository.save(user);
//		세번째 방법, save 대신에  @Transational 오노데이션 추가 : 더티채킹
		// 더티 채킹 이란 ?
		// JPA 영속성 컨텍스트
		// controller -->(cache) jpa (flush)---> DB
		// controller 에서 검색시에 우선 jpa(cache)에서 검색 없으면 DB
		// update 시에는 db select > cache > update > flush > db
		// @Transactinal 은 트랙젝샌이 실행됨 (변경된 내용이 있을경우만 ...실행됨!!).. 함수가 종료딜때 자동 commit ;;
		// <-- 더티 채킹 .

		return user;
	}

	// http://localhost:8000/blog/dummy/user
	@GetMapping("/dummy/user")
	public List<User> list() {
		List userList = userRepository.findAll();
		return userList;
	}

//	// 한페이지당 2건에 데이터를 리턴 , 부가 정보를 모두 가져온다 ..
//	@GetMapping("/dummy/user/page")
//	public Page<User> pageList(@PageableDefault(size=2, sort="id", direction=Sort.Direction.DESC) Pageable pageable){
//		Page<User> users = userRepository.findAll(pageable);
//		
//		return users;
//	}
//	
//	// 한페이지당 2건의 데이터를 가져온다 .. 부가정보를 제외한 데이터만 가져온다 .
//	@GetMapping("/dummy/user/page")
//	public List<User> pageList(@PageableDefault(size=2, sort="id", direction=Sort.Direction.DESC) Pageable pageable){
//		List<User> users = userRepository.findAll(pageable).getContent();
//		return users;
//	}

	// 한페이지당 2건의 데이터를 가져온다 .. 부가정보를 제외한 데이터만 가져온다 .
	@GetMapping("/dummy/user/page")
	public List<User> pageList(
			@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
		Page<User> pagingUser = userRepository.findAll(pageable);
//		if(pagingUser.isFirst())
//		if(pagingUser.isLast())
		List<User> users = pagingUser.getContent();
		return users;
	}

	// http://localhost:8000/blog/dummy/user/3
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
		// 만약 데이터베이스이 값이 없는... user/4를 찾으면 데이터베이스에서 못찾아오면 user가 널 이된다.
		// 그럼 널 이 리턴되니 ..
		// optioanl 로 user객체를 감싸서 가져올테니 null 인지 판단해서 return 하라는 뜻.
		// 값들이 null 로
//		User  user = userRepository.findById(id).orElseGet(new Supplier<User>() {
//			@Override
//			public User get() {
//				// TODO Auto-generated method stub
//				return new User();
//			}
//			
//		});
		// 값들이 에러로 ..
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
			@Override
			public IllegalArgumentException get() {
				// TODO Auto-generated method stub
				return new IllegalArgumentException("No user id: " + id);
			}
		});

		// 람다식
//		User  user = userRepository.findById(id).orElseThrow(()->{
//			return new IllegalArgumentException("No user id: " + id);
//		});

		// 요청 : 웹브라우저
		// 객체 = 자바 오브젝트
		// 변환 -> json ( Gson 라이브러리 )
		// 스프링부트 = MessageConverter가 응답시에 자동 작동 .
		// Jackson 라이브러리 호출에서 user 오브젝트를 json 으로 변환해서 보내붐
		return user;

	}

	// http://localhost:80000/blog/dummy/join
	// http의 body에 userName, password, email 데이터를 가지고 요청 .
	@PostMapping("/dummy/join")
//	public String join(@RequestParam("userName") String u, String password, String email) {
//	public String join(String userName, String password, String email) {	
	public String join(User user) {
		System.out.println("userName:" + user.getEmail());
		System.out.println("password:" + user.getPassword());
		System.out.println("email:" + user.getEmail());

		user.setRole(RoleType.USER);
		userRepository.save(user);
		return "complete member";
	}
}

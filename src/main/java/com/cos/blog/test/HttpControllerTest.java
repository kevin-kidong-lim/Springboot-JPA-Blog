package com.cos.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//사용자가 요청 -> 응답(html)
//@Controller
//사용자가 요청 -> 응답(Data)

@RestController
public class HttpControllerTest {

	private static final String TAG = "HttpControllerTest:";

	@GetMapping("/http/lombok")
	public String lombokTest() {

//		Member m = new Member(1, "kevin", "12345", "kevin@gmail.com");
		// builder 패턴은 생성자의 순서에 상관없이 사용가능하다.
		//
		Member m = Member.builder().password("1111").userName("kein").email("email@nate.com").build();

		System.out.println(TAG + "getter:" + m.getUserName());
		m.setId(5000);
		System.out.println(TAG + "setter:" + m.getId());
		return "lombok test complet";
	}

	// http://localhost:8080/http/get
	@GetMapping("/http/get")
//	public String getTest(@RequestParam int id, @RequestParam String userName) {
	public String getTest(Member m) {

		return "get Request, id : " + m.getId() + "," + m.getUserName() + "," + m.getPassword() + "," + m.getEmail();
	}

	// http://localhost:8080/http/post
	@PostMapping("/http/post")
//	public String postTest(@RequestBody , @text) {  // raw plan text
//	public String postTest(Member m) {		//x-www-form
	public String postTest(@RequestBody Member m) { // raw json <-- MessageConvert 클래스가 자동 매핑
		return "post Request, id : " + m.getId() + "," + m.getUserName() + "," + m.getPassword() + "," + m.getEmail();
	}

	// http://localhost:8080/http/put
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) {

		return "put Request, id : " + m.getId() + "," + m.getUserName() + "," + m.getPassword() + "," + m.getEmail();
	}

	// http://localhost:8080/http/delete
	@DeleteMapping("/http/delete")
	public String deleteTest() {

		return "delet Request";
	}
}

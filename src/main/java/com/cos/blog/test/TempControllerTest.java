package com.cos.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempControllerTest {
	
	// http://localhost:8000/blog/temp/home
	@GetMapping("/temp/home")
	public String tempHome() {
		System.out.println("tempHome");
		
		// @Controller 는 기본적으로 파일을 리턴해준다
		// 파일리턴 기본경로 : src/main/resources/static
		// 리턴명을 /home.html 해줘야한다.
		
		// 기본적으로 static 밑에는 이미지, 등만 넣어야 하기 때문에 jsp 인식을 못한다
		// jsp 는 동적인 파일이기 때문에 .. 경로를 바꿔준다. src/main/webapp/WEB-INF/views
		// 그래서 pom.xml 에 
		return "/home.html";
	}
	
	@GetMapping("/temp/jsp")
	public String tempJsp() {
		// prefix : /WEB-INF/views/ 
		// surfix : .jsp
		return "/test";
	}
}

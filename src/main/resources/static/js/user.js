/**
 * 
 */
let index = {
	init: function(){
		$("#btn-save").on("click", ()=>{ // function(){} > ,() =>{} this를 바인딩 하기 위해 익명함수사용 
			this.save();
		});
	},

	save:function(){
		let data = {
				userName:$("#userName").val(),
				password:$("#password").val(),
				email:$("#email").val()
		}
//		console.log(data)
		// 비동기 호출 
		$.ajax({
			// 회원가입 수행 요청
			type:"POST",
			url: "/blog/api/user",
			data: JSON.stringify(data), // http body data
			contentType:"application/json;charset=utf-8", // request body type
			dataType:"json" // response type, 응답은 기본적으로 문자열(스트림), 자바스크립트 오브젝트로 변환 시켜줌.
		}).done(function(resp){
			// 성공
			alert("ok member join");
			location.href="/blog";
		}).fail(function(error){
			//실패 
			alert(JSON.stringify(error));
//			location.href="/blog";
		}); // 통신을 이용해서 3개의 파라미터를 json으로 변경하여 insert 요청 
	}
}

index.init();
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">
<!-- ��ũ�� ��ť��Ƽ�� ����ä�� ������ ���� �ϱ� ���� /auth/loginProc �� ���� ������ �ʴ´� .. -->
	<form action="/auth/loginProc" method="post">
		<div class="form-group">
			<label for="userName">UserName:</label> <input type="text"
				class="form-control" placeholder="Enter UserName" id="username" name="username" >
		</div>
		<div class="form-group">
			<label for="password">Password:</label> <input type="password"
				class="form-control" placeholder="Enter password" id="password" name="password">
		</div>
		<!-- <div class="form-group form-check">
			<label class="form-check-label"> <input
				class="form-check-input" type="checkbox"  name="remember"> Remember me
			</label>
		</div> -->
	<button id="btn-login" class="btn btn-primary">Login</button>	
	</form>
	
</div>

<br />
<%@ include file="../layout/footer.jsp"%>
<script src="/js/user.js"></script>
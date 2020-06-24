<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">

	<form>
		<div class="form-group">
			<label for="userName">UserName:</label> <input type="text"
				class="form-control" placeholder="Enter UserName" id="username" name="username">
		</div>
		<div class="form-group">
			<label for="password">Password:</label> <input type="password"
				class="form-control" placeholder="Enter password" id="password" name="password">
		</div>
		<div class="form-group">
			<label for="email">Email address:</label> <input type="email"
				class="form-control" placeholder="Enter email" id="email">
		</div>
	</form>
		<button id="btn-save" class="btn btn-primary">Submit</button>

</div>

<br />
<%@ include file="../layout/footer.jsp"%>
<script src="/js/user.js"></script>
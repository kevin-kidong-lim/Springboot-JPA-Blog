<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">

	<form action="/action_page.php">
		<div class="form-group">
			<label for="userName">UserName:</label> <input type="text"
				class="form-control" placeholder="Enter UserName" id="userName">
		</div>
		<div class="form-group">
			<label for="password">Password:</label> <input type="password"
				class="form-control" placeholder="Enter password" id="password">
		</div>
		<div class="form-group form-check">
			<label class="form-check-label"> <input
				class="form-check-input" type="checkbox"> Remember me
			</label>
		</div>
		<button type="submit" class="btn btn-primary">Login</button>
	</form>

</div>

<br />
<%@ include file="../layout/footer.jsp"%>
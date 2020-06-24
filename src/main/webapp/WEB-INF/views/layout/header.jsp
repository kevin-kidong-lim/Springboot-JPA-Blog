<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>  
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal"/>
<!-- 	<script>
		alert("already login user" + ${principal});
	</script> -->
</sec:authorize>
<sec:authentication property="principal" var="principal"/>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>
<%-- <h1>${principal}</h1> --%>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
  <a class="navbar-brand" href="/">Home</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
  
 <%--  <c:choose>
  	<c:when test="${empty principal}">
  	<c:when test="${empty sessionScope.principal }">
  	 <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="/auth/loginForm">Login</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/auth/joinForm">Member</a>
      </li>
    </ul>
  	</c:when>
  	<c:otherwise>
  	 <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="/board/form">Write</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/user/form">Member List</a>
      </li>
        <li class="nav-item">
        <a class="nav-link" href="/logout">Logou ${principal}</a>
      </li>
    </ul>
  	</c:otherwise>
  </c:choose>
    --%>
    <sec:authorize access="isAuthenticated()">
    	 <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="/board/form">Write</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/user/form">Member List</a>
      </li>
        <li class="nav-item">
        <a class="nav-link" href="/logout">Logout</a>
      </li>
    </ul>
    </sec:authorize>
    <sec:authorize access="!isAuthenticated()">
    	<ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="/auth/loginForm">Login</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/auth/joinForm">Member</a>
      </li>
    </ul>
    </sec:authorize>
  </div>  
</nav>
<br>
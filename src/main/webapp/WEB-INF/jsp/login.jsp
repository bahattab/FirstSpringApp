<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<h1>User Login</h1>
<hr>

<form method='POST' action='<spring:url value="/j_spring_security_check"/>' class="form-horizontal">
	
	<div class="form-group">
		<label for="email" class="col-sm-1">Email:</label>
		<input type="text" name="j_username" class="col-sm-3" />
	</div>
	<div class="form-group">
		<label for="email" class="col-sm-1">Password:</label>
		<input type="password" name="j_password" class="col-sm-3" />
	</div>
	<div class="form-group">
		<input type="submit" value="Login" class="col-sm-offset-1 btn btn-md btn-success" />
	</div>
</form>
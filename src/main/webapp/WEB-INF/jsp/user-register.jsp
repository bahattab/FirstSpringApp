<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1>User Registration</h1>
<hr>
<form:form commandName="user" cssClass="form-horizontal">
	<div class="form-group">
	    <label for="email" class="col-sm-1">Name:</label>
		<form:input path="name" cssClass="col-sm-3"/>
	</div>
	<div class="form-group">
	    <label for="email" class="col-sm-1">Email:</label>
		<form:input path="email" cssClass="col-sm-3"/>
	</div>
	<div class="form-group">
	    <label for="email" class="col-sm-1">Password:</label>
		<form:password path="password" cssClass="col-sm-3"/>
	</div>
	<div class="form-group">
	    <input type="submit" value="Register" class="col-sm-offset-1 btn btn-md btn-success"/>
	</div>
</form:form>


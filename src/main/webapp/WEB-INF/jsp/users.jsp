<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<table class="table table-stripped table-hover">
	<thead>
		<tr>
			<th>User</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<c:forEach items="${users}" var="user">
			<td><c:out value="${user.getName()}"></c:out> </td>
			</c:forEach>
		</tr>
	</tbody>
</table>
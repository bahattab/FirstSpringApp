<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<table class="table table-striped table-hover table-bordered table-responsive">
	<thead>
		<tr>
			<th>User</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<c:forEach items="${users}" var="user">
				<td>
					<a href='<spring:url value="/users/${user.getId()}.html"></spring:url>'><c:out value="${user.getName()}"></c:out></a>
				</td>
			</c:forEach>
		</tr>
	</tbody>
</table>
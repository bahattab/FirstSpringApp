<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<h1>
	Name: <c:out value="${user.getName()}"></c:out>
</h1>
<p>
	<c:forEach items="${user.blogs}" var="blog">
		<h4>Blog name: ${blog.getName()}</h4>
		<h4>Blog URL: ${blog.getUrl()}</h4>
		<table class="table table-striped table-hover table-bordered table-responsive">
			<thead>
				<tr>
					<th>Title</th>
					<th>Description</th>
					<th>Published Date</th>
					<th>Link</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${blog.items }" var="item">
					<tr>
						<td><c:out value="${item.getTitle()}"></c:out></td>
						<td><c:out value="${item.getDescription()}"></c:out></td>
						<td><c:out value="${item.getPublishedDate()}"></c:out></td>
						<td><c:out value="${item.getLink()}"></c:out></td>
					</tr>
					</c:forEach>
			</tbody>
		</table>
	</c:forEach>
</p>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1>
	Name:
	<c:out value="${user.getName()}"></c:out>
</h1>
<!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">Add New Blog</button>

<form:form commandName="blog" cssClass="form-horizontal">
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">New blog</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="name" class="col-sm-2">Name:</label>
						<form:input path="name" cssClass="col-sm-3" />
					</div>
					<div class="form-group">
						<label for="url" class="col-sm-2">URL</label>
						<form:input path="url" cssClass="col-sm-3" />
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<input type="submit" class="btn btn-primary" value="Save Changes">
				</div>
			</div>
		</div>
	</div>
</form:form>
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

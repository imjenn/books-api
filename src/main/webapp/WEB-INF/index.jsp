<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>All Books</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="/css/index.css">
</head>
<body>
	<div>
		<h1>All Books</h1>
		<div class="table">
			<table class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Title</th>
						<th scope="col"> Language</th>
						<th scope="col"># Pages</th>
						<th scope="col">Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="books" items="${books}">
					<tr> 
						<td class="align-middle"><c:out value="${books.id}"></c:out></td>
						<td class="align-middle"><a href="/books/${books.id}"><c:out value="${books.title}"></c:out></a></td>
						<td class="align-middle"><c:out value="${books.language}"></c:out></td>
						<td class="align-middle"><c:out value="${books.numberOfPages}"></c:out></td>
						<td class="align-middle">
							<a href="/books/${books.id}/edit">Edit</a>
							<form action="/books/${books.id}/delete" method="post">
    							<input type="hidden" name="_method" value="delete">
    							<input type="submit" class="btn btn-danger" value="Delete">
							</form>
							
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
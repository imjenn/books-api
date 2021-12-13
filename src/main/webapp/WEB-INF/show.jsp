<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Books API</title>
</head>
<body>
	<div>
		<h1>${book.title}</h1>
		<p>Title: ${book.title}</p>
		<p>Language: ${book.language}</p>
		<p>Description: ${book.description}</p>
		<p>Number of Pages: ${book.numberOfPages}</p>
	</div>

</body>
</html>
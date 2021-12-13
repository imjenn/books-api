<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New Book</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="/css/new.css">
</head>
<body>
	<div id="container">
		<h1>Add a New Book</h1>
		<form action="/books" method="post">
			<div class="form-group row">
	    		<label for="title" class="col-sm-2 col-form-label">Title: </label>
	    		<div class="col-sm-10">
	     			<input type="text" name="title" class="form-control" id="title" placeholder="Book title">
	    		</div>
	  		</div>
	  		<div class="form-group row">
	    		<label for="description" class="col-sm-2 col-form-label">Description: </label>
	    		<div class="col-sm-10">
	     			<input type="text" name="description" class="form-control" id="description" placeholder="Book description">
	    		</div>
	  		</div>
	  		<div class="form-group row">
	    		<label for="language" class="col-sm-2 col-form-label">Language: </label>
	    		<div class="col-sm-10">
	     			<input type="text" name="language" class="form-control" id="language" placeholder="Book language">
	    		</div>
	  		</div>
	  		<div class="form-group row">
	    		<label for="number-of-pages" class="col-sm-2 col-form-label">Number of pages: </label>
	    		<div class="col-sm-10">
	     			<input type="number" name="numberOfPages" class="form-control" id="number-of-pages" placeholder="Number of pages">
	    		</div>
	  		</div>
			<button type="submit" class="btn btn-primary mb-2">Submit</button>
		</form>
	</div>
</body>
</html>
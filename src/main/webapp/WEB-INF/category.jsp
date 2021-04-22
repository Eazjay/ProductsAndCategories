<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ page isErrorPage="true" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">
<title>Products And Categories</title>
</head>
<body>
	<div class="container p-5 mt-5">
		<div class="form-group mt-3">
			<h1>New Category</h1>
			<form:form action="/categories/create" method="post" modelAttribute="category" class="mt-5">
                <p>
                    <form:label path="name">Name: </form:label>
                    <form:errors path="name"/>
                    <form:input path="name" class="input-group-text"/>
                </p>
	            <input type="submit" value="Create" class="btn btn-primary btn-lg mt-3"/>
       		</form:form>
		</div>
	</div>
</body>
</html>
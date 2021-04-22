<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
	<div class="container mt-5">
		<h1>${product.name}</h1>
		<div class="d-flex justify-content-between mt-5 w-50">
			<div>
				<h4>Categories:</h4>
				<c:forEach items="${product.categories}" var="category">
					<ul class="list-group list-group-flush">
						<li class="list-group-item"><c:out value="${category.name}"></c:out></li>
					</ul>
				</c:forEach>
			</div>
			<div>
				<form action="/categories/add" method="post">
	                <label for="category">Add Category: </label>
	        		<input type="hidden" name="product" value="${product.id}">
	                 <select name="category" class="input-group-text">
	                     <c:forEach items="${categories}" var="category">
	                         <option value="${category.id}"><c:out value="${category.name}"/></option>
	                     </c:forEach>
	                 </select>
	           	  <input type="submit" value="Add" class="btn btn-primary btn-lg mt-3"/>
	     		</form>
			</div>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Form</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" type="image/png" href="images/icons/favicon.ico" />
<link rel="stylesheet" type="text/css" href="./resources/css/main.css">
</head>

<body>


	<div class="wrapper">
		<div class="container">
			<div class="navbar">
				<ul>
					<li><a href="InputDetails">Home</a></li>
					<li><a href="AllDetails" class="active">Edit</a></li>
					<li><a href="PrintCard">List</a></li>
				</ul>
			</div>
			<div class="details-wrap">
				<ul>
					<c:if test="${not empty student}">
						<c:forEach var="student" items="${student}">
							<li>

								<div class="list-content">

									<h5>${student.name}</h5>
									<%-- 	<p>
										Age : <span>28</span>
									</p>--%>
									<p>
										Father Name : <span>${student.fname}</span>
									</p>
									<p>
										Mother Name : <span>${student.mname}</span>
									</p>
									<p>
										Address : <span>${student.add }</span>
									</p>
									<img src="./resources/image/${student.fileName}" class="user-image" />
									<a href="Edit?sl=${student.sl }">Edit</a>
									<a href="Delete?sl=${student.sl }">Delete</a>
								</div>


							</li>
						</c:forEach>
					</c:if>
				</ul>
			</div>


		</div>

	</div>



</body>
</html>

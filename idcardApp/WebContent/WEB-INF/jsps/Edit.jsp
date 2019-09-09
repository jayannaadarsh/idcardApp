<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Form</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" type="image/png"
	href="./resources/images/icons/favicon.ico" />

<link rel="stylesheet" type="text/css" href="./resources/css/main.css">
</head>
<body>


	<div class="wrapper">
		<div class="container">
			<div class="navbar">
				<ul>
					<li><a href="InputDetails" class="active">Home</a></li>
					<li><a href="AllDetails">List</a></li>
				</ul>
			</div>
			<div class="form-outter">
				<h4>Please Edit your Details</h4>
				<s:form action="Update" modelAttribute="student">
					<c:if test="${status=='Failed'}">
						<div class="success-message">Update ${status}</div>
					</c:if>
					<h1>${student.sl }</h1>
					<s:hidden path="sl" value="${student.sl }"/>
					<div class="field-row">
						<label>Name</label>
						<s:input type="text" path="name" value="${student.name }" class="input-text"
							placeholder="Name" />
						<s:errors class="error" path="name" />

					</div>
					<div class="field-row">
						<label>Father Name</label>
						<s:input type="text" path="fname" value="${student.fname }" class="input-text"
							placeholder="Father Name" />
						<s:errors class="error" path="fname" />
					</div>
					<div class="field-row">
						<label>Mother Name</label>
						<s:input type="text" path="mname" value="${student.mname }" class="input-text"
							placeholder="Mother Name" />
						<s:errors class="error" path="mname" />
					</div>

					<div class="field-row">
						<label>Address</label>
						<s:input type="text" path="add"  value="${student.add }" style=" height: 100px;"
							class="input-text" placeholder="Address" />
						<s:errors class="error" path="add" />
					</div>


					<%-- 
					<div class="field-row">
						<label>Name</label> <select class="input-text">
							<option value="volvo">Volvo</option>
							<option value="saab">Saab</option>
							<option value="mercedes">Mercedes</option>
							<option value="audi">Audi</option>
						</select>
					</div>
					<div class="field-row">
						<label>Name</label> <select class="input-text">
							<option value="volvo">Volvo</option>
							<option value="saab">Saab</option>
							<option value="mercedes">Mercedes</option>
							<option value="audi">Audi</option>
						</select>
					</div>
					
					<div class="field-row">
						<label>Name</label>
						<div class="file-wrapper input-text">
							<input type="file" name="myFile" class=""> <span
								class="file-browse"></span>
						</div>

					</div>
					 --%>


					<div class="field-row button-wrapper">
						<input type="submit" class="btn-primary" value="UPDATE" />
					</div>
				</s:form>
			</div>



		</div>

	</div>



</body>
</html>

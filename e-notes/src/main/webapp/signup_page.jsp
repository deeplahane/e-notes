<%@page import="com.entities.Message"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="components/all_css.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Signup</title>
</head>
<body style="background-color: #F2F3F5;">
	<%
	Message m = (Message) session.getAttribute("msg");
	if (m != null) {
	%>
	<div class="alert <%=m.getCssClass()%>">
		<%=m.getContent()%>
	</div>
	<%
	}
	session.removeAttribute("msg");
	%>
	<div class="container-fluid">
		<div class="row p-4">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-header text-center">
						<h3>
							<i class="fa-solid fa-user-plus"></i> Singup
						</h3>
					</div>
					<div class="card-body"> 
						<form action="add_user" method="post">
							<div class="form-group">
								<label for="exampleInputEmail1">Enter Full Name </label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Jhon Doe "
									name="name">

							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Enter Email </label> <input
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="jhondoe@gmail.com"
									name="email">

							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Enter Password</label> <input
									type="password" class="form-control" id="exampleInputPassword1"
									placeholder="JhonDoe@123" name="password">
							</div>

							<button type="submit"
								class="btn btn-primary btn-block badge-pill">Signup</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
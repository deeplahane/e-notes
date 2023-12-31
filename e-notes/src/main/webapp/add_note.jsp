<%@page import="com.entities.Message"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="components/all_css.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Note</title>
</head>
<body style="background-color: #F2F3F5;">
	<%
	if (user == null) {
		Message msg = new Message("Please Login First", "alert-danger");
		session.setAttribute("msg", msg);
		response.sendRedirect("login_page.jsp");
	}
	%>
	<%
	Message m = (Message) session.getAttribute("msg");
	if (m != null) {
	%>
	<div class="alert <%=m.getCssClass()%>"><%=m.getContent()%></div>
	<%
	}
	session.removeAttribute("msg");
	%>
	<div class="container-fluid ">
		<div class="row p-5">
			<div class="col-md-12">
				<div class="card">
					<div class="card-header text-center">
						<h3>
							<i class="fa-solid fa-pen"></i> Take Notes...
						</h3>
					</div>
					<div class="card-body">
						<form action="add_note" method="post">
							<div class="form-group">
								<label for="exampleInputEmail1">Enter Title</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Java Developer"
									name="title">

							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Enter Content</label>
								<textarea rows="12" cols="" class="form-control"
									id="exampleInputPassword1"
									placeholder="A random string is generated by first generating a stream of random numbers of ASCII values for 0-9, a-z and A-Z characters."
									name="content"></textarea>
							</div>

							<div class="text-center">
								<button type="submit" class="btn btn-primary">Add Note</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
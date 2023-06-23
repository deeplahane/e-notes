<%@page import="com.entities.Message"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@page import="java.util.List"%>
<%@page import="com.entities.Note"%>
<%@page import="com.connect.Connector"%>
<%@page import="com.dao.NoteDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="components/all_css.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Jobs</title>
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
	Message msg = (Message) session.getAttribute("msg");
	if (msg != null) {
	%>
	<div class="alert <%=msg.getCssClass()%>" role="alert">
		<%=msg.getContent()%>
	</div>
	<%
	}
	session.removeAttribute("msg");
	%>
	<div class="container-fluid  login-container">
		<div class="row">
			<div class="col-md-12 ">
				<%
				NoteDAO jobs = new NoteDAO(Connector.getCon());
				List<Note> j = jobs.getAllNotes();

				for (Note v : j) {
				%>
				<div class="card mt-2">
					<div class="card-body">

						<h6>
							<%=v.getTitle()%>
						</h6>
						<p>
							<%=v.getContent()%>
						</p>

						<p>
							Date: <%=v.getPdate()%> 
						</p>
						<div class="text-center">
							<a href="edit_note.jsp?id=<%=v.getId() %>" type="submit"
								class="btn btn-secondary btn-sm">Edit</a> <a
								href="delete?id=<%=v.getId()%>" type="submit"
								class="btn btn-danger btn-sm">Delete</a>
						</div>
					</div>
				</div>
				<%
				}
				%> 
			</div>
		</div>
	</div>
</body>
</html>
package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connect.Connector;
import com.dao.NoteDAO;
import com.entities.Message;
import com.entities.User;

@WebServlet("/add_note")
public class AddNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session=req.getSession();
		User u=(User) session.getAttribute("userobj");
		
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		int userId=u.getId();
		System.out.print(userId);
		
		NoteDAO dao=new NoteDAO(Connector.getCon());
		boolean v=dao.addNote(title, content, userId);
		
		if(v) {
			Message msg=new Message("Note Added...","alert-success");
			session.setAttribute("msg", msg);
			res.sendRedirect("add_note.jsp");
		}else {
			Message msg=new Message("Oops! Something went wrong...","alert-danger");
			session.setAttribute("msg", msg);
			res.sendRedirect("add_note.jsp");
		}
		
	}

}

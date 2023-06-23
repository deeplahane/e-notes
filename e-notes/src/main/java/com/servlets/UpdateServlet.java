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

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		
		NoteDAO dao=new NoteDAO(Connector.getCon());
		boolean v=dao.updateNoteById(id, title, content);
		
		HttpSession session=req.getSession();
		if(v) {
			Message msg=new Message("Note updated...","alert-success");
			session.setAttribute("msg", msg);
			res.sendRedirect("view_notes.jsp");
		}else {
			Message msg=new Message("Oops! Something went wrong...","alert-danger");
			session.setAttribute("msg", msg);
			res.sendRedirect("edit_note.jsp");
		}
	}

}

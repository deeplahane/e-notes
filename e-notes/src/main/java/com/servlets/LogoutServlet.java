package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entities.Message;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		try {
			HttpSession session=req.getSession();
				if(session!=null) {
					session.removeAttribute("userobj");
					Message m=new Message("Logout successfull...","alert-success");
					session.setAttribute("msg", m);
					res.sendRedirect("login_page.jsp");
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}

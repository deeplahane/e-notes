package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connect.Connector;
import com.dao.UserDAO;
import com.entities.Message;
import com.entities.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		try {
			
			String email=req.getParameter("email");
			String password=req.getParameter("password");
			
			UserDAO dao=new UserDAO(Connector.getCon());
			User  user=dao.userLogin(email, password);
			
			HttpSession session=req.getSession();
			if(user!=null) {
				Message msg=new Message("Congrats! Login successsfull...","alert-success");
				session.setAttribute("userobj", user);
				session.setAttribute("id", user.getId());
				session.setAttribute("msg", msg);
				res.sendRedirect("index.jsp");
			}else {
				Message msg=new Message("Email or Password is wrong...","alert-danger");
				session.setAttribute("msg", msg);
				res.sendRedirect("login_page.jsp");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}

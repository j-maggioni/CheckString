package com.corso.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/esempioServlet")
public class EsempioServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
       
    public EsempioServlet() {
        super();
     }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		//login
		session.setAttribute("username", "mazza"); 
		session.setMaxInactiveInterval(4*60*1000); // tempo di scadenza della sessione
		
		//logout
		session.invalidate();
		
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: Sono nella Servlet").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

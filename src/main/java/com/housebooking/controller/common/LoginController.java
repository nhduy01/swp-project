package com.housebooking.controller.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.housebooking.DAOimpl.web.AccessManager;
import com.housebooking.Model.UserSession;

import com.accessgoogle.common.GooglePojo;
import com.accessgoogle.common.GoogleUtils;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");

		if (action == null) {
			doDisplay(request, response);
		} else if (action.equals("login")) {
			doLogin(request, response);
		}

	}

	protected void doLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if( (username == null) && (password == null) && (code == null)) {
			RequestDispatcher rd = request.getRequestDispatcher("/view/common/login.jsp");
			rd.forward(request, response);
		} else if ( (username == null) && (password == null) && (code != null)) {
			String accessToken = GoogleUtils.getToken(code);
	        GooglePojo googlePojo = GoogleUtils.getUserInfo(accessToken);
	        request.setAttribute("id", googlePojo.getId());
	        request.setAttribute("name", googlePojo.getName());
	        request.setAttribute("email", googlePojo.getEmail());
	        response.sendRedirect(request.getContextPath() + "/home");  
		} else if ( (username != null) && (password != null) && (code == null) ){
			doLogin(request, response);
		}
		
		AccessManager accessManager = new AccessManager();
		UserSession us = accessManager.login(username, password);

		HttpSession ss = request.getSession(true);

		if (us.getUser() != null) {
			ss.setAttribute("usersession", us);
			switch (us.getUser().getRole()) {
			case "Admin":
				response.sendRedirect(request.getContextPath() + "/admin");
				break;
			case "Owner":
				response.sendRedirect(request.getContextPath() + "/dashboard");
				break;
			case "User":
				response.sendRedirect(request.getContextPath() + "/home");
				break;
			}
		} else {
			request.setAttribute("login_mess", "Tên đăng nhập hoặc mật khẩu không đúng");
			doDisplay(request, response);
		}
//	    if ( code == null || code.isEmpty() ) {
//	    	System.out.println("asdf");
//			AccessManager accessManager = new AccessManager();
//			UserSession us = accessManager.login(username, password);
//
//			HttpSession ss = request.getSession(true);
//
//			if (us.getUser() != null) {
//				ss.setAttribute("usersession", us);
//				switch (us.getUser().getRole()) {
//				case "Admin":
//					response.sendRedirect(request.getContextPath() + "/admin");
//					break;
//				case "Owner":
//					response.sendRedirect(request.getContextPath() + "/dashboard");
//					break;
//				case "User":
//					response.sendRedirect(request.getContextPath() + "/home");
//					break;
//				}
//			} else {
//				request.setAttribute("login_mess", "Tên đăng nhập hoặc mật khẩu không đúng");
//				doDisplay(request, response);
//			}
//	    } else {
//	        String accessToken = GoogleUtils.getToken(code);
//	        GooglePojo googlePojo = GoogleUtils.getUserInfo(accessToken);
//	        request.setAttribute("id", googlePojo.getId());
//	        request.setAttribute("name", googlePojo.getName());
//	        request.setAttribute("email", googlePojo.getEmail());
//	        response.sendRedirect(request.getContextPath() + "/home");
//	      }
		
	}

	protected void doDisplay(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/view/common/login.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//processRequest(request, response);
		doLogin(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//processRequest(request, response);
		doLogin(request, response);
	}

}
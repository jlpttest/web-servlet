package com.demo.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.demo.dao.UserDAO;
import com.demo.entities.User;

/**
 * Servlet implementation class CreateUserServlet
 */
@WebServlet("/create-user")
@MultipartConfig
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateUserServlet() {
		userDAO = new UserDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/createuser.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			Part avatarPart = request.getPart("uploadFile");
			String avatarPath = null;
			if (avatarPart != null && avatarPart.getSize() > 0) {
				String uploadDir = getServletContext().getRealPath("/resources/img");
				File uploadDirFile = new File(uploadDir);
				if (!uploadDirFile.exists())
					uploadDirFile.mkdirs();
				avatarPath = "resources/img/" + avatarPart.getSubmittedFileName();
				avatarPart.write(uploadDir + File.separator + avatarPart.getSubmittedFileName());
			}

			User user = new User(name, email, avatarPath);
			userDAO.saveUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		response.sendRedirect(request.getContextPath() + "/user-list");
	}

}

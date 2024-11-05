package com.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.dao.QuestionDAO;
import com.demo.entities.Question;



public class QuestionController extends HttpServlet {
	
	private QuestionDAO questionDAO;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//questionDAO = new QuestionDAO();
	}
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//List<Question> questions = questionDAO.getAllQuestion();
		//request.setAttribute("questions", questions);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/question-list.jsp");
		dispatcher.forward(request, response);
	}

}

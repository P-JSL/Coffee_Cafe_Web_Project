package com.usagi.Controller.Action.header;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usagi.Controller.Action.Action;

public class QnaAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//response.sendRedirect("community/QnA/QnA.jsp");
		
		RequestDispatcher rd = request.getRequestDispatcher("community/QnA/QnA.jsp");
		rd.forward(request, response);

	}

}

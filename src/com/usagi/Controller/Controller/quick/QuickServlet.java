package com.usagi.Controller.Controller.quick;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usagi.Controller.Action.Action;
import com.usagi.Controller.Controller.quick.ActionFactory;

@WebServlet("/quick")
public class QuickServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public QuickServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("link");
		System.out.println("처리하고자 하는 명령어 :" + command);
		
		ActionFactory af = ActionFactory.getInstance();
		Action action = af.getAction(command);
		
		
		if(action !=null) {
			action.execute(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
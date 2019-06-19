package com.test.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.Dao.WriteCsv;

/**
 * Servlet implementation class StudentAdd
 */
@WebServlet("/UserAdd")
public class UserAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String name = request.getParameter("username");
		String pw = request.getParameter("password");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String country = request.getParameter("country");
		String memo = request.getParameter("memo");
		
		List dataList = new ArrayList();
		dataList.add(name);
		dataList.add(pw);
		dataList.add(sex);
		dataList.add(age);
		dataList.add(country);
		dataList.add(memo);
		
		WriteCsv wtc = new WriteCsv(); 
		boolean isSuccess = wtc.exportCsv("user.csv", dataList);
		response.getWriter().print(isSuccess);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

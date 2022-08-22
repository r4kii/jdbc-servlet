package com.Ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentDetails
 */
@WebServlet("/Student")
public class StudentDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected  void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name = request.getParameter("name");
		int id = Integer.parseInt(request.getParameter("id"));
		String major = request.getParameter("major");
		
		PrintWriter out = response.getWriter();

		//out.print(name+"\t"+id+"\t"+major);
		
		Student student = new Student(id,name,major);

		StudentDao.insertStudent(student);
		ArrayList<Student> allStudents = StudentDao.showAllStudent();
		
		
				
		for(Student s:allStudents) {
			out.println(s.getId()+"\t"+s.getName()+"\t"+s.getMajor()+"\n");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

}

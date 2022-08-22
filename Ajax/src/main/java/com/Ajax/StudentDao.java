package com.Ajax;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

public class StudentDao{

    public static Connection getCon() {
        Connection con = null;
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/School";
            String un = "root";
            String pw = "MyNewPass1605";
             con = DriverManager.getConnection(url, un, pw);
             System.out.println("Connection Done");
            return con;
        } catch (SQLException | ClassNotFoundException e ) {
        	return null;
        }
    }
  
    public static void insertStudent(Student student) {
    	Connection con = getCon();
    	String query = "insert into student(name,major) values(?,?)";
    	PreparedStatement pst;
		try {
			pst = con.prepareStatement(query);
	    	pst.setString(1,student.getName());
	    	pst.setString(2, student.getMajor());
	    	pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    static ArrayList<Student> allStudent = new ArrayList<>();
    
    public static ArrayList<Student> showAllStudent() {
    	Connection con = getCon();
    	String query = "select * from student";
    	Statement  st;
    	try {
    		st = (Statement) con.createStatement();  
    		ResultSet rs = st.executeQuery(query);
    		while(rs.next()) {
    			int id = rs.getInt("student_id");
    			String name = rs.getString("name");
    			String major = rs.getString("major");
    			
    			Student student = new Student(id,name,major);
    			allStudent.add(student);
    		}
    		
    	}
    	catch (SQLException e){
    		e.printStackTrace();
    	}
    	return allStudent;
    	
    }

}

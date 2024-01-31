package kannan;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.JOptionPane;





public class mic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mic() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String name=request.getParameter("name");
		String panno=request.getParameter("panno");
		String renthome=request.getParameter("renthome");
		String rent=request.getParameter("rent");
		String grocery=request.getParameter("grocery");
		String email=request.getParameter("email");
		String salaryhike=request.getParameter("salaryhike");
		String salary=request.getParameter("salary");
		String fun=request.getParameter("fun");
		
		System.out.println(name);
		System.out.println(panno);
		System.out.println(renthome);
		System.out.println(rent);
		System.out.println(grocery);
		System.out.println(email);
		System.out.println(salaryhike);
		System.out.println(salary);
		System.out.println(fun);
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mic","root","root");
			Statement stmnt=con.createStatement();
			stmnt.executeUpdate("insert into micc values('"+name+"','"+panno+"','"+renthome+"','"+rent+"','"+grocery+"','"+email+"','"+salaryhike+"','"+salary+"','"+fun+"')");
			
		int	r = Integer.parseInt(rent);
	int g = Integer.parseInt(grocery);
		int s = Integer.parseInt(salaryhike);
		int s1= Integer.parseInt(salary);
		int f= Integer.parseInt(fun);
		
			  int t=r+g+s;
			  int r1=s1-t;
			  int r2=r1*f;
			  int r3=r2*65/100;
			  int r4=r3/12;
			  

if(r1<r2) {
      
	response.sendRedirect("loan.html");
			
		}else 
			response.sendRedirect("login.html");
		}
catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}}


	


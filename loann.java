package kannan;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class loann
 */
public class loann extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loann() {
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
		String loan=request.getParameter("loan");
		String year=request.getParameter("year");
		String rate=request.getParameter("rate");
		System.out.println(loan);
		System.out.println(year);
		System.out.println(rate);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loan","root","root");
			Statement stmnt=con.createStatement();
			stmnt.executeUpdate("insert into loan1 values('"+loan+"','"+year+"','"+rate+"')");
			
			int	l = Integer.parseInt(loan);
			int y = Integer.parseInt(year);
				int r = Integer.parseInt(rate);
				
			int m=y*12;
			int n=(r/100)/12;
			int s=m*m;
			int out=l*y/s;
			System.out.println(out);
			response.sendRedirect("fin.html");
			PrintWriter out1 = response.getWriter ();
			System.out.println(out);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

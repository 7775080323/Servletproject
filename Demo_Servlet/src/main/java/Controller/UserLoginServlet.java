package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserLoginController
 */
@WebServlet("/UserLoginController")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");

        // Setting the content type for the response
        response.setContentType("text/html");

        // Writing out the response
        PrintWriter out = response.getWriter();

        // Checking if the username and password are valid
        if (validateLogin(email, password)) {
            // Redirecting to the user dashboard if login is successful
            response.sendRedirect("dashboard.jsp");
        } else {
            // Sending error message if login fails
            out.println("<html><body>");
            out.println("<h3>Invalid username or password. Please try again.</h3>");
            out.println("<a href='login.jsp'>Go back to login</a>");
            out.println("</body></html>");
        }
    }

    // Method to validate the user credentials from the database
    private boolean validateLogin(String email, String password) {
        boolean isValid = false;
        
        // Database connection and validation
        try  {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            	Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/user_registration","root","Sunday$1");
       
             PreparedStatement stmt = con.prepareStatement("SELECT * FROM users WHERE email = ? AND password = ?");
             
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                isValid = true; // User found
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return isValid;
    }


	}



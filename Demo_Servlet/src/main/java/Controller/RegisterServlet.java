package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
//		String accNo = request.getParameter("accNo");
//		String name = request.getParameter("name");
//        String mobile = request.getParameter("mobile");
//        String email = request.getParameter("email");
//        String address = request.getParameter("address");
//        double balance = Double.parseDouble(request.getParameter("balance"));
//
//        
//        try{
//        	Class.forName("com.mysql.cj.jdbc.Driver");
//    		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/user_registration","root","Sunday$1");
////            String sql = "INSERT INTO users (name, mobile, email, address, balance) VALUES (?, ?, ?, ?, ?)";
//            PreparedStatement ps = con.prepareStatement("insert into users values(?,?,?,?,?,?)");
//            ps.setString(1, accNo);
//            ps.setString(2, name);
//            ps.setString(3, mobile);
//            ps.setString(4, email);
//            ps.setString(5, address);
//            ps.setDouble(6, balance);
//
//            int rowsInserted = ps.executeUpdate();
//            if (rowsInserted > 0) {
//            	response.setContentType("text/html");
//            	out.print("<h3 style='colour:green'> User Registration Successfully </h3>");
//            	
//               RequestDispatcher rd = request.getRequestDispatcher("/Register.jsp");
//            	rd.include(request, response);
//               
////                response.sendRedirect("login.html");
//            } else {
////                response.getWriter().println("Error: Unable to register the user.");
//            	response.setContentType("text/html");
//            	out.print("<h3 style='colour:green'> User Not Registration Successfully </h3>");
//            	
//               RequestDispatcher rd = request.getRequestDispatcher("/Register.jsp");
//            	rd.include(request, response);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            response.getWriter().println("Error: " + e.getMessage());
//        } catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}catch(Exception e) {
//			e.printStackTrace();
//			response.setContentType("text/html");
//        	out.print("<h3 style='colour:red'> Exception Occured : "+e.getMessage()+"</h3>" );
//        	
//           RequestDispatcher rd = request.getRequestDispatcher("/Register.jsp");
//        	rd.include(request, response);
//		}
//    
		
		
		        String accNo = request.getParameter("accNo");	
		        String name = request.getParameter("name");
		        String mobile = request.getParameter("mobile");
		        String ifsc = request.getParameter("ifsc");
		        String email = request.getParameter("email");		        		        
		        String password = request.getParameter("password");

		        // Validate all fields are filled
		        if (accNo==null || name == null || mobile == null || ifsc == null || email == null || password == null ||
		             accNo.trim().isEmpty() || name.trim().isEmpty() || mobile.trim().isEmpty() || ifsc.trim().isEmpty() || email.trim().isEmpty() || password.trim().isEmpty()) {
		            response.getWriter().println("Error: All fields are required!");
		            return;
		        }

		        try {
		        	    Class.forName("com.mysql.cj.jdbc.Driver");
		            	Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/user_registration","root","Sunday$1");
		                // Check if password already exists
//		                String checkaccNoSQL = "SELECT * FROM users WHERE accNo = ?";
//		                PreparedStatement checkaccNoStmt = con.prepareStatement(checkaccNoSQL);
//		                checkaccNoStmt.setString(1, accNo);
//		                if (checkaccNoStmt.executeQuery().next()) {
//		                    response.getWriter().println("Error: Account Number already exists!");
//		                    return;
//		                }
		                String checkemailSQL = "SELECT * FROM users WHERE email = ?";
		                PreparedStatement checkemailStmt = con.prepareStatement(checkemailSQL);
		                checkemailStmt.setString(1, email);
		                if (checkemailStmt.executeQuery().next()) {
		                    response.getWriter().println("Error: Email Address already exists!");
		                    return;
		                }
		                if (mobile.length() != 10 || !mobile.matches("\\d{10}")) {
		                    response.getWriter().println("Error: Mobile number must be exactly 10 digits.");
		                    return;
		                }

		                if (!email.matches("^[a-zA-Z]+[0-9]+@gmail\\.com$")) {
		                    response.getWriter().println("Error: Email must start with letters, followed by numbers, and end with '@gmail.com'.");
		                    return;
		                }
//		                if (!ifsc.matches("^[A-Z]{4}0[0-9]{6}$")) {
//		                    response.getWriter().println("Error: Invalid IFSC code format. Follow: SBIN0001234.");
//		                    return;
//		                }


		                // Insert the data into the database
		                String insertSQL = "INSERT INTO users (accno, name, mobile, ifsc, email, password) VALUES (?, ?, ?, ?, ?, ?)";
		                PreparedStatement ps = con.prepareStatement(insertSQL);
		                ps.setString(1, accNo);
		                ps.setString(2, name);
		                ps.setString(3, mobile);
		                ps.setString(4, ifsc);
		                ps.setString(5, email);
		                ps.setString(6, password);

		                int rowsInserted = ps.executeUpdate();
		                if (rowsInserted > 0) {
		                	response.setContentType("text/html");
		                	out.print("<h3 style='colour:green'> User Registration Successfully </h3>");
		                	
		                   RequestDispatcher rd = request.getRequestDispatcher("/Register.jsp");
		                	rd.include(request, response);
		                    response.sendRedirect("login.jsp");
		                } else {
		                	response.setContentType("text/html");
		                	out.print("<h3 style='colour:red'> Registration Failed</h3>");
		                	
		                   RequestDispatcher rd = request.getRequestDispatcher("/Register.jsp");
		                	rd.include(request, response);
//		                    response.getWriter().println("Error: Unable to register the user.");
		                }
		            
		        } catch (NumberFormatException e) {
		            response.getWriter().println("Error: Invalid balance entered!");
		        } catch (SQLException e) {
		            e.printStackTrace();
		            response.getWriter().println("Error: " + e.getMessage());
		        } catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}catch(Exception e) {
					e.printStackTrace();
					response.setContentType("text/html");
		        	out.print("<h3 style='colour:red'> Exception Occured : "+e.getMessage()+"</h3>" );
		        	
		           RequestDispatcher rd = request.getRequestDispatcher("/Register.jsp");
		        	rd.include(request, response);
				}
		    }
	

		        
	}


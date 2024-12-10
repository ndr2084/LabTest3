package labTest2Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dbutils.*;


/**
 * Servlet implementation class Processor1
 */
@WebServlet("/ServiceSelectorServlet")
public class ServiceSelectorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServiceSelectorServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			response.setContentType("text/html");
			String firstName = request.getParameter("theFirstName");
			String lastName = request.getParameter("theLastName");
			
			// CREATE USER SESSION
			HttpSession session = request.getSession();
			
			// CREATE DBUTILS OBJECT 
			UserDAOImpl age = new UserDAOImpl(); 
			
			
			// SET USER SESSION ATTRIBUTES
			session.setAttribute("fname", firstName);
			session.setAttribute("lname", lastName);
			
			// GET AGE FROM DB 
			session.setAttribute("age", age.getUserByName(firstName, lastName));
			
			String target = "/ServiceSelectorPage.jsp";
			request.getRequestDispatcher(target).forward(request, response);
		} catch (Exception exp) {
			System.out.println(exp);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

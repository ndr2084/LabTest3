package labTest2Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ServiceData;
import labTest2Services.IServiceInvoker;
import labTest2Services.ServiceInvokerFactory;

/**
 * Servlet implementation class Processor2
 */
@WebServlet("/ServiceInvokerServlet")
public class ServiceInvokerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceInvokerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String checked = request.getParameter("checked");
		HttpSession session = request.getSession(false);
		
		ServiceInvokerFactory aSIFactory = new ServiceInvokerFactory();
		
		//Polymorphism is happening -- 
		IServiceInvoker serviceInvoker = aSIFactory.createService(checked);
		
		ServiceData data = new ServiceData();
		String dataForField1 = (String) session.getAttribute("fname");
		data.setField1(dataForField1);
		String dataForField2 = (String) session.getAttribute("lname");
		data.setField2(dataForField2);
		String result = serviceInvoker.perform(data);
		System.out.println("The returned result is " + result);
		session.setAttribute("serviceResult", result);
		String target = "/ServiceInvokerPage.jsp";
		request.getRequestDispatcher(target).forward(request, response);
		
		//response.getWriter().append("The Selected Service: "+ result);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

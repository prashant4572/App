

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		 int status=0;
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String email=request.getParameter("email");
		String phoneno=request.getParameter("phoneno");
		String country=request.getParameter("country");
		
		Emp e=new Emp();
		e.setName(name);
		e.setPassword(password);
		e.setFirstName(firstname);
		e.setLastName(lastname);
		e.setEmail(email);
		e.setPhoneNo(phoneno);
		e.setCountry(country);
		if(name!=null)
			status = EmpDao.save(e);
		if(status>0){
					request.getRequestDispatcher("index.html").include(request, response);
					}else{
			out.println("Sorry! unable to save record");
		}
		request.getRequestDispatcher("ViewServlet").include(request, response);

		out.close();
	}

}

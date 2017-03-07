

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<a href='index.html'>Add New Employee</a>");
		out.println("<h1>Employees List</h1>");
		
		List<Emp> list=EmpDao.getAllEmployees();
		
		out.print("<table border='1' width='80%'");
		out.print("<col size=80><col size=80><col size=80><col size=130><col size=80><col size=40><col size=40>");
		out.print("<tr><th>First Name</th><th>Last Name</th><th>Email</th><th>PhoneNo</th><th>Country</th><th>Edit</th><th>Delete</th></tr>");
		for(Emp e:list){
			out.print("<tr><td>"+e.getFirstName()+"</td><td>"+e.getLastName()+"</td><td>"+e.getEmail()+"</td><td>"+e.getPhoneNo()+"</td><td>"+e.getCountry()+"</td><td><a href='EditServlet ? username="+e.getName()+"'>Edit</a></td><td><a href='DeleteServlet? username="+e.getName()+"'>Delete</a></td></tr>");
		}
		out.print("</table>");
		
		out.close();
	}
}

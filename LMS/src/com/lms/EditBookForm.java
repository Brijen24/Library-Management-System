package com.lms;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditBookForm
 */
@WebServlet("/EditBookForm")
public class EditBookForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Edit Book Form</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body style=\"background-color: #f3f2da;\">");
		
		request.getRequestDispatcher("navlibrarian.html").include(request, response);
		out.println("<div class='container'>");
		String callno=request.getParameter("callno");
		
		
		BookBean bean=BookDao.viewById(callno);
		
		out.print("<form action='EditBook' method='post' style='width:300px'>");
		out.print("<div class='form-group'>");
		out.print("<input type='hidden' name='callno' value='"+bean.getCallno()+"'/>");
		out.print("<label for='name1'>Name</label>");
		out.print("<input type='text' class='form-control' value='"+bean.getName()+"' name='name' id='name1' placeholder='Name'/>");
		out.print("</div>");
		out.print("<div class='form-group'>");
		out.print("<label for='author1'>Author</label>");
		out.print("<input type='text' class='form-control' value='"+bean.getAuthor()+"'  name='author' id='author1' placeholder='Email'/>");
		out.print("</div>");
		out.print("<div class='form-group'>");
		out.print("<label for='publisher1'>Publisher</label>");
		out.print("<input type='text' class='form-control' value='"+bean.getPublisher()+"'  name='publisher' id='publisher1' placeholder='Password'/>");
		out.print("</div>  ");
		out.print("<div class='form-group'>");
		out.print("<label for='quantity1'>Quantity</label>");
		out.print("<input type='number' class='form-control' value='"+bean.getQuantity()+"'  name='quantity' id='quantity1' placeholder='Mobile'/>");
		out.print("</div>");
		
		out.print("<button type='submit' class='btn btn-primary'>Update</button>");
		out.print("</form>");
		
		out.println("</div>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
		
	}

}

package com.lms;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewBookStudent
 */
@WebServlet("/ViewBookStudent")
public class ViewBookStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>View Book</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body style=\"background-color: #f3f2da;\">");
		request.getRequestDispatcher("navstudent.html").include(request, response);
		
		out.println("<div class='container'>");
		
		List<BookBean> list=BookDao.view();
		out.println("<h1>Available Books</h1>");
		out.println("<table class='table table-bordered'>");
		out.println("<tr><th>Callno</th><th>Name</th><th>Author</th><th>Publisher</th><th>Quantity</th><th>Issued</th></tr>");
		for(BookBean bean:list){
			out.println("<tr><td>"+bean.getCallno()+"</td><td>"+bean.getName()+"</td><td>"+bean.getAuthor()+"</td><td>"+bean.getPublisher()+"</td><td>"+bean.getQuantity()+"</td><td>"+bean.getIssued()+"</td></tr>");
		}
		out.println("</table>");
		
		out.println("</div>");
		
		
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}

}

package es.noelalonso.echoserver.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/echo/*")
public class EchoServerEchoServlet extends HttpServlet {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("EchoServerEchoServlet.service");
		
		String uri = request.getRequestURI();
		
		uri = uri.replace("/echo/", "");
		uri = uri.replace("/echo", "");
		
		response.getWriter().println(uri);
		response.getWriter().flush();
	}

	
}

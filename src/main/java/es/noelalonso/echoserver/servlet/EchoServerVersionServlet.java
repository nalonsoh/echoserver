package es.noelalonso.echoserver.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@WebServlet("/version")
public class EchoServerVersionServlet extends HttpServlet {

	private static final String VERSION = "v1.2";

	private static final Log LOGGER = LogFactory.getLog(EchoServerDefaultServlet.class);
	
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("EchoServerVersionServlet.service " + VERSION);
		
		response.getWriter().println(VERSION);
		response.getWriter().flush();
	}

	
}

package es.noelalonso.echoserver.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

@WebServlet("/*")
public class EchoServerDefaultServlet extends HttpServlet {
	
	private static final Log LOGGER = LogFactory.getLog(EchoServerDefaultServlet.class);

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	@Value("${echo.text:}")
    private String text;
	
	@Value("${echo.next:}")
    private String next;

	private RestTemplate restTemplate = new RestTemplate();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("EchoServerDefaultServlet.service");
		
		String responseText = this.text;
		
		if (StringUtils.hasText(this.next)) {
			String url = this.next;
			if (!url.startsWith("http")) {
				url = "http://" + url;
			}
			
			String nextResult = this.restTemplate.getForObject(url, String.class);
			LOGGER.debug("EchoServerDefaultServlet.nextResult: " + nextResult);
			
			responseText += " " + nextResult;
		}
		
		response.getWriter().println(responseText);
		response.getWriter().flush();
	}

	
}

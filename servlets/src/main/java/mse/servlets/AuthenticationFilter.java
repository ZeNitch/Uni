/**
 * 
 */
package mse.servlets;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * @author night
 *
 */
@WebFilter("/hello")
public class AuthenticationFilter implements Filter {


	@Override
	public void destroy() {


	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		String name = req.getParameter("name");
		if (name==null||name.isEmpty()) {
			resp.getWriter().println("<html><body>Please provide a name!</body></html>");
		}
		else {
			chain.doFilter(req, resp);
		}	

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}

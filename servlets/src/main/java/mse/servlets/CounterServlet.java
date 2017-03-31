package mse.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/counter")
public class CounterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Integer count = (Integer) session.getAttribute("counter");
		
		if (count==null) {
			count=0;
		}
		
		resp.getWriter().print("<html><body>Opened, " + ++count + " times</body></html>");
		session.setAttribute("counter", count);
		if (count>9) {
			session.invalidate();
		}
		
	}

}

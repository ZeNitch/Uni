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
		Integer count = (Integer) session.getAttribute("count");

		if (count == null) {
			count = 0;
		}
		
		count++;
		session.setAttribute("count", count);
		
		if (count == 10) {
			session.invalidate();
		}

		resp.getWriter().print("<html><body>Opened " + count + " times</html>");
	}

}

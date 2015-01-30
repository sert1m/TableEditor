package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Character;
import database.CharacterDAO;
/**
 * Servlet that updates and insert characters in database
 * @author timokhin
 *
 */
@SuppressWarnings("serial")
public class EditServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			    
			Character c = new Character(req);
			CharacterDAO dao = new CharacterDAO();
			String type = req.getParameter("type");
			if (type.equals("save")) {
				dao.updateCharacter(c);
			} 
			else if (type.equals("add")) {
				dao.insertCharacter(c);
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			sendException(resp, e);
		} catch (ParseException e) {
			e.printStackTrace();
			sendException(resp, e);
		}
	}
	/**
	 * 
	 * @param resp to past exception message
	 * @param e exception that was thrown
	 * @throws IOException
	 */
	private void sendException (HttpServletResponse resp, Exception e) throws IOException {
		String message = e.getMessage();
		resp.setContentType("text/txt; charset=UTF-8");
		resp.setContentLength(message.length());
		PrintWriter pw = resp.getWriter();
		pw.println(message);
		pw.flush();
		pw.close();
	}
}

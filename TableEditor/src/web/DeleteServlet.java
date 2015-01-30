package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.CharacterDAO;
/**
 * Servlet that delete character from database
 * @author timokhin 
 *
 */
@SuppressWarnings("serial")
public class DeleteServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			CharacterDAO dao = new CharacterDAO();
			String id = null;
			for (int i = 0; (id = req.getParameter("id" + i)) != null; i++) {
				dao.deleteCharacter(Integer.valueOf(id));			
			}
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

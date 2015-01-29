package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Character;
import database.CharacterDAO;

@SuppressWarnings("serial")
public class EditServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			Character c = new Character(req);
			System.err.println(c);
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
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

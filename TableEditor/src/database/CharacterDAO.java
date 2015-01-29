package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class CharacterDAO {
	
	private Connection con;
	
	public CharacterDAO () throws NamingException, SQLException {
		InitialContext initContext = new InitialContext();
		DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/Simpsons");
		con = (Connection) ds.getConnection();
	}
	
	public List<Character> getAllCharactes() throws SQLException {
		List<Character> res = null;
		
    	PreparedStatement stmt = null;
    	ResultSet rs = null;
    	
		try {
			stmt = con.prepareStatement("SELECT * FROM Characters");
			rs = stmt.executeQuery();
			
			res = new ArrayList<Character>(rs.getFetchSize());
			while (rs.next())
				res.add(new Character(rs));
			
		} finally {
		    if (rs != null)
		        rs.close();
		    if (stmt != null)
		    	stmt.close();
		}
		
		return res;
	}
	
	public Character getCharacter(int id) throws SQLException {
		Character res = null;
		
    	PreparedStatement stmt = null;
    	ResultSet rs = null;
    	
		try {
			stmt = con.prepareStatement("SELECT * FROM Characters where id=?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			if (rs.next())
				res = new Character(rs);
		} finally {
		    if (rs != null)
		        rs.close();
		    if (stmt != null)
		    	stmt.close();
		}
		
		return res;
	}
	
	public void deleteCharacter(int id) throws SQLException {
		
    	PreparedStatement stmt = null;
    	ResultSet rs = null;
    	System.err.println(id);
		try {
			stmt = con.prepareStatement("DELETE FROM Characters where id=?");
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} finally {
		    if (rs != null)
		        rs.close();
		    if (stmt != null)
		    	stmt.close();
		}
	}
	
	public void updateCharacter(Character c) throws SQLException {
    	PreparedStatement stmt = null;
    	ResultSet rs = null;
    	
		try {

			stmt = con.prepareStatement("UPDATE Characters SET FirstName=?, LastName=?, "
									  + "Sex=?, Date=?, Job=?, Salary=? WHERE id=?");
			
			stmt.setString(1, c.getFirstName());
			stmt.setString(2, c.getLastName());
			stmt.setString(3, c.getSex());
			stmt.setString(4, c.getDate());
			stmt.setString(5, c.getJob());
			stmt.setDouble(6, c.getSalary());
			stmt.setInt(7, c.getId());
			
			stmt.executeUpdate();
		} finally {
		    if (rs != null)
		        rs.close();
		    if (stmt != null)
		    	stmt.close();
		}
	}
	
	public void insertCharacter(Character c) throws SQLException {
    	PreparedStatement stmt = null;
    	ResultSet rs = null;
    	
		try {

			stmt = con.prepareStatement("INSERT INTO Characters (FirstName, LastName, Sex, Date, Job, Salary)"
									  + "VALUES (?, ?, ?, ?, ?, ?)");
			
			stmt.setString(1, c.getFirstName());
			stmt.setString(2, c.getLastName());
			stmt.setString(3, c.getSex());
			stmt.setString(4, c.getDate());
			stmt.setString(5, c.getJob());
			stmt.setDouble(6, c.getSalary());
			
			stmt.executeUpdate();
			
		} finally {
		    if (rs != null)
		        rs.close();
		    if (stmt != null)
		    	stmt.close();
		}
	}
}

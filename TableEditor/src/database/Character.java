package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
/**
 * This class encapsulates Character entity in database.
 * It contains constructors, getters and setters of it fields.
 * @author timokhin
 *
 */
public class Character {

	private int id;
	private String firstName;
	private String lastName;
	private String sex;
	private Date date;
	private String job;
	private double salary;
	
	private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
	public Character () {
		
	}
	/**
	 * Construct Character object from ResultSet
	 * @param rs result set of sql statement execution. 
	 * @throws SQLException if the columnLabel is not valid; 
	 * if a database access error occurs or this method is called on a closed result set
	 */
	public Character(ResultSet rs) throws SQLException {
		setId(rs.getInt("id"));
		setFirstName(rs.getString("FirstName"));
		setLastName(rs.getString("LastName"));
		setSex(rs.getString("Sex"));
		setDate(rs.getDate("Date"));
		setJob(rs.getString("Job"));
		setSalary(rs.getDouble("Salary"));
	}
	/**
	 * Construct Character object from ResultSet
	 * @param req request that contains character fields. 
	 * @throws ParseException date is not valid 
	 */
	public Character(HttpServletRequest req) throws ParseException {
		try {
			setId(Integer.valueOf(req.getParameter("id")));
		} catch (NumberFormatException e) {
			setId(0);
		}
		setFirstName(req.getParameter("firstName"));
		setLastName(req.getParameter("lastName"));
		setSex(req.getParameter("sex"));
		setDate(formatter.parse(req.getParameter("date")));
		setJob(req.getParameter("job"));
		try { 
			setSalary(Double.valueOf(req.getParameter("salary")));
		}
		catch (NumberFormatException e) {
			setSalary(0);
		}
	}
	
	public int getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getSex() {
		return sex;
	}
	public Date getDate() {
		return date;
	}
	public String getJob() {
		return job;
	}
	public double getSalary() {
		return salary;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Character [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", sex=" + sex + ", date=" + date
				+ ", job=" + job + ", salary=" + salary + "]";
	}
	
}

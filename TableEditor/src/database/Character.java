package database;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

public class Character {

	private int id;
	private String firstName;
	private String lastName;
	private String sex;
	private String date;
	private String job;
	private double salary;
	
	public Character () {
		
	}
	public Character(ResultSet rs) throws SQLException {
		setId(rs.getInt("id"));
		setFirstName(rs.getString("FirstName"));
		setLastName(rs.getString("LastName"));
		setSex(rs.getString("Sex"));
		setDate(rs.getString("Date"));
		setJob(rs.getString("Job"));
		setSalary(rs.getDouble("Salary"));
	}
	
	public Character(HttpServletRequest req) {
		try {
			setId(Integer.valueOf(req.getParameter("id")));
		} catch (NumberFormatException e) {
			setId(0);
		}
		setFirstName(req.getParameter("firstName"));
		setLastName(req.getParameter("lastName"));
		setSex(req.getParameter("sex"));
		setDate(req.getParameter("date"));
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
	public String getDate() {
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
	public void setDate(String date) {
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

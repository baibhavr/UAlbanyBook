package net.ualbanybook.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserModel extends BaseModel{

//	id username password profile_id	active role
	private String username, password, profile_id, active, role;
	
	public UserModel(String table) throws InstantiationException,
		IllegalAccessException, ClassNotFoundException, SQLException {
	super("account");
	// TODO Auto-generated constructor stub
	}

	/**
	 * If it is user
	 * @param username
	 * @param password
	 * @return true if user, false if not user
	 * @throws SQLException
	 */
	public boolean is_User(String username, String password) throws SQLException{
		Statement st = conn.createStatement();
	    sql = "SELECT count(*) " +
	    	  "FROM "+this.table+" " +
	  		  "where username = '"+username+"' " +
	  		  "and password = '"+password+"' "+
	  		  "and active = '1' and role = '1'";
	    
	    ResultSet rs = st.executeQuery(sql);
	    rs.next();
	    	    
		if(rs.getString(1).contains("0")){
			return false;
		}
		return true;
	}
	
	public boolean register(String username, String password) throws SQLException{
		Statement st = conn.createStatement();
	    sql = "SELECT count(*) " +
	    	  "FROM "+this.table+" " +
	  		  "where username = '"+username+"' " +
	  		  "and password = '"+password+"' "+
	  		  "and active = '1' and role = '1'";
	    
//	    ResultSet rs = st.executeUpdate(sql);
	    rs.next();
	    	    
		if(rs.getString(1).contains("0")){
			return false;
		}
		return true;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfile_id() {
		return profile_id;
	}

	public void setProfile_id(String profile_id) {
		this.profile_id = profile_id;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

		
	

}

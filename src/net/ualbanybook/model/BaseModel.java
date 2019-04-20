package net.ualbanybook.model;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.io.*;

import com.mysql.jdbc.Connection;

public class BaseModel {
	
	public String sql;
	public java.sql.Connection conn;
	public String table;
	
	public BaseModel(String table) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		conn = DriverManager.getConnection(
		"jdbc:mysql://localhost/ualbanybook", "root", "root");
		this.table = table;
	}
	
	public ResultSet getRow() throws SQLException{
		Statement st = conn.createStatement();
	    sql = "SELECT * FROM "+table;
	    return st.executeQuery(sql);
	}
	
	public boolean exists(String key, String value) throws SQLException{
		Statement st = conn.createStatement();
	    sql = "SELECT * FROM "+table+" where "+key+" = "+value;
	    ResultSet rs = st.executeQuery(sql);
	    if(rs.wasNull())
	    	return false;
	    return true;
	}
	
//	public String match(String key, String value) throws SQLException{
//		Statement st = conn.createStatement();
//	    sql = "SELECT id FROM "+table+" where "+key+" = "+value;
//	    ResultSet rs = st.executeQuery(sql);
//		if (!rs.wasNull())
//			return rs.getString("id"); 
//		return "-1";
//	}
	
	public String get_id(String key, String value) throws SQLException{
		Statement st = conn.createStatement();
	    sql = "SELECT id FROM "+table+" where "+key+" = "+value;
	    ResultSet rs = st.executeQuery(sql);
		if (!rs.wasNull())
			return rs.getString("id"); 
		return "-1";
	}
	
	public static String implodeArray(String[] inputArray, String glueString) {
		String output = "";
		if (inputArray.length > 0) {
			StringBuilder sb = new StringBuilder();
			sb.append(inputArray[0]);

			for (int i = 1; i < inputArray.length; i++) {
				sb.append(glueString);
				sb.append(inputArray[i]);
			}
			output = sb.toString();
		}
		return output;
	}
	

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

}

package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {
	
	private static Connection conn = null;
	
	public static Connection getConnection() {
		
		if (conn == null) {
			try {
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url, props);
			} catch (SQLException e) {
				throw new DbExceptions(e.getMessage());
			}
		}
		
		return conn;
		
	}
	
	public static void closedConnection() {
		
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new DbExceptions(e.getMessage());
			}
		}
		
	}
	
	private static Properties loadProperties() {
		
		Properties props = new Properties();
		try (FileInputStream fs = new FileInputStream("db.properties")){
			props.load(fs);
			return props;
			
		} catch (IOException e) {
			throw new DbExceptions(e.getMessage());
		}
		
	}

	public static void closedStatement(Statement st) {
		
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DbExceptions(e.getMessage());
			}
		}
		
	}
	
	public static void closedResultSet(ResultSet rs) {
		
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DbExceptions(e.getMessage());
			}
		}
		
	}

}

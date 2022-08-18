package data.database_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCConnector {
	Connection con;

	public Connection getCon() {
		try {
//			Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banking", "root", "1234");
		} catch (SQLException ex) {
			Logger.getLogger(JDBCConnector.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;

	}

}

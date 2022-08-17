package data.database_management;

import java.sql.*;

public class DatabaseManagement {
    private static DatabaseManagement databaseManagement;

    private JDBCConnector jdbc;
    private Connection con;
    private Statement st;
    private ResultSet rs;

    private DatabaseManagement() {
        this.jdbc = new JDBCConnector();
        this.con = this.jdbc.getCon();
    }

    public static DatabaseManagement getDatabaseManagement() {
        if (databaseManagement == null) {
            databaseManagement = new DatabaseManagement();
        }

        return databaseManagement;
    }

    public ResultSet doExecuteQuery(String query) {
        try {
            st = this.con.createStatement();
            rs = st.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return this.rs;
    }

    public void doQuery(String query) {
        try {
            st = this.con.createStatement();
            st.execute(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean doExecuteUpdate(String query) {
        try {
            st = this.con.createStatement();
            int i = st.executeUpdate(query);
            if (i == 1) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}

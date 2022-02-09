package oop_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    private final String user = "root";

    private final String pass = "";

    private final String add = "jdbc:mysql://localhost/dataofproject";

    public Connection connectt() throws SQLException {
        Connection c = DriverManager.getConnection(add, user, pass);
        return c;
    }
}

package com.Middlewares;

import java.sql.*;

public class Postgresql {
    private final String url = "jdbc:postgresql://localhost/postgres";
    private final String user = "postgres";
    private final String password = "postgres";

    private Connection connection;

    public Postgresql() {
        connect();
    }

    private void connect() {
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println("Unable to connect to the database!");
            System.out.println(e.getMessage());
        }
    }

    public ResultSet runSelect(String SQL) {
        try {
            Statement stmt = connection.createStatement();
            return stmt.executeQuery(SQL);
        } catch (SQLException ex) {
            System.out.println("Unable to perform the query!");
            System.out.println(ex.getMessage());
        }
        return null;
    }

    private Long runInsert(PreparedStatement pstmt) {
        long id = 0;
        try {
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println("Unable to perform the insertion!");
            System.out.println(ex.getMessage());
        }
        return id;
    }
};

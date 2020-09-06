package com.Services;
import com.Middlewares.Postgresql;
import com.Models.UserModel;

import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginService {
    Postgresql database = new Postgresql();

    public boolean userExists(String email) throws SQLException {
        String raw_query = "SELECT id FROM users WHERE email = '%s'";

        String query = String.format(raw_query, email);
        ResultSet rs = database.runSelect(query);
        rs.next();
        return rs.getRow() > 0;
    }

    public boolean isEmailAndPasswordCorrect(String email, String password) throws SQLException {
        String raw_query = "SELECT email, name, password FROM users WHERE email = '%s' AND password = '%s'";
        String query = String.format(raw_query, email, password);
        ResultSet rs = database.runSelect(query);
        rs.next();
        return rs.getRow() > 0;
    }

    public UserModel getUser(String email) throws SQLException {
        String raw_query = "SELECT email, name FROM users WHERE email = '%s'";
        String query = String.format(raw_query, email);
        ResultSet rs = database.runSelect(query);
        rs.next();
        return new UserModel(rs.getString("name"));
    }

    public boolean createUser(String email, String name, String password) {
        String raw_query = "INSERT INTO users(name, email, password) VALUES ('%s', '%s', '%s')";
        String query = String.format(raw_query, name, email, password);
        try {
            ResultSet rs = database.runSelect(query);
            rs.next();
            return rs.getRow() > 0;
        } catch (SQLException throwables) {
            return false;
        }
    }
}

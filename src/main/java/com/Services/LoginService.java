package com.Services;
import com.Middlewares.Postgresql;

import java.sql.SQLException;


public class LoginService {
    Postgresql database = new Postgresql();

    public boolean userExists(String email) throws SQLException {
        String raw_query = "SELECT id FROM users WHERE email = '%s'";

        String query = String.format(raw_query, email);
        return database.runSelect(query).getRow() != 0;
    }

    public boolean isEmailAndPasswordCorrect(String email, String password) throws SQLException {
        String raw_query = "SELECT email, password FROM users WHERE email = '%s' AND password = '%s'";
        String query = String.format(raw_query, email, password);
        return database.runSelect(query).getRow() != 0;
    }
}

package main.java.com.DAO;

import main.java.com.Middlewares.Http;

import java.io.IOException;
import java.util.HashMap;

public class UserDAO {

    private final String API_URL = "https://httpbin.org/post";

    public void SignUp(final String name, final String email, final String password) throws IOException {
        HashMap<String, String> parameters = new HashMap<String, String>() {{
            put("name", name);
            put ("email", email);
            put("password", password);
        }};

        Http.POST(API_URL, parameters);
    }
}

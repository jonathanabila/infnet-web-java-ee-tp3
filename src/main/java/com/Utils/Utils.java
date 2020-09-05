package com.Utils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Utils {
    public String BuildParameters(HashMap<String, String> parameters) {
        StringBuilder param = new StringBuilder("");
        for (Map.Entry<String, String> item : parameters.entrySet()) {
            if (param.toString().length() != 0) {
                param.append('&');
            }
            param.append(item.getKey());
            param.append('=');
            param.append(item.getValue());
        }
        return param.toString();
    }

    public void PushNotification(String message, String location, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.println("<script type=\"text/javascript\">");
        out.println(String.format("alert('%s');", message));
        out.println(String.format("location='%s.jsp';", location));
        out.println("</script>");
    }
}

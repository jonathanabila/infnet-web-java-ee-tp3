package main.java.com.Utils;

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
}

<%--
  Created by IntelliJ IDEA.
  User: jonathan
  Date: 05/09/2020
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Login</title>

    <style type="text/css">
        .container {
            display: flex;
            flex-direction: column;
            justify-content: center;
            text-align: center;
        }

        .container-line {
            display: flex;
            flex-direction: row;
            justify-content: center;
            align-items: center;
            text-align: center;
        }

        form {
            margin: 0 auto;
            width: 400px;
            padding: 1em;
            border: 1px solid #CCC;
            border-radius: 1em;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
        }

        input {
            margin: 10px 10px;
        }

        button {
            margin: 10px;
            max-width: 100px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Login</h2>
        <form action="login.jsp" method="get">
            <div class="container-line">
                <label for="email">Email:</label>
                <input type="text" id="email" name="user_email">
            </div>
            <div class="container-line">
                <label for="password">Senha:</label>
                <input type="password" id="password" name="user_password">
            </div>


            <button type="submit">Entrar</button>

            <button type="submit">Cadastrar-se</button>
        </form>
    </div>
</body>
</html>

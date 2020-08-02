<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <style type="text/css">
            form {
                margin: 0 auto;
                width: 400px;
                padding: 1em;
                border: 1px solid #CCC;
                border-radius: 1em;
            }

            ul {
                list-style: none;
                padding: 0;
                margin: 0;
                text-align: center;
            }

            form li + li {
                margin-top: 1em;
            }

            label {
                display: inline-block;
                width: 90px;
                text-align: right;
            }

            .button {
                padding-left: 90px;
            }

            button {
                margin-left: .5em;
            }
        </style>

        <title>TP1 - INFNET</title>
    </head>
    <body>
        <form action="AddUser" method="POST">
            <ul>
                <li>
                    <label for="name">Nome:</label>
                    <input type="text" id="name" name="user_name">
                </li>
                <li>
                    <label for="email">E-mail:</label>
                    <input type="text" id="email" name="user_email">
                </li>
                <li>
                    <label for="password">Senha:</label>
                    <input type="password" id="password" name="user_password">
               </li>
                <li class="button">
                    <button type="submit">Salvar</button>
                </li>
            </ul>
        </form>
    </body>
</html>

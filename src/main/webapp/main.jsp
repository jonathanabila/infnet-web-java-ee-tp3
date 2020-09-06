<%@ page import="com.Models.UserModel" %><%--
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
    <style type="text/css">
        .container {
            display: flex;
            flex-direction: column;
            justify-content: center;
            text-align: center;
        }
        .container-git p {
            font-size: 20px;
        }
    </style>
    <title>Main</title>
</head>
    <body>
        <div class="container">
            <h2>Main</h2>
            <div class="container-git">
                <p>
                    Link: <a href="https://github.com/jonathanabila/infnet-web-java-ee-tp3">https://github.com/jonathanabila/infnet-web-java-ee-tp3</a>
                </p>
                <p>
                    Aluno: Jonathan Abila
                </p>
                <p>
                    Curso: Engenharia de Software
                </p>
            </div>
            <div>
                <%
                    if(request.getAttribute("userModel") != null) {
                        UserModel userModel = (UserModel) request.getAttribute("userModel");
                        {%>
                            <p>Bem vindo <%=userModel.name%>!</p>
                        <%}
                    }
                %>
            </div>
            <div>
                Serviços
                    <p><a href="viacep.jsp">Consulta por CEP</a></p>
                    <p><a href="coingecko.jsp">Consulta de Bitcoins</a></p>
            </div>
        </div>
    </body>
</html>

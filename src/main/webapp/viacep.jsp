<%@ page import="com.Models.CepModel" %><%--
  Created by IntelliJ IDEA.
  User: jonathan
  Date: 05/09/2020
  Time: 11:57
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
        .container-line {
            display: flex;
            align-items: center;
            flex-direction: column;
        }
        .container-button {
            margin-bottom: 20px;
        }
        form {
            margin: 0 auto;
            width: 400px;
            padding: 1em;
            border: 1px solid #CCC;
            border-radius: 1em;
            display: flex;
            flex-direction: column;
        }
        input {
            margin: 10px 10px;
            min-width: 250px;
        }
    </style>
    <title>Via CEP</title>
</head>
    <body>
        <div class="container">
            <h2>CEP</h2>
            <form action="viacep" method="post">
                <div class="container-line">
                    <label for="cep">CEP:</label>
                    <input type="text" id="cep" name="cep">
                </div>
                <div class="container-button">
                    <%
                        String buttonText;
                        if(request.getAttribute("cepModel") != null) {
                            buttonText = "Reconsultar";
                        } else {
                            buttonText = "Consultar";
                        }
                        {%><button type="submit"><%=buttonText%></button><%}
                    %>
                </div>

                <%
                    if(request.getAttribute("cepModel") != null) {
                        CepModel cep = (CepModel) request.getAttribute("cepModel");
                        {%>
                            <div>
                                <div class="container-line">
                                    <label for="street">Rua:</label>
                                    <input name="street" value="<%=cep.getStreet()%>" type="text" id="street" readonly="readonly"/>
                                </div>
                                <div class="container-line">
                                    <label for="neighborhood">Bairro:</label>
                                    <input name="neighborhood" value="<%=cep.getNeighborhood()%>" type="text" id="neighborhood" readonly="readonly"/>
                                </div>
                                <div class="container-line">
                                    <label for="city">Cidade:</label>
                                    <input name="city" value="<%=cep.getCity()%>" type="text" id="city" readonly="readonly"/>
                                </div>
                                <div class="container-line">
                                    <label for="state">Estado:</label>
                                    <input name="state" value="<%=cep.getState()%>" type="text" id="state" readonly="readonly"/>
                                </div>
                                <div class="container-line">
                                    <label for="ibge">IBGE: </label>
                                    <input name="ibge" value="<%=cep.getIBGE()%>" type="text" id="ibge" readonly="readonly"/>
                                </div>
                            </div>
                        <%}
                    }
               %>
            </form>
        </div>
    </body>
</html>

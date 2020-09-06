<%@ page import="com.Models.PokemonModel" %>
<%@ page import="com.servlet.Pokemon" %><%--
  Created by IntelliJ IDEA.
  User: jonathan
  Date: 06/09/2020
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pokemon</title>
    <style type="text/css">
        .container {
            display: flex;
            flex-direction: column;
            justify-content: center;
            text-align: center;
        }
        .container-details {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            text-align: center;
        }
        .container-button {
            margin: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Busca de Pokemons</h2>
        <form action="pokemon" method="post">
            <div class="container-line">
                <label for="pokemon">Pokemon: </label>
                <input type="text" id="pokemon" name="pokemon">
            </div>
            <div class="container-button">
                <%
                    String buttonText;
                    if(request.getAttribute("pokemon") != null) {
                        buttonText = "Reconsultar";
                    } else {
                        buttonText = "Consultar";
                    }
                    {%><button type="submit"><%=buttonText%></button><%}
                %>
            </div>
            <%
                if(request.getAttribute("pokemon") != null) {
                    PokemonModel pokemon = (PokemonModel) request.getAttribute("pokemon");
                    {%>
                        <div class="container-details">
                            <label>Nome: <%=pokemon.name%></label>
                            <label>Peso: <%=pokemon.weight%></label>
                            <br/>
                            <a href="main.jsp">Menu</a>
                        </div>
                    <%}
                }
            %>
        </form>
    </div>
</body>
</html>

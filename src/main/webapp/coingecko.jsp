<%@ page import="java.util.ArrayList" %>
<%@ page import="com.Models.CoinsModel" %>
<%@ page import="com.Services.CoinsService" %>
<%@ page import="com.Models.CoinsModel" %>
<%@ page import="com.Models.CoinModel" %><%--
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
        .container-details {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            text-align: center;
        }
        .table {
            border: black 1px solid;
        }
        label {
            margin-top: 5px;
        }
        input {
            margin: 10px 10px;
        }
    </style>
    <title>Coin Gecko</title>
</head>
<body>
    <div class="container">
        <h2>Coin Gecko</h2>
        <h3>Power by <a href="https://www.coingecko.com/en/api#">CoinGecko API</a> </h3>
        <form action="coingecko" method="GET">
            <%
                CoinModel coin;
                ArrayList<CoinsModel> coins;

                if (request.getAttribute("coin") != null) {
                    coin = (CoinModel) request.getAttribute("coin");

                    {%>
                        <div class="container-details">
                            <label>Id: <%=coin.id%></label>
                            <label>Simbolo: <%=coin.symbol%></label>
                            <label>Nome: <%=coin.name%></label>
                            <label>Interesse público: <%=coin.publicInterestScore%></label>
                            <label>Rank: <%=coin.coinGeckoRank%></label>
                            <label>Plataforma: <%=coin.platform%></label>
                            <label>Data de criação: <%=coin.bornDate%></label>
                            <br/>
                            <a href="main.jsp">Menu</a>
                        </div>
                    <%}

                } else {
                    CoinsService coinsService = new CoinsService();
                    coins = coinsService.getCoins();

                    {%>
                        <table class="table" width="100%">
                            <thead>
                            <tr>
                                <th>Nome</th>
                                <th>Simbolo</th>
                                <th>Detalhes</th>
                            </tr>
                            </thead>
                            <tbody>
                            <%
                                for (com.Models.CoinsModel coinsModel: coins) {
                                    {%>
                                        <tr>
                                            <td><%=coinsModel.name%></td>
                                            <td><%=coinsModel.symbol%></td>
                                            <td>
                                                <a href="coingecko?id=<%=coinsModel.id%>">Detalhes</a>
                                            </td>
                                        </tr>
                                    <%}
                                }
                            %>
                            </tbody>
                        </table>
                    <%}
                }
            %>
        </form>
    </div>
</body>
</html>

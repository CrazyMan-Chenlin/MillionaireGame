<%--
  Created by IntelliJ IDEA.
  User: chenlin
  Date: 2018.7.12
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>MillionaireGame</title>
  </head>
  <body>
  <h2 style="text-align: center">Millionaire Game </h2>
  <hr>
  <form action=${pageContext.request.contextPath}/LogicalServlet method="get">
    <table border="1px"  width="400px" align="center">
      <%
        String status = (String) request.getAttribute("status");
        if (status!=null){
      %>
      <tr><th colspan="2">游戏<%=status%></th></tr>

      <tr><th>请输入数值</th>
        <td><input type="text" name="guessNum"/>&nbsp;&nbsp;
            <%
                if (status.equals("action")){
            %>
            <input type="submit" value="确定"/> <input type="hidden" name='count' value=${requestScope.count} />
                <%
                    }
                %>
        </td> </tr>
      <tr>
        <td colspan="2" style="text-align: center">${requestScope.message}
            <%
                if (status.equals("action")){
            %>
            您还剩${requestScope.count}次机会</td>
          <%
              }
          %>
      </tr>
      <%
        }
      %>
      <tr><td style="text-align: center" colspan="2"><input type="submit" value="开始游戏"/>

      </td>  </tr>
    </table>
  </form>
  <br>
  <span style="text-align: center">游戏规则：您有5次机会猜中系统产生的数字(0-30)，当您每次输入数值，点击确定。系统会给予您提示。倘若您猜中数字，便能获得百万大奖。</span>
  </body>
</html>

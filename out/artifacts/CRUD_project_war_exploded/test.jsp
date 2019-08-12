<%--
  Created by IntelliJ IDEA.
  User: myy
  Date: 2019/8/10
  Time: 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>all  customer</title>
</head>
<body>
<form action="allSelectServlet" method="post">
    <table>
        <tr>
            <td>id:</td>
            <td><input type="text" name="id"/></td>
        </tr>
        <tr>
            <td> NAME:</td>
            <td> <input type="text" name="name"/></td>
        </tr>
        <tr>
            <td> address:</td>
            <td> <input type="text" name="address"/></td>
        </tr>
        <tr>
            <td> phone</td>
            <td> <input type="text" name="phone"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"></td>
            <td><a href="add_list.jsp">create new customer</a></td>
        </tr>

    </table>
</form>

</body>
</html>

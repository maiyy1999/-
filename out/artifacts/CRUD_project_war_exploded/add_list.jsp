<%--
  Created by IntelliJ IDEA.
  User: myy
  Date: 2019/8/10
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加customer</title>
</head>
<body>
<form action="addServlet "mrthod="post">
    <table>
        <tr>
            <td>姓名：</td>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td>地址：</td>
            <td><input type="text" name="address"/></td>
        </tr>
        <tr>
            <td>电话：</td>
            <td><input type="text" name="phone"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"/></td>
        </tr>


    </table>




</form>
</body>
</html>

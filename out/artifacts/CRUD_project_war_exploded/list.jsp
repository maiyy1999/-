<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="allSelectServlet" method="post">
    <table >
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

<br>
<br>











<table border="1"cellpadding="10"cellspacing="0">
    <tr>
        <th>id</th>
        <th>NAME</th>
        <th>address</th>
        <th>phone</th>
        <th>operate</th>
    </tr>
<%--    //判断集合是否存在并且是否为空--%>
    <c:if test="${customers!=null&&customers.size()>0}">
        <c:forEach items="${customers}" var="cus" varStatus="s">
    <tr <c:if test="${s.count}%2==0"> style="background-color: blueviolet" </c:if>>
        <td>${cus.id}</td>
        <td>${cus.NAME}</td>
        <td>${cus.address}</td>
        <td>${cus.phone}</td>
        <td><a href="deleteServlet?id=${cus.id}">delete</a>|&nbsp;
            <a href="updateServlet?id=${cus.id}">update</a></td>

    </tr>
        </c:forEach>

    </c:if>
</table>
</body>
</html>

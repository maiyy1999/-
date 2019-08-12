<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>更改顾客属性</title>
</head>
<body>

<form action="updateServlet"method="post">
    <table>
    <c:if test="${list!=null&&list.size()>0}">
        <c:forEach items="${list}" var="cus" varStatus="cc">

            <tr>
                <td><input type="hidden" name="id" value="${cus.id}"/></td>
            </tr>
                <tr>
                    <td>name</td>
                    <td><input type="text" name="name" value="${cus.NAME}"/></td>
                </tr>
                <tr>
                    <td>address</td>
                    <td><input type="text" name="address" value="${cus.address}"/></td>
                </tr>
                <tr>
                    <td>phone</td>
                    <td><input type="text" name="phone" value="${cus.phone}"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="提交"/></td>
                </tr>


            </c:forEach>

    </c:if>


</table>

</form>
</body>
</html>

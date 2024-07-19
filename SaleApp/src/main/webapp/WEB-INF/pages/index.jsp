<%-- 
    Document   : index
    Created on : Jul 19, 2024, 9:37:09 AM
    Author     : MSI VN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang chủ</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <ul>
            <c:forEach items="${categories}" var="c">
            <li>
                ${c.name}
            </li>
            </c:forEach>
        </ul>
    </body>
</html>

<%-- 
    Document   : listBooks
    Created on : Nov 25, 2019, 5:55:04 PM
    Author     : user
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Список машин</title>
    </head>
    <body>
        <h1>Список наших машин</h1>
        <ol>
            <c:forEach var="car" items="${listCars}">
                <li>${car.marka}   ${car.model},  ${car.year},  ${car.price},  ${car.count}</li>
            </c:forEach>
        </ol>
    </body>
</html>

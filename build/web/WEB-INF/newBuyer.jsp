<%-- 
    Document   : newBook
    Created on : Nov 18, 2019, 7:21:01 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Новый покупатель</title>
    </head>
    <body>
        <h1>Внести покупателя в базу</h1>
        <form action="addBuyer" method="POST">
            Имя: <input type="text" name="name"><br>
            Фамилия: <input type="text" name="lastname"><br>
            E-mail: <input type="text" name="email"><br>
            Количество денег: <input type="text" name="money"><br>
            <input type="submit" value="Внести покупателя в базу"><br>
        </form>
    </body>
</html>

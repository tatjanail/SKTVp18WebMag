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
        <title>Новая машина</title>
    </head>
    <body>
        <h1>Внести машину в базу</h1>
        <form action="addCar" method="POST">
            Марка: <input type="text" name="marka"><br>
            Модель: <input type="text" name="model"><br>
            Год выпуска: <input type="text" name="year"><br>
            Стоимость: <input type="text" name="price"><br>
            Количество экземпляров: <input type="text" name="quantity"><br>
            <input type="submit" value="Внести машину в базу"><br>
        </form>
    </body>
</html>

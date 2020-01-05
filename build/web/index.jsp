<%-- 
    Document   : index
    Created on : Nov 4, 2019, 6:03:24 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Автомагазин "ExpertAuto"</title>
    </head>
    <body>
        <H1>Добро пожаловать в мир автомобилей!</H1>
        <h2>"ExpertAuto" предлагает широкий выбор машин.<h2>
        <h2>Приобретайте машины в нашем магазине!</h2>
        <p>${info}</p>
        
        <p><a href="showLogin">Вход</a></p>
        <p><a href="newCar">Внести машину в базу</a></p>
        <p><a href="listCars">Список машин</a></p>
        <p><a href="newBuyer">Внести покупателя в базу</a></p>
        <p><a href="listBuyers">Список покупателей</a></p>
        <a href="showTakeOnCar">Продать машину</a>
    </body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!--страница подгоняет свои размеры под размеры экрана устройства-->
    <title>Ввод данных</title>
</head>
<body>
<h2>Введите данные человека</h2>
<form action="insertUser" method="post"><!--связь с сервлетом InsertUserServlet через URL-паттерн insertUser-->
    <label for="name">Имя:</label>
    <input type="text" id="name" name="name" required><br/>

    <label for="surname">Фамилия:</label>
    <input type="text" id="surname" name="surname" required><br/>

    <label for="patronymic">Отчество:</label>
    <input type="text" id="patronymic" name="patronymic"><br/>

    <label for="age">Возраст:</label>
    <input type="number" id="age" name="age" required min="1"><br/>

    <input type="submit" value="Сохранить данные">
    <!--        <button type="submit">Сохранить</button>-->
</form>

<form action="displayUsers" method="get">
    <input type="submit" value="Отобразить данные">
</form>
</body>
</html>
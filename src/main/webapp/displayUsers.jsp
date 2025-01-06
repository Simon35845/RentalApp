<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Список пользователей</title>
</head>
<body>
<h1>Список пользователей</h1>

<form action="displayUsers" method="get">
    <input type="text" name="search" placeholder="Поиск по имени или фамилии">
    <input type="submit" value="Поиск">
</form>

<table border="1" bgcolor="#bdb76b">
    <th><a href="?sort=id&ascending=<c:choose><c:when test='${param.sort == "id" && param.ascending == "true"}'>false
</c:when><c:otherwise>true</c:otherwise></c:choose>">ID</a></th>
    <th><a href="?sort=name&ascending=<c:choose><c:when test='${param.sort == "name" && param.ascending == "true"}'>false
</c:when><c:otherwise>true</c:otherwise></c:choose>">Имя</a></th>
    <th><a href="?sort=surname&ascending=<c:choose><c:when test='${param.sort == "surname" && param.ascending == "true"}'>false
</c:when><c:otherwise>true</c:otherwise></c:choose>">Фамилия</a></th>
    <th><a href="?sort=patronymic&ascending=<c:choose><c:when test='${param.sort == "patronymic" && param.ascending == "true"}'>false
</c:when><c:otherwise>true</c:otherwise></c:choose>">Отчество</a></th>
    <th><a href="?sort=age&ascending=<c:choose><c:when test='${param.sort == "age" && param.ascending == "true"}'>false
</c:when><c:otherwise>true</c:otherwise></c:choose>">Возраст</a></th>

    <c:forEach var="person" items="${personList}"> <%--каждая итерация по коллекции personList будет сохранять текущий элемент в переменной person--%>
        <tr> <%--Начало строки таблицы--%>
            <td>${person.id}</td> <%--Ячейка таблицы, в которой отображается ID текущего объекта person--%>
            <td>${person.name}</td>
            <td>${person.surname}</td>
            <td>${person.patronymic}</td>
            <td>${person.age}</td>
        </tr>
    </c:forEach>
</table>
<form action="userInput.jsp" method="get">
    <input type="submit" value="Назад к вводу данных">
</form>
</body>
</html>
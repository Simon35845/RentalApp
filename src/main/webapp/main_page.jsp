<%@ page import="createdBy51mon.utils.servlet_constants.AddressServletConstants" %>
<%@ page import="createdBy51mon.utils.servlet_constants.PersonServletConstants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <title>RentalApp Main Page</title>
</head>
<h1>Добро пожаловать в RentalApp!</h1>
<br/>
<body>
<h2><a href="<%= AddressServletConstants.ADDRESSES_LIST_SERVLET %>">Список адресов</a></h2>
<br>
<h2><a href="<%= PersonServletConstants.PERSONS_LIST_SERVLET %>">Список лиц</a></h2>
</body>
</html>

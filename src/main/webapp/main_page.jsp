<%@ page import="createdBy51mon.utils.servlet_constants.PersonServletConstants" %>
<%@ page import="createdBy51mon.utils.servlet_constants.ApartmentServletConstants" %>
<%@ page import="createdBy51mon.utils.servlet_constants.AddressServletConstants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <title>Главная страница</title>
    <style>
        body {
            margin: 20px;
        }

        .apartments-list-link-button, .addresses-list-link-button, .persons-list-link-button {
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            color: white;
            border-radius: 5px;
            cursor: pointer;
            border: none;
            white-space: nowrap;
        }

        .apartments-list-link-button {
            display: inline-block;
            background-color: rgba(214, 108, 33, 0.8);
        }

        .addresses-list-link-button {
            display: inline-block;
            background-color: rgba(45, 173, 184, 0.8);
        }

        .persons-list-link-button {
            display: inline-block;
            background-color: rgba(156, 81, 227, 0.76);
        }

        .button-container {
            display: flex;
            align-items: center;
            margin-top: 30px;
            gap: 20px;
        }

        .apartments-list-link-button:hover,
        .addresses-list-link-button:hover,
        .persons-list-link-button:hover {
            opacity: 0.8;
        }
    </style>
</head>
<h1>Добро пожаловать в RentalApp!</h1>
<br/>
<body>
<div class="button-container">
    <a class="apartments-list-link-button" href="<%= ApartmentServletConstants.APARTMENTS_LIST_SERVLET %>">Список квартир</a>
    <br/>
    <a class="addresses-list-link-button" href="<%= AddressServletConstants.ADDRESSES_LIST_SERVLET %>">Список адресов</a>
    <br/>
    <a class="persons-list-link-button" href="<%= PersonServletConstants.PERSONS_LIST_SERVLET %>">Список лиц</a>
</div>
</body>
</html>

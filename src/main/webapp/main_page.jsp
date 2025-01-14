<%@ page import="createdBy51mon.utils.servlet_constants.AddressServletConstants" %>
<%@ page import="createdBy51mon.utils.servlet_constants.PersonServletConstants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <title>RentalApp Main Page</title>
    <style>
        body {
            margin: 20px;
        }

        .address-list-link-button, .person-list-link-button {
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            color: white;
            border-radius: 5px;
            cursor: pointer;
            border: none;
            white-space: nowrap;
        }

        .address-list-link-button {
            display: inline-block;
            background-color: rgba(45, 173, 184, 0.8);
        }

        .person-list-link-button {
            display: inline-block;
            background-color: rgba(156, 81, 227, 0.76);
        }

        .button-container {
            display: flex;
            align-items: center;
            margin-top: 30px;
            gap: 30px;
        }

        .address-list-link-button:hover,
        .person-list-link-button:hover {
            opacity: 0.8;
        }
    </style>
</head>
<h1>Добро пожаловать в RentalApp!</h1>
<br/>
<body>
<div class="button-container">
    <a class="address-list-link-button" href="<%= AddressServletConstants.ADDRESSES_LIST_SERVLET %>">Список адресов</a>
    <br/>
    <a class="person-list-link-button" href="<%= PersonServletConstants.PERSONS_LIST_SERVLET %>">Список лиц</a>
</div>
</body>
</html>

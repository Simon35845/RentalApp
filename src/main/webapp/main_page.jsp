<%@ page import="createdBy51mon.utils.servlet_constants.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <title>Главная страница</title>
    <style>
        body {
            margin: 20px;
            background-color: rgba(211, 211, 207, 0.65);
        }

        h1 {
            margin-bottom: 20px;
        }

        .apartments-list-link-button,
        .addresses-list-link-button,
        .persons-list-link-button,
        .landlords-list-link-button,
        .tenants-list-link-button {
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            color: white;
            border-radius: 5px;
            cursor: pointer;
            border: none;
            white-space: nowrap;
            display: inline-block;
            width: 180px;
        }

        .apartments-list-link-button {
            background-color: rgba(214, 77, 46, 0.8);
        }

        .addresses-list-link-button {
            background-color: rgba(35, 193, 169, 0.8);
        }

        .persons-list-link-button {
            background-color: rgba(114, 95, 230, 0.76);
        }

        .landlords-list-link-button {
            background-color: rgba(220, 180, 46, 0.76);
        }

        .tenants-list-link-button {
            background-color: rgba(211, 60, 163, 0.76);
        }

        .button-container {
            display: grid;
            grid-template-columns: repeat(3, 1fr);
            gap: 20px;
            margin-top: 30px;
            max-width: 400px;
            justify-items: start;
        }

        .apartments-list-link-button:hover,
        .addresses-list-link-button:hover,
        .persons-list-link-button:hover,
        .landlords-list-link-button:hover,
        .tenants-list-link-button:hover {
            opacity: 0.8;
        }
    </style>
</head>
<h1>Добро пожаловать в RentalApp!</h1>
<br/>
<body>
<div class="button-container">
    <a class="apartments-list-link-button" href="<%= ApartmentServletConstants.APARTMENTS_LIST_SERVLET %>">
        Список квартир</a>
    <a class="addresses-list-link-button" href="<%= AddressServletConstants.ADDRESSES_LIST_SERVLET %>">
        Список адресов</a>
    <a class="persons-list-link-button" href="<%= PersonServletConstants.PERSONS_LIST_SERVLET %>">
        Список лиц</a>
    <a class="landlords-list-link-button" href="<%= LandlordServletConstants.LANDLORDS_LIST_SERVLET %>">
        Список арендодателей</a>
    <a class="tenants-list-link-button" href="<%= TenantServletConstants.TENANTS_LIST_SERVLET %>">
        Список квартиросъемщиков</a>
</div>
</body>
</html>

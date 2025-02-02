<%@ page import="createdBy51mon.utils.servlet_constants.PersonServletConstants" %>
<%@ page import="createdBy51mon.utils.servlet_constants.ApartmentServletConstants" %>
<%@ page import="createdBy51mon.utils.servlet_constants.AddressServletConstants" %>
<%@ page import="createdBy51mon.utils.servlet_constants.LandlordServletConstants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <title>Главная страница</title>
    <style>
        body {
            margin: 20px;
        }

        h1 {
            margin-bottom: 20px; /* Отступ между заголовком и кнопками */
        }

        .apartments-list-link-button,
        .addresses-list-link-button,
        .persons-list-link-button,
        .landlords-list-link-button {
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            color: white;
            border-radius: 5px;
            cursor: pointer;
            border: none;
            white-space: nowrap;
            width: 180px; /* Фиксированная ширина для кнопок */
            /*flex: 0 0 calc(50% - 20px); !* Каждая кнопка займет 50% ширины, минус gap *!*/
            /*box-sizing: border-box; !* Учитываем размеры при расчете ширины *!*/
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

        .landlords-list-link-button {
            display: inline-block;
            background-color: rgba(230, 205, 58, 0.76);
        }

        /*.button-container {*/
        /*    display: flex;*/
        /*    flex-wrap: wrap; !* Позволяет элементам переноситься на следующую строку *!*/
        /*    justify-content: center; !* Центрируем кнопки по горизонтали *!*/
        /*    align-items: center;*/
        /*    margin-top: 30px;*/
        /*    gap: 20px;*/
        /*}*/

        .button-container {
            display: grid; /* Используем grid для создания сетки */
            grid-template-columns: repeat(2, 1fr); /* Две колонки одинаковой ширины */
            gap: 20px; /* Пробел между кнопками */
            margin-top: 30px;
            max-width: 400px; /* Максимальная ширина контейнера */
            justify-items: start; /* Выравнивание кнопок по левому краю */
            /*justify-items: center; !* Центрируем кнопки внутри ячейки *!*/
        }

            .apartments-list-link-button:hover,
        .addresses-list-link-button:hover,
        .persons-list-link-button:hover,
        .landlords-list-link-button:hover {
            opacity: 0.8;
        }
    </style>
</head>
<h1>Добро пожаловать в RentalApp!</h1>
<br/>
<body>
<%--<div class="button-container">--%>
<%--    <a class="apartments-list-link-button" href="<%= ApartmentServletConstants.APARTMENTS_LIST_SERVLET %>">Список--%>
<%--        квартир</a>--%>
<%--    <br/>--%>
<%--    <a class="addresses-list-link-button" href="<%= AddressServletConstants.ADDRESSES_LIST_SERVLET %>">Список--%>
<%--        адресов</a>--%>
<%--    <br/>--%>
<%--    <a class="persons-list-link-button" href="<%= PersonServletConstants.PERSONS_LIST_SERVLET %>">Список лиц</a>--%>
<%--    <br/>--%>
<%--    <a class="landlords-list-link-button" href="<%= LandlordServletConstants.LANDLORDS_LIST_SERVLET %>">Список--%>
<%--        арендодателей</a>--%>
<%--</div>--%>

<div class="button-container">
    <a class="apartments-list-link-button" href="<%= ApartmentServletConstants.APARTMENTS_LIST_SERVLET %>">Список квартир</a>
    <a class="addresses-list-link-button" href="<%= AddressServletConstants.ADDRESSES_LIST_SERVLET %>">Список адресов</a>
    <a class="persons-list-link-button" href="<%= PersonServletConstants.PERSONS_LIST_SERVLET %>">Список лиц</a>
    <a class="landlords-list-link-button" href="<%= LandlordServletConstants.LANDLORDS_LIST_SERVLET %>">Список арендодателей</a>
</div>
</body>
</html>

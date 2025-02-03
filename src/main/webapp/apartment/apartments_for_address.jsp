<%@ page import="createdBy51mon.dto.ApartmentDTO" %>
<%@ page import="java.util.Set" %>
<%@ page import="createdBy51mon.dto.AddressDTO" %>
<%@ page import="createdBy51mon.utils.servlet_constants.AddressServletConstants" %>
<%@ page import="createdBy51mon.utils.servlet_constants.ApartmentServletConstants" %>
<%@ page import="java.util.List" %>
<%@ page import="createdBy51mon.utils.servlet_constants.CommonServletConstants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <title>Квартиры для адреса</title>
    <style>
        body {
            margin: 20px;
        }

        table {
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: center;
        }

        th {
            background-color: rgba(204, 225, 216, 0.7);
        }

        td {
            background-color: rgba(230, 230, 200, 0.78);
        }

        .save-link-button, .main-link-button {
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            color: white;
            border-radius: 5px;
            cursor: pointer;
            border: none;
            white-space: nowrap;
        }

        .save-link-button {
            display: inline-block;
            background-color: #43a600;
        }

        .main-link-button {
            display: inline-block;
            background-color: #007BFF;
        }

        .button-container-1 {
            display: flex;
            align-items: center;
            margin-top: 30px;
            gap: 30px;
        }

        .save-link-button:hover,
        .main-link-button:hover {
            opacity: 0.8;
        }
    </style>
</head>
<body>
<%AddressDTO address = (AddressDTO) request.getAttribute(AddressServletConstants.ADDRESS_ATTRIBUTE); %>
<h2>Квартиры, связанные с адресом:
    г. <%= address.getCity() %>,
    ул. <%= address.getStreet() %>,
    д. <%= address.getHouseNumber() %>.</h2>

<table>
    <tr>
        <th>ID</th>
        <th>Номер квартиры</th>
        <th>Этаж</th>
        <th>Количество комнат</th>
        <th>Общая площадь</th>
    </tr>
    <%
        List<ApartmentDTO> apartments = (List<ApartmentDTO>) request.getAttribute(ApartmentServletConstants.APARTMENT_LIST_ATTRIBUTE);
        for (ApartmentDTO apartment : apartments) { %>
    <tr>
        <td><%= apartment.getId() %></td>
        <td><%= apartment.getApartmentNumber() %></td>
        <td><%= apartment.getFloor() %></td>
        <td><%= apartment.getCountOfRooms() %></td>
        <td><%= apartment.getTotalSquare() %></td>
    </tr>
    <% } %>
</table>
<div class="button-container-1">
    <a class="save-link-button" href="<%= AddressServletConstants.ADDRESS_SAVE_SERVLET %>">Добавить запись</a>
    <br/>
    <a class="main-link-button" href="<%= CommonServletConstants.MAIN_PAGE_SERVLET %>">Вернуться на главную</a>
</div>
</body>
</html>
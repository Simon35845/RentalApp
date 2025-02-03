<%@ page import="createdBy51mon.dto.AddressDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="createdBy51mon.utils.servlet_constants.CommonServletConstants" %>
<%@ page import="createdBy51mon.utils.servlet_constants.AddressServletConstants" %>
<%@ page import="createdBy51mon.utils.servlet_constants.ApartmentServletConstants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <title>Список адресов</title>
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

        .update-button,
        .delete-button,
        .apartments-button,
        .save-link-button,
        .apartments-list-link-button,
        .main-link-button {
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            color: white;
            border-radius: 5px;
            cursor: pointer;
            border: none;
            white-space: nowrap;
            display: inline-block;
        }

        .update-button {
            background-color: #FF881F;
        }

        .delete-button {
            background-color: #f44336;
        }

        .apartments-button,
        .apartments-list-link-button {
            background-color: #007BFF;
            width: 180px;
        }

        .save-link-button {
            background-color: #43a600;
            width: 180px;
        }

        .main-link-button {
            background-color: #8f55cc;
            width: 180px;
        }

        .button-container-1 {
            display: grid;
            grid-template-columns: repeat(3, 1fr);
            gap: 20px;
            margin-top: 30px;
            max-width: 400px;
            justify-items: start;
        }

        .button-container-2 {
            display: flex;
            align-items: center;
            justify-content: center;
            gap: 20px;
        }

        .update-button:hover,
        .delete-button:hover,
        .apartments-button:hover,
        .save-link-button:hover,
        .apartments-list-link-button,
        .main-link-button:hover {
            opacity: 0.8;
        }
    </style>
</head>
<body>
<h2>Список адресов</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Город</th>
        <th>Улица</th>
        <th>Номер дома</th>
        <th>Действия</th>
    </tr>
    <% List<AddressDTO> addresses = (List<AddressDTO>) request.getAttribute(AddressServletConstants.ADDRESSES_LIST_ATTRIBUTE);
        for (AddressDTO address : addresses) {
    %>
    <tr>
        <td><%= address.getId() %>
        </td>
        <td><%= address.getCity() %>
        </td>
        <td><%= address.getStreet() %>
        </td>
        <td><%= address.getHouseNumber() %>
        </td>
        <td>
            <div class="button-container-2">
                <form style="display: inline;"
                      name="update"
                      method="get"
                      action="<%= AddressServletConstants.ADDRESS_UPDATE_SERVLET %>">
                    <button class="update-button"
                            name="<%= AddressServletConstants.ADDRESS_ID_PARAM %>"
                            value="<%= address.getId() %>">
                        Изменить
                    </button>
                </form>
                <form style="display: inline;"
                      name="delete"
                      method="post"
                      action="<%= AddressServletConstants.ADDRESS_DELETE_SERVLET %>">
                    <button class="delete-button"
                            name="<%= AddressServletConstants.ADDRESS_ID_PARAM %>"
                            value="<%= address.getId() %>">
                        Удалить
                    </button>
                </form>
                <form style="display: inline;"
                      name="apartments"
                      method="get"
                      action="<%= ApartmentServletConstants.APARTMENTS_FOR_ADDRESS_SERVLET %>">
                    <button class="apartments-button"
                            name="<%= AddressServletConstants.ADDRESS_ID_PARAM %>"
                            value="<%= address.getId() %>">
                        Связанные квартиры
                    </button>
                </form>
            </div>
        </td>
    </tr>
    <% } %>
</table>
<div class="button-container-1">
    <a class="save-link-button" href="<%= AddressServletConstants.ADDRESS_SAVE_SERVLET %>">
        Добавить запись</a>
    <a class="apartments-list-link-button" href="<%= ApartmentServletConstants.APARTMENTS_LIST_SERVLET %>">
        Список квартир</a>
    <a class="main-link-button" href="<%= CommonServletConstants.MAIN_PAGE_SERVLET %>">
        Вернуться на главную</a>
</div>
</body>
</html>

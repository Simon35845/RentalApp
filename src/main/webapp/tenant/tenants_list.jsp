<%@ page import="java.util.List" %>
<%@ page import="createdBy51mon.utils.servlet_constants.CommonServletConstants" %>
<%@ page import="createdBy51mon.dto.TenantDTO" %>
<%@ page import="createdBy51mon.utils.servlet_constants.TenantServletConstants" %>
<%@ page import="createdBy51mon.utils.servlet_constants.PersonServletConstants" %>
<%@ page import="createdBy51mon.utils.servlet_constants.LandlordServletConstants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <title>Список квартиросъемщиков</title>
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
        .save-link-button,
        .persons-list-link-button,
        .landlords-list-link-button,
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

        .save-link-button {
            background-color: #43a600;
            width: 180px;
        }

        .persons-list-link-button,
        .landlords-list-link-button {
            background-color: #007BFF;
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
        .save-link-button:hover,
        .persons-list-link-button,
        .landlords-list-link-button,
        .main-link-button:hover{
            opacity: 0.8;
        }
    </style>
</head>
<body>
<h2>Список квартиросъемщиков</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Фамилия</th>
        <th>Имя</th>
        <th>Отчество</th>
        <th>Возраст</th>
        <th>Действия</th>
    </tr>
    <% List<TenantDTO> tenants = (List<TenantDTO>) request.getAttribute(TenantServletConstants.TENANTS_LIST_ATTRIBUTE);
        for (TenantDTO tenant : tenants) {
    %>
    <tr>
        <td><%= tenant.getId() %>
        </td>
        <td><%= tenant.getSurname() %>
        </td>
        <td><%= tenant.getName() %>
        </td>
        <td><%= tenant.getPatronymic() %>
        </td>
        <td><%= tenant.getAge() %>
        </td>
        <td>
            <div class="button-container-2">
            <form style="display: inline;"
                    name="update"
                  method="get"
                  action="<%= TenantServletConstants.TENANT_UPDATE_SERVLET %>">
                <button class="update-button"
                        name="<%= TenantServletConstants.TENANT_ID_PARAM %>"
                        value="<%= tenant.getId() %>">
                    Изменить
                </button>
            </form>
            <form style="display: inline;"
                    name="delete"
                  method="post"
                  action="<%= TenantServletConstants.TENANT_DELETE_SERVLET %>">
                <button class="delete-button"
                        name="<%= TenantServletConstants.TENANT_ID_PARAM %>"
                        value="<%= tenant.getId() %>">
                    Удалить
                </button>
            </form>
            </div>
        </td>
    </tr>
    <% } %>
</table>
<div class="button-container-1">
    <a class="save-link-button" href="<%= TenantServletConstants.TENANT_SAVE_SERVLET %>">
        Добавить запись</a>
    <a class="persons-list-link-button" href="<%= PersonServletConstants.PERSONS_LIST_SERVLET %>">
        Список лиц</a>
    <a class="landlords-list-link-button" href="<%= LandlordServletConstants.LANDLORDS_LIST_SERVLET %>">
        Список арендодателей</a>
    <a class="main-link-button" href="<%= CommonServletConstants.MAIN_PAGE_SERVLET %>">
        Вернуться на главную</a>
</div>
</body>
</html>

<%@ page import="java.util.List" %>
<%@ page import="createdBy51mon.utils.servlet_constants.CommonServletConstants" %>
<%@ page import="createdBy51mon.dto.TenantDTO" %>
<%@ page import="createdBy51mon.utils.servlet_constants.TenantServletConstants" %>
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

        .update-button, .delete-button, .save-link-button, .main-link-button {
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            color: white;
            border-radius: 5px;
            cursor: pointer;
            border: none;
            white-space: nowrap;
        }

        .update-button {
            background-color: #FF881F;
        }

        .delete-button {
            background-color: #f44336;
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

        .button-container-2 {
            display: flex;
            align-items: center;
            justify-content: center;
            gap: 20px;
        }

        .update-button:hover,
        .delete-button:hover,
        .save-link-button:hover,
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
    <%
        }
    %>
</table>
<div class="button-container-1">
    <a class="save-link-button" href="<%= TenantServletConstants.TENANT_SAVE_SERVLET %>">Добавить запись</a>
    <br/>
    <a class="main-link-button" href="<%= CommonServletConstants.MAIN_PAGE_SERVLET %>">Вернуться на главную</a>
</div>
</body>
</html>

<%@ page import="createdBy51mon.utils.servlet_constants.PersonServletConstants" %>
<%@ page import="createdBy51mon.dto.PersonDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="createdBy51mon.utils.servlet_constants.CommonServletConstants" %>
<%@ page import="createdBy51mon.utils.servlet_constants.LandlordServletConstants" %>
<%@ page import="createdBy51mon.utils.servlet_constants.TenantServletConstants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <title>Список персонала</title>
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
        .landlords-list-link-button,
        .tenants-list-link-button,
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

        .landlords-list-link-button,
        .tenants-list-link-button {
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
        .landlords-list-link-button,
        .tenants-list-link-button,
        .main-link-button:hover {
            opacity: 0.8;
        }
    </style>
</head>
<body>
<h2>Список персонала</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Фамилия</th>
        <th>Имя</th>
        <th>Отчество</th>
        <th>Возраст</th>
        <th>Арендодатель</th>
        <th>Квартиросъемщик</th>
        <th>Действия</th>
    </tr>
    <% List<PersonDTO> persons = (List<PersonDTO>) request.getAttribute(PersonServletConstants.PERSONS_LIST_ATTRIBUTE);
        for (PersonDTO person : persons) {
    %>
    <tr>
        <td><%= person.getId() %>
        </td>
        <td><%= person.getSurname() %>
        </td>
        <td><%= person.getName() %>
        </td>
        <td><%= person.getPatronymic() %>
        </td>
        <td><%= person.getAge() %>
        </td>
        <td><input type="checkbox" <%= person.getIsLandlord() ? "checked" : "" %> disabled>
        </td>
        <td><input type="checkbox" <%= person.getIsTenant() ? "checked" : "" %> disabled>
        </td>
        <td>
            <div class="button-container-2">
                <form style="display: inline;"
                      name="update"
                      method="get"
                      action="<%= PersonServletConstants.PERSON_UPDATE_SERVLET %>">
                    <button class="update-button"
                            name="<%= PersonServletConstants.PERSON_ID_PARAM %>"
                            value="<%= person.getId() %>">
                        Изменить
                    </button>
                </form>
                <form style="display: inline;"
                      name="delete"
                      method="post"
                      action="<%= PersonServletConstants.PERSON_DELETE_SERVLET %>">
                    <button class="delete-button"
                            name="<%= PersonServletConstants.PERSON_ID_PARAM %>"
                            value="<%= person.getId() %>">
                        Удалить
                    </button>
                </form>
            </div>
        </td>
    </tr>
    <% } %>
</table>
<div class="button-container-1">
    <a class="save-link-button" href="<%= PersonServletConstants.PERSON_SAVE_SERVLET %>">Добавить запись</a>
    <a class="landlords-list-link-button" href="<%= LandlordServletConstants.LANDLORDS_LIST_SERVLET %>">
        Список арендодателей</a>
    <a class="tenants-list-link-button" href="<%= TenantServletConstants.TENANTS_LIST_SERVLET %>">
        Список квартиросъемщиков</a>
    <a class="main-link-button" href="<%= CommonServletConstants.MAIN_PAGE_SERVLET %>">Вернуться на главную</a>
</div>
</body>
</html>

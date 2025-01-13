<%@ page import="createdBy51mon.utils.servlet_constants.PersonServletConstants" %>
<%@ page import="createdBy51mon.dto.PersonDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="createdBy51mon.utils.servlet_constants.CommonServletConstants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <title>Persons List</title>
    <style>
        table {
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: center;
        }
    </style>
</head>
<body>
<h1>Список лиц</h1>
<table>
    <tr>
        <td>ID</td>
        <td>Фамилия</td>
        <td>Имя</td>
        <td>Отчество</td>
        <td>Возраст</td>
    </tr>
    <% List<PersonDTO> persons = (List<PersonDTO>) request.getAttribute(PersonServletConstants.PERSONS_LIST_ATTRIBUTE);
        for (PersonDTO person : persons) {
    %>
    <tr>
        <td><%= person.getId()%>
        </td>
        <td><%= person.getSurname()%>
        </td>
        <td><%= person.getName()%>
        </td>
        <td><%= person.getPatronymic()%>
        </td>
        <td><%= person.getAge()%>
        </td>
        <td>
            <form name="delete"
                  method="post"
                  action="<%= PersonServletConstants.PERSON_DELETE_SERVLET%>">
                <button name="<%= CommonServletConstants.ID_PARAM%>"
                        value="<%= person.getId()%>">
                    Удалить запись
                </button>
            </form>
        </td>
        <td>
            <form name="update"
                  method="get"
                  action="<%= PersonServletConstants.PERSON_UPDATE_SERVLET%>">
                <button name="<%= CommonServletConstants.ID_PARAM%>"
                        value="<%= person.getId()%>">
                    Обновить запись
                </button>
            </form>
        </td>
    </tr>
    <%
        }
    %>
</table>
<br/>
<a href="<%= PersonServletConstants.PERSON_SAVE_SERVLET%>"><h3>Добавить запись в список</h3></a>
<br/>
<a href="<%= CommonServletConstants.MAIN_PAGE_SERVLET %>"><h3>Вернуться на главную</h3></a>
</body>
</html>

<%@ page import="createdBy51mon.utils.ServletConstants" %>
<%@ page import="createdBy51mon.dto.PersonDTO" %>
<%@ page import="java.util.List" %>
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
<a href="<%= ServletConstants.PERSONS_SAVE_SERVLET%>"><h1>СТРАНИЦА СОХРАНЕНИЯ ЗАПИСЕЙ ЛЮДЕЙ</h1></a><br/>
<br/>
<h1>Список лиц</h1>
<table>
    <tr>
        <td>ID</td>
        <td>Имя</td>
        <td>Фамилия</td>
        <td>Отчество</td>
        <td>Возраст</td>
    </tr>
<% List<PersonDTO> persons = (List<PersonDTO>) request.getAttribute(ServletConstants.PERSONS_LIST_ATTRIBUTE);
        for (PersonDTO person : persons) {
    %>
    <tr>
        <td><%= person.getId()%>
        </td>
        <td><%= person.getName()%>
        </td>
        <td><%= person.getSurname()%>
        </td>
        <td><%= person.getPatronymic()%>
        </td>
        <td><%= person.getAge()%>
        </td>
        <td>
            <form name="delete"
                  method="post"
                  action="<%= ServletConstants.PERSONS_DELETE_SERVLET%>">
                <button name="<%= ServletConstants.PERSON_ID_PARAM%>"
                        value="<%= person.getId()%>">
                    Удалить запись
                </button>
            </form>
        </td>
        <td>
            <form name="update"
                  method="get"
                  action="<%= ServletConstants.PERSONS_UPDATE_SERVLET%>">
                <button name="<%= ServletConstants.PERSON_ID_PARAM%>"
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
</body>
</html>

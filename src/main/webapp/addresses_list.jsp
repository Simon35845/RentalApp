<%@ page import="createdBy51mon.dto.AddressDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="createdBy51mon.utils.servlet_constants.CommonServletConstants" %>
<%@ page import="createdBy51mon.utils.servlet_constants.AddressServletConstants" %>
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
<a href="<%= AddressServletConstants.ADDRESS_SAVE_SERVLET%>"><h3>Добавить запись в список</h3></a><br/>
<br/>
<h1>Список адресов</h1>
<table>
    <tr>
        <td>ID</td>
        <td>Город</td>
        <td>Улица</td>
        <td>Номер дома</td>
    </tr>
    <% List<AddressDTO> addresses = (List<AddressDTO>) request.getAttribute(AddressServletConstants.ADDRESSES_LIST_ATTRIBUTE);
        for (AddressDTO address : addresses) {
    %>
    <tr>
        <td><%= address.getId()%>
        </td>
        <td><%= address.getCity()%>
        </td>
        <td><%= address.getStreet()%>
        </td>
        <td><%= address.getHouseNumber()%>
        </td>
        <td>
            <form name="delete"
                  method="post"
                  action="<%= AddressServletConstants.ADDRESS_DELETE_SERVLET%>">
                <button name="<%= CommonServletConstants.ID_PARAM%>"
                        value="<%= address.getId()%>">
                    Удалить запись
                </button>
            </form>
        </td>
        <td>
            <form name="update"
                  method="get"
                  action="<%= AddressServletConstants.ADDRESS_UPDATE_SERVLET%>">
                <button name="<%= CommonServletConstants.ID_PARAM%>"
                        value="<%= address.getId()%>">
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

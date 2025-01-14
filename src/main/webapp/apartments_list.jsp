<%@ page import="java.util.List" %>
<%@ page import="createdBy51mon.utils.servlet_constants.CommonServletConstants" %>
<%@ page import="createdBy51mon.dto.ApartmentDTO" %>
<%@ page import="createdBy51mon.utils.servlet_constants.ApartmentServletConstants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
  <title>Apartments List</title>
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
<h2>Список квартир</h2>
<table>
  <tr>
    <th>ID</th>
    <th>Номер квартиры</th>
    <th>Этаж</th>
    <th>Количество комнат</th>
    <th>Действия</th>
  </tr>
  <% List<ApartmentDTO> apartments = (List<ApartmentDTO>) request.getAttribute(ApartmentServletConstants.APARTMENT_LIST_ATTRIBUTE);
    for (ApartmentDTO apartment : apartments) {
  %>
  <tr>
    <td><%= apartment.getId() %>
    </td>
    <td><%= apartment.getNumber() %>
    </td>
    <td><%= apartment.getFloor() %>
    </td>
    <td><%= apartment.getCountOfRooms() %>
    </td>
    <td>
      <div class="button-container-2">
        <form name="update"
              method="get"
              action="<%= ApartmentServletConstants.APARTMENT_UPDATE_SERVLET %>">
          <button class="update-button"
                  name="<%= CommonServletConstants.ID_PARAM %>"
                  value="<%= apartment.getId() %>">
            Изменить
          </button>
        </form>
        <form name="delete"
              method="post"
              action="<%= ApartmentServletConstants.APARTMENT_DELETE_SERVLET %>">
          <button class="delete-button"
                  name="<%= CommonServletConstants.ID_PARAM %>"
                  value="<%= apartment.getId() %>">
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
  <a class="save-link-button" href="<%= ApartmentServletConstants.APARTMENT_SAVE_SERVLET %>">Добавить запись</a>
  <br/>
  <a class="main-link-button" href="<%= CommonServletConstants.MAIN_PAGE_SERVLET %>">Вернуться на главную</a>
</div>
</body>
</html>

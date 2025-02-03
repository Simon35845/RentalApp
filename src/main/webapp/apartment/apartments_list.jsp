<%@ page import="java.util.List" %>
<%@ page import="createdBy51mon.utils.servlet_constants.CommonServletConstants" %>
<%@ page import="createdBy51mon.dto.ApartmentDTO" %>
<%@ page import="createdBy51mon.utils.servlet_constants.ApartmentServletConstants" %>
<%@ page import="createdBy51mon.utils.servlet_constants.AddressServletConstants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
  <title>Список квартир</title>
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
    .addresses-list-link-button,
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

    .addresses-list-link-button {
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
    .addresses-list-link-button,
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
    <th>Общая площадь квартиры (м2)</th>
    <th>Город</th>
    <th>Улица</th>
    <th>Номер дома</th>
    <th>Действия</th>
  </tr>
  <% List<ApartmentDTO> apartments = (List<ApartmentDTO>) request.getAttribute(ApartmentServletConstants.APARTMENT_LIST_ATTRIBUTE);
    for (ApartmentDTO apartment : apartments) {
  %>
  <tr>
    <td><%= apartment.getId() %>
    </td>
    <td><%= apartment.getApartmentNumber() %>
    </td>
    <td><%= apartment.getFloor() %>
    </td>
    <td><%= apartment.getCountOfRooms() %>
    </td>
    <td><%= apartment.getTotalSquare() %>
    </td>
    <td><%= apartment.getAddress().getCity() %>
    </td>
    <td><%= apartment.getAddress().getStreet() %>
    </td>
    <td><%= apartment.getAddress().getHouseNumber() %>
    </td>
    <td>
      <div class="button-container-2">
        <form name="update"
              method="get"
              action="<%= ApartmentServletConstants.APARTMENT_UPDATE_SERVLET %>">
          <button class="update-button"
                  name="<%= ApartmentServletConstants.APARTMENT_ID_PARAM %>"
                  value="<%= apartment.getId() %>">
            Изменить
          </button>
        </form>
        <form name="delete"
              method="post"
              action="<%= ApartmentServletConstants.APARTMENT_DELETE_SERVLET %>">
          <button class="delete-button"
                  name="<%= ApartmentServletConstants.APARTMENT_ID_PARAM %>"
                  value="<%= apartment.getId() %>">
            Удалить
          </button>
        </form>
      </div>
    </td>
  </tr>
  <% } %>
</table>
<div class="button-container-1">
  <a class="save-link-button" href="<%= ApartmentServletConstants.APARTMENT_SAVE_SERVLET %>">
    Добавить запись</a>
  <a class="addresses-list-link-button" href="<%= AddressServletConstants.ADDRESSES_LIST_SERVLET %>">
    Список адресов</a>
  <a class="main-link-button" href="<%= CommonServletConstants.MAIN_PAGE_SERVLET %>">
    Вернуться на главную</a>
</div>
</body>
</html>

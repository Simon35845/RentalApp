<%@ page import="createdBy51mon.utils.servlet_constants.ApartmentServletConstants" %>
<%@ page import="createdBy51mon.dto.AddressDTO" %>
<%@ page import="createdBy51mon.utils.servlet_constants.AddressServletConstants" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <title>Сохранение квартиры</title>
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

        form {
            display: flex;
            flex-direction: column;
            width: 200px;
        }

        label {
            margin-bottom: 15px;
        }

        input[type="text"] {
            margin-top: 5px;
            padding: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #e0f7fa;
            width: 100%;
            box-sizing: border-box;
        }

        .save-button, .list-link-button {
            display: inline-block;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            color: white;
            border-radius: 5px;
            cursor: pointer;
            border: none;
            white-space: nowrap;
        }

        .save-button {
            background-color: #43a600;
        }

        .list-link-button {
            background-color: #007BFF;
        }

        .button-container {
            display: flex;
            align-items: center;
            margin-top: 20px;
            gap: 30px;
        }

        .save-button:hover,
        .list-link-button:hover {
            opacity: 0.8;
        }
    </style>
</head>
<body>
<h2>Сохранение квартиры</h2>
<%List<AddressDTO> addresses = (List<AddressDTO>) request.getAttribute(AddressServletConstants.ADDRESSES_LIST_ATTRIBUTE); %>
<form name="save"
      method="post"
      action="<%= ApartmentServletConstants.APARTMENT_SAVE_SERVLET %>">
    <label>
        Выберите адрес:
        <select name="<%= AddressServletConstants.ADDRESS_ID_PARAM%>" required>
            <option value="" disabled selected>Выберите адрес</option>
            <% for (AddressDTO address : addresses) { %>
            <option value="<%= address.getId() %>">
                <%= address.getCity() + ", " + address.getStreet() + ", " + address.getHouseNumber() %>
            </option>
            <% } %>
        </select>
    </label>
    <label>
        Или <a href="<%= AddressServletConstants.ADDRESS_SAVE_SERVLET %>">добавьте новый адрес</a>
    </label>
    <label>
        Введите номер квартиры:
        <input name="<%= ApartmentServletConstants.APARTMENT_NUMBER_PARAM %>" type="text" required>
    </label>
    <label>
        Введите этаж:
        <input name="<%= ApartmentServletConstants.APARTMENT_FLOOR_PARAM %>" type="text" required>
    </label>
    <label>
        Введите количество комнат:
        <input name="<%= ApartmentServletConstants.APARTMENT_COUNT_OF_ROOMS_PARAM %>" type="text" required>
    </label>
    <label>
        Введите общую площадь квартиры (м2):
        <input name="<%= ApartmentServletConstants.APARTMENT_TOTAL_SQUARE_PARAM %>" type="text" required>
    </label>
    <div class="button-container">
        <button class="save-button" type="submit">Сохранить</button>
        <a class="list-link-button" href="<%= ApartmentServletConstants.APARTMENTS_LIST_SERVLET %>">
            Вернуться к списку квартир</a>
    </div>
</form>
</body>
</html>

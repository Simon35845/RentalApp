<%@ page import="createdBy51mon.dto.ApartmentDTO" %>
<%@ page import="createdBy51mon.utils.servlet_constants.ApartmentServletConstants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <title>Update apartment</title>
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
<% ApartmentDTO apartment = (ApartmentDTO) request.getAttribute(ApartmentServletConstants.APARTMENT_ATTRIBUTE); %>
<h2>Изменение записей квартир</h2>
<form name="update"
      method="post"
      action="<%= ApartmentServletConstants.APARTMENT_UPDATE_SERVLET %>">
    <input name="<%= ApartmentServletConstants.APARTMENT_ID_PARAM %>"
           type="hidden"
           value="<%= apartment.getId() %>"
           required>
    <label>
        Изменить номер квартиры:
        <input name="<%= ApartmentServletConstants.APARTMENT_NUMBER_PARAM %>"
               type="text"
               value="<%= apartment.getApartmentNumber() %>"
               required>
    </label>
    <label>
        Изменить этаж:
        <input name="<%= ApartmentServletConstants.APARTMENT_FLOOR_PARAM %>"
               type="text"
               value="<%= apartment.getFloor() %>"
               required>
    </label>
    <label>
        Изменить количество комнат:
        <input name="<%= ApartmentServletConstants.APARTMENT_COUNT_OF_ROOMS_PARAM %>"
               type="text"
               value="<%= apartment.getCountOfRooms() %>"
               required>
    </label>
    <label>
        Изменить общую площадь квартиры (м2):
        <input name="<%= ApartmentServletConstants.APARTMENT_TOTAL_SQUARE_PARAM %>"
               type="text"
               value="<%= apartment.getTotalSquare() %>"
               required>
    </label>
    <div class="button-container">
        <button class="save-button" type="submit">Сохранить</button>
        <a class="list-link-button" href="<%= ApartmentServletConstants.APARTMENTS_LIST_SERVLET %>">Вернуться к списку квартир</a>
    </div>
</form>
</body>
</html>

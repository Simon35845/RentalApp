<%@ page import="createdBy51mon.dto.AddressDTO" %>
<%@ page import="createdBy51mon.utils.servlet_constants.AddressServletConstants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <title>Изменение адреса</title>
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
<%AddressDTO address = (AddressDTO) request.getAttribute(AddressServletConstants.ADDRESS_ATTRIBUTE); %>
<h2>Изменение адреса</h2>
<form name="update"
      method="post"
      action="<%= AddressServletConstants.ADDRESS_UPDATE_SERVLET %>">
    <input name="<%= AddressServletConstants.ADDRESS_ID_PARAM %>"
           type="hidden"
           value="<%= address.getId() %>"
           required>
    <label>
        Изменить город:
        <input name="<%= AddressServletConstants.ADDRESS_CITY_PARAM %>"
               type="text"
               value="<%= address.getCity() %>"
               required>
    </label>
    <br/>
    <label>
        Изменить улицу:
        <input name="<%= AddressServletConstants.ADDRESS_STREET_PARAM %>"
               type="text"
               value="<%= address.getStreet() %>"
               required>
    </label>
    <br/>
    <label>
        Изменить номер дома:
        <input name="<%= AddressServletConstants.ADDRESS_HOUSE_NUMBER_PARAM %>"
               type="text"
               value="<%= address.getHouseNumber() %>"
               required>
    </label>
    <div class="button-container">
        <button class="save-button" type="submit">Сохранить</button>
        <a class="list-link-button" href="<%= AddressServletConstants.ADDRESSES_LIST_SERVLET %>">Вернуться к списку адресов</a>
    </div>
</form>
</body>
</html>

<%@ page import="createdBy51mon.utils.servlet_constants.AddressServletConstants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <title>Save address</title>
</head>
<body>
<h2>Сохранение адресов</h2>
<form name="save"
      method="post"
      action="<%= AddressServletConstants.ADDRESS_SAVE_SERVLET%>">
    <label>
        Введите город:
        <input name="<%= AddressServletConstants.ADDRESS_CITY_PARAM%>" type="text" required>
    </label>
    <br/>
    <label>
        Введите улицу:
        <input name="<%= AddressServletConstants.ADDRESS_STREET_PARAM%>" type="text" required>
    </label>
    <br/>
    <label>
        Введите номер дома:
        <input name="<%= AddressServletConstants.ADDRESS_HOUSE_NUMBER_PARAM%>" type="text" required>
    </label>
    <br/>
    <button>Сохранить!</button>
</form>
<br/>
<a href="<%= AddressServletConstants.ADDRESSES_LIST_SERVLET %>">Вернуться к списку адресов</a><br/>
</body>
</html>

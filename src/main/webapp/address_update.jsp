<%@ page import="createdBy51mon.dto.AddressDTO" %>
<%@ page import="createdBy51mon.utils.servlet_constants.CommonServletConstants" %>
<%@ page import="createdBy51mon.utils.servlet_constants.AddressServletConstants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <title>Update address</title>
</head>

<body>
<%AddressDTO address = (AddressDTO) request.getAttribute(AddressServletConstants.ADDRESS_ATTRIBUTE); %>
<h2>Изменение записей адресов</h2>
<form name="update"
      method="post"
      action="<%= AddressServletConstants.ADDRESS_UPDATE_SERVLET%>">
    <input name="<%= CommonServletConstants.ID_PARAM%>"
           type="hidden"
           value="<%= address.getId()%>"
           required>
    <label>
        Изменить город:
        <input name="<%= AddressServletConstants.ADDRESS_CITY_PARAM%>"
               type="text"
               value="<%= address.getCity()%>"
               required>
    </label>
    <br/>
    <label>
        Изменить улицу:
        <input name="<%= AddressServletConstants.ADDRESS_STREET_PARAM%>"
               type="text"
               value="<%= address.getStreet()%>"
               required>
    </label>
    <br/>
    <label>
        Изменить номер дома:
        <input name="<%= AddressServletConstants.ADDRESS_HOUSE_NUMBER_PARAM%>"
               type="text"
               value="<%= address.getHouseNumber()%>"
               required>
    </label>
    <br/>
    <button>Сохранить!</button>
</form>
<br/>
<a href="<%= AddressServletConstants.ADDRESSES_LIST_SERVLET %>">Вернуться к списку адресов</a><br/>
</body>
</html>

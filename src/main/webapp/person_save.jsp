<%@ page import="createdBy51mon.utils.servlet_constants.PersonServletConstants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <title>Save person</title>
</head>
<body>
<h2>Сохранение записей людей</h2>
<form name="save"
      method="post"
      action="<%= PersonServletConstants.PERSONS_SAVE_SERVLET%>">
    <label>
        Введите фамилию:
        <input name="<%= PersonServletConstants.PERSON_SURNAME_PARAM%>" type="text" required>
    </label>
    <br/>
    <label>
        Введите имя:
        <input name="<%= PersonServletConstants.PERSON_NAME_PARAM%>" type="text" required>
    </label>
    <br/>
    <label>
        Введите отчество*:
        <input name="<%= PersonServletConstants.PERSON_PATRONYMIC_PARAM%>" type="text">
    </label>
    <br/>
    <label>
        Введите возраст:
        <input name="<%= PersonServletConstants.PERSON_AGE_PARAM%>" type="text" required>
    </label>
    <br/>
    <button>Сохранить!</button>
</form>
<br/>
<a href="<%= PersonServletConstants.PERSONS_LIST_SERVLET %>">Вернуться к списку лиц</a><br/>
<p>*Данные поля заполнять необязательно</p>
</body>
</html>

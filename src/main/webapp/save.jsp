<%@ page import="createdBy51mon.utils.ServletConstants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <title>Save person</title>
</head>
<body>
<h2>Сохранение записей людей</h2>
<form name="save"
      method="post"
      action="<%= ServletConstants.PERSONS_SAVE_SERVLET%>">
    <label>
        Введите имя:
        <input name="<%= ServletConstants.PERSON_NAME_PARAM%>" type="text" required>
    </label>
    <br/>
    <label>
        Введите фамилию:
        <input name="<%= ServletConstants.PERSON_SURNAME_PARAM%>" type="text" required>
    </label>
    <br/>
    <label>
        Введите отчество*:
        <input name="<%= ServletConstants.PERSON_PATRONYMIC_PARAM%>" type="text">
    </label>
    <br/>
    <label>
        Введите возраст:
        <input name="<%= ServletConstants.PERSON_AGE_PARAM%>" type="text" required>
    </label>
    <br/>
    <button>Сохранить!</button>
</form>
<br/>
<a href="<%= ServletConstants.PERSONS_LIST_SERVLET%>">ВЕРНУТЬСЯ К СПИСКУ ЛИЦ</a><br/>
<p>*Данные поля заполнять необязательно</p>
</body>
</html>

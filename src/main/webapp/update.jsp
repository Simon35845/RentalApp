<%@ page import="createdBy51mon.dto.PersonDTO" %>
<%@ page import="createdBy51mon.utils.ServletConstants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <title>Update person</title>
</head>
<body>
<%PersonDTO p = (PersonDTO) request.getAttribute(ServletConstants.PERSON_ATTRIBUTE); %>
<h2>Изменение записей людей</h2>
<form name="update"
      method="post"
      action="<%= ServletConstants.PERSONS_UPDATE_SERVLET%>">
    <input name="<%= ServletConstants.PERSON_ID_PARAM%>"
           type="hidden"
           value="<%= p.getId()%>"
           required>
    <label>
        Изменить имя:
        <input name="<%= ServletConstants.PERSON_NAME_PARAM%>"
               type="text"
               value="<%= p.getName()%>"
               required>
    </label>
    <br/>
    <label>
        Изменить фамилию:
        <input name="<%= ServletConstants.PERSON_SURNAME_PARAM%>"
               type="text"
               value="<%= p.getSurname()%>"
               required>
    </label>
    <br/>
    <br/>
    <label>
        Изменить отчество:
        <input name="<%= ServletConstants.PERSON_PATRONYMIC_PARAM%>"
               type="text"
               value="<%= p.getPatronymic()%>"
               required>
    </label>
    <br/>
    <label>
        Изменить возраст:
        <input name="<%= ServletConstants.PERSON_AGE_PARAM%>"
               type="text"
               value="<%= p.getAge()%>">
    </label>
    <br/>
    <button>Сохранить!</button>
</form>
<br/>
<a href="<%= ServletConstants.PERSONS_LIST_SERVLET%>">ВЕРНУТЬСЯ К СПИСКУ ЛИЦ</a><br/>
</body>
</html>

<%@ page import="createdBy51mon.dto.PersonDTO" %>
<%@ page import="createdBy51mon.utils.servlet_constants.PersonServletConstants" %>
<%@ page import="createdBy51mon.utils.servlet_constants.CommonServletConstants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <title>Update person</title>
</head>

<body>
<%PersonDTO person = (PersonDTO) request.getAttribute(PersonServletConstants.PERSON_ATTRIBUTE); %>
<h2>Изменение записей людей</h2>
<form name="update"
      method="post"
      action="<%= PersonServletConstants.PERSON_UPDATE_SERVLET%>">
    <input name="<%= CommonServletConstants.ID_PARAM%>"
           type="hidden"
           value="<%= person.getId()%>"
           required>
    <label>
        Изменить фамилию:
        <input name="<%= PersonServletConstants.PERSON_SURNAME_PARAM%>"
               type="text"
               value="<%= person.getSurname()%>"
               required>
    </label>
    <br/>
    <label>
        Изменить имя:
        <input name="<%= PersonServletConstants.PERSON_NAME_PARAM%>"
               type="text"
               value="<%= person.getName()%>"
               required>
    </label>
    <br/>
    <label>
        Изменить отчество:
        <input name="<%= PersonServletConstants.PERSON_PATRONYMIC_PARAM%>"
               type="text"
               value="<%= person.getPatronymic()%>"
               required>
    </label>
    <br/>
    <label>
        Изменить возраст:
        <input name="<%= PersonServletConstants.PERSON_AGE_PARAM%>"
               type="text"
               value="<%= person.getAge()%>"
               required>
    </label>
    <br/>
    <button>Сохранить!</button>
</form>
<br/>
<a href="<%= PersonServletConstants.PERSONS_LIST_SERVLET %>">Вернуться к списку лиц</a><br/>
</body>
</html>

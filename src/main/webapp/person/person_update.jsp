<%@ page import="createdBy51mon.dto.PersonDTO" %>
<%@ page import="createdBy51mon.utils.servlet_constants.PersonServletConstants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <title>Изменение персонала</title>
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

        .save-button,
        .list-link-button {
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
<% PersonDTO person = (PersonDTO) request.getAttribute(PersonServletConstants.PERSON_ATTRIBUTE); %>
<h2>Изменение персонала</h2>
<form name="update"
      method="post"
      action="<%= PersonServletConstants.PERSON_UPDATE_SERVLET %>">
    <input name="<%= PersonServletConstants.PERSON_ID_PARAM %>"
           type="hidden"
           value="<%= person.getId() %>"
           required>
    <label>
        Изменить фамилию:
        <input name="<%= PersonServletConstants.PERSON_SURNAME_PARAM %>"
               type="text"
               value="<%= person.getSurname() %>"
               required>
    </label>
    <label>
        Изменить имя:
        <input name="<%= PersonServletConstants.PERSON_NAME_PARAM %>"
               type="text"
               value="<%= person.getName()%>"
               required>
    </label>
    <label>
        Изменить отчество:
        <input name="<%= PersonServletConstants.PERSON_PATRONYMIC_PARAM %>"
               type="text"
               value="<%= person.getPatronymic()%>">
    </label>
    <label>
        Изменить возраст:
        <input name="<%= PersonServletConstants.PERSON_AGE_PARAM %>"
               type="text"
               value="<%= person.getAge() %>"
               required>
    </label>
    <label>
        Арендодатель
        <input name="<%= PersonServletConstants.PERSON_IS_LANDLORD %>"
               type="checkbox"
               <%= person.getIsLandlord() ? "checked" : "" %>>

    </label>
    <br/>
    <label>
        Квартиросъемщик
        <input name="<%= PersonServletConstants.PERSON_IS_TENANT %>"
               type="checkbox"
               <%= person.getIsTenant() ? "checked" : "" %>>
    </label>
    <br/>
    <div class="button-container">
        <button class="save-button" type="submit">Сохранить</button>
        <a class="list-link-button" href="<%= PersonServletConstants.PERSONS_LIST_SERVLET %>">Вернуться к списку лиц</a>
    </div>
</form>
<p>*Данные поля заполнять необязательно</p>
</body>
</html>

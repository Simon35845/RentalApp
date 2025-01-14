<%@ page import="createdBy51mon.utils.servlet_constants.CommonServletConstants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <title>Error</title>
    <style>
        body {
            margin: 20px;
        }

        .main-link-button {
            background-color: #007BFF;
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

        .main-link-button:hover {
            opacity: 0.8;
        }
    </style>
</head>
<body>
<h2>Если вы видите эту страницу, значит произошла ошибка)</h2>
<br/>
<a class="main-link-button" href="<%= CommonServletConstants.MAIN_PAGE_SERVLET %>">Вернуться на главную</a>
</body>
</html>

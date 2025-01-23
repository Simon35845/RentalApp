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

        .error-message {
            color: red;
        }

        .error-stack {
            color: #000000;
        }
    </style>
</head>
<body>
<h2>Страница вывода ошибок</h2>
<br/>
<%
    String errorMessage = (String) request.getAttribute(CommonServletConstants.ERROR_MESSAGE_ATTRIBUTE);
    if (errorMessage != null) {
%>
<h3>Причина ошибки:</h3>
<div class="error-message">
    <h3><%= errorMessage %></h3>
    <%
        // Получаем стек-трейс
        StackTraceElement[] stackTrace = (StackTraceElement[])
                request.getAttribute(CommonServletConstants.ERROR_STACKTRACE_ATTRIBUTE);
        if (stackTrace != null) {
            out.write("<h3 class='error-stack'>Стек трассировки:</h3><pre>");
            for (StackTraceElement element : stackTrace) {
                out.write(element.toString() + "<br>");
            }
            out.write("</pre>");
        }
    %>
</div>
<%
    }
%>
<br/>
<a class="main-link-button" href="<%= CommonServletConstants.MAIN_PAGE_SERVLET %>">Вернуться на главную</a>
</body>
</html>

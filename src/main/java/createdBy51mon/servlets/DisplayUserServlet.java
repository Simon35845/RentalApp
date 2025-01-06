package createdBy51mon.servlets;

import createdBy51mon.dao.PersonDAO;
import createdBy51mon.entity.PersonEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/displayUsers")
public class DisplayUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        String searchQuery = request.getParameter("search"); //что ищем
        String sortField = request.getParameter("sort"); //по какому полю сортируем
        boolean ascending = Boolean.parseBoolean(request.getParameter("ascending")); //переменная переключения сортировки


        PersonDAO personDAO = new PersonDAO();
        List<PersonEntity> personList;

        // Условие для поиска или получения всех данных с сортировкой
        if (searchQuery != null && !searchQuery.isEmpty()) {
            personList = personDAO.search(searchQuery); // Поиск по запросу
        } else {
            personList = personDAO.getAll(sortField, ascending); // Получение всех данных с сортировкой
        }

        // Устанавливаем все необходимые атрибуты запроса
        request.setAttribute("personList", personList);
        request.getRequestDispatcher("displayUsers.jsp").forward(request, response);
    }
}
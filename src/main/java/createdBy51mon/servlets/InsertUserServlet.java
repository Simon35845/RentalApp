package createdBy51mon.servlets;

import createdBy51mon.entity.PersonEntity;
import createdBy51mon.utils.HibernateUtil;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InsertUserServlet", urlPatterns = {"/insertUser"})
public class InsertUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "POST метод не поддерживается для этого URL.");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Устанавливаем кодировку для запроса
        request.setCharacterEncoding("UTF-8");
        // Устанавливаем кодировку для ответа
        response.setContentType("text/html; charset=UTF-8");

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String patronymic = request.getParameter("patronymic");
        Integer age = Integer.parseInt(request.getParameter("age"));

        // Получаем EntityManager для работы с базой данных
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            // Создаем новый объект сущности
            PersonEntity person = new PersonEntity();
            person.setName(name);
            person.setSurname(surname);
            person.setPatronymic(patronymic);
            person.setAge(age);
            em.persist(person);
            em.getTransaction().commit();
            // Перенаправление обратно на страницу ввода данных
            response.sendRedirect("userInput.jsp");
        } catch (Exception e) {
            em.getTransaction().rollback();
            response.getWriter().println("<h1>Ошибка при сохранении данных<h1>");
            e.printStackTrace(); // Логирование ошибок
        } finally {
            em.close();
        }

    }

}

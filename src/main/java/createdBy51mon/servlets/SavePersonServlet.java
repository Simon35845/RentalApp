package createdBy51mon.servlets;

import createdBy51mon.dto.PersonDTO;
import createdBy51mon.service.PersonService;
import createdBy51mon.service.impl.PersonServiceImpl;
import createdBy51mon.utils.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "savePersonServlet", value = "/save")
public class SavePersonServlet extends HttpServlet {
    private final PersonService personService = new PersonServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EncodingUtil.setUTF8(req, resp);

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher(ServletConstants.PERSONS_SAVE_JSP);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EncodingUtil.setUTF8(req, resp);

        personService.save(MappingUtil.mapPerson(req));
        resp.sendRedirect(ServletConstants.PERSONS_LIST_SERVLET);
    }

    @Override
    public void destroy() {
        this.personService.close();
        HibernateUtil.close();
        super.destroy();
    }
}

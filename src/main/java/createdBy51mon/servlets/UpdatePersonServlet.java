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

@WebServlet(name = "updatePersonServlet", value = "/update")
public class UpdatePersonServlet extends HttpServlet {
    private final PersonService personService = new PersonServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EncodingUtil.setUTF8(req, resp);

        Integer id = ServletUtil.getIntegerParam(req, ServletConstants.PERSON_ID_PARAM);
        if (id == null) {
            resp.sendRedirect(req.getContextPath() + ServletConstants.ERROR_JSP);
            return;
        }

        PersonDTO personDTO = personService.get(id);
        req.setAttribute(ServletConstants.PERSON_ATTRIBUTE, personDTO);

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher(ServletConstants.PERSONS_UPDATE_JSP);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EncodingUtil.setUTF8(req, resp);

        personService.update(
                ServletUtil.getIntegerParam(req, ServletConstants.PERSON_ID_PARAM),
                MappingUtil.mapPerson(req));

        resp.sendRedirect(ServletConstants.PERSONS_LIST_SERVLET);
    }

    @Override
    public void destroy() {
        this.personService.close();
        HibernateUtil.close();
        super.destroy();
    }
}

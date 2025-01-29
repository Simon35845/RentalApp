package createdBy51mon.servlets.person;

import createdBy51mon.dto.PersonDTO;
import createdBy51mon.exception.DuplicateExistingEntryException;
import createdBy51mon.service.PersonService;
import createdBy51mon.service.impl.PersonServiceImpl;
import createdBy51mon.utils.EncodingUtil;
import createdBy51mon.utils.HibernateUtil;
import createdBy51mon.utils.MappingUtil;
import createdBy51mon.utils.servlet_constants.CommonServletConstants;
import createdBy51mon.utils.servlet_constants.PersonServletConstants;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "savePersonServlet", value = "/person_save")
public class SavePersonServlet extends HttpServlet {
    private final PersonService<PersonDTO> personService = new PersonServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EncodingUtil.setUTF8(req, resp);

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher(PersonServletConstants.PERSON_SAVE_JSP);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EncodingUtil.setUTF8(req, resp);

        try {
            this.personService.save(MappingUtil.mapPerson(req));
            resp.sendRedirect(PersonServletConstants.PERSONS_LIST_SERVLET);
        } catch (DuplicateExistingEntryException e) {
            req.setAttribute(CommonServletConstants.ERROR_MESSAGE_ATTRIBUTE, e.getMessage());
            req.getRequestDispatcher(CommonServletConstants.ERROR_JSP).forward(req, resp);
        }
    }

    @Override
    public void destroy() {
        this.personService.closeDao();
        HibernateUtil.close();
        super.destroy();
    }
}
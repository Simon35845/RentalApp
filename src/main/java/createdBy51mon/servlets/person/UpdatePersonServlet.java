package createdBy51mon.servlets.person;

import createdBy51mon.dto.PersonDTO;
import createdBy51mon.service.CommonService;
import createdBy51mon.service.impl.PersonServiceImpl;
import createdBy51mon.utils.*;
import createdBy51mon.utils.servlet_constants.CommonServletConstants;
import createdBy51mon.utils.servlet_constants.PersonServletConstants;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updatePersonServlet", value = "/person_update")
public class UpdatePersonServlet extends HttpServlet {
    private final CommonService<PersonDTO> personService = new PersonServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EncodingUtil.setUTF8(req, resp);

        Integer id = ServletParamUtil.getIntegerParam(req, CommonServletConstants.ID_PARAM);
        if (id == null) {
            resp.sendRedirect(CommonServletConstants.ERROR_JSP);
            return;
        }

        PersonDTO personDTO = this.personService.get(id);
        req.setAttribute(PersonServletConstants.PERSON_ATTRIBUTE, personDTO);

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher(PersonServletConstants.PERSONS_UPDATE_JSP);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EncodingUtil.setUTF8(req, resp);

        this.personService.update(
                ServletParamUtil.getIntegerParam(req, CommonServletConstants.ID_PARAM),
                MappingUtil.mapPerson(req));

        resp.sendRedirect(PersonServletConstants.PERSONS_LIST_SERVLET);
    }

    @Override
    public void destroy() {
        this.personService.closeDao();
        HibernateUtil.close();
        super.destroy();
    }
}

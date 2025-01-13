package createdBy51mon.servlets;

import createdBy51mon.dto.PersonDTO;
import createdBy51mon.service.CommonService;
import createdBy51mon.service.impl.PersonServiceImpl;
import createdBy51mon.utils.*;
import createdBy51mon.utils.ServletConstants.PersonServletConstants;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "savePersonServlet", value = "/person_save")
public class SavePersonServlet extends HttpServlet {
    private final CommonService<PersonDTO> personService = new PersonServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EncodingUtil.setUTF8(req, resp);

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher(PersonServletConstants.PERSONS_SAVE_JSP);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EncodingUtil.setUTF8(req, resp);

        this.personService.save(MappingUtil.mapPerson(req));
        resp.sendRedirect(PersonServletConstants.PERSONS_LIST_SERVLET);
    }

    @Override
    public void destroy() {
        this.personService.closeDao();
        HibernateUtil.close();
        super.destroy();
    }
}

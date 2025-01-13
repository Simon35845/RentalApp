package createdBy51mon.servlets.person;

import createdBy51mon.dto.PersonDTO;
import createdBy51mon.service.CommonService;
import createdBy51mon.service.impl.PersonServiceImpl;
import createdBy51mon.utils.EncodingUtil;
import createdBy51mon.utils.HibernateUtil;
import createdBy51mon.utils.servlet_constants.PersonServletConstants;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "listOfPersonsServlet", value = "/persons_list")
public class ListOfPersonsServlet extends HttpServlet {
    private final CommonService<PersonDTO> personService = new PersonServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final List<PersonDTO> personDTOList = this.personService.getAll();
        EncodingUtil.setUTF8(req, resp);

        req.setAttribute(PersonServletConstants.PERSONS_LIST_ATTRIBUTE, personDTOList);
        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher(PersonServletConstants.PERSONS_LIST_JSP);
        requestDispatcher.forward(req, resp);
    }


    @Override
    public void destroy() {
        this.personService.closeDao();
        HibernateUtil.close();
        super.destroy();
    }
}

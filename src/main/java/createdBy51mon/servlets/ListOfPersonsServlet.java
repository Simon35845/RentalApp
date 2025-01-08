package createdBy51mon.servlets;

import createdBy51mon.dto.PersonDTO;
import createdBy51mon.service.PersonService;
import createdBy51mon.service.impl.PersonServiceImpl;
import createdBy51mon.utils.EncodingUtil;
import createdBy51mon.utils.HibernateUtil;
import createdBy51mon.utils.ServletConstants;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "listOfPersonsServlet", value = "/persons_manager")
public class ListOfPersonsServlet extends HttpServlet {
    private final PersonService personService = new PersonServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        EncodingUtil.setUTF8(req, resp);
        final List<PersonDTO> personDTOList = this.personService.getAll();

        req.setAttribute(ServletConstants.PERSONS_LIST_ATTRIBUTE, personDTOList);
        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher(ServletConstants.PERSONS_LIST_JSP);
        requestDispatcher.forward(req, resp);
    }


    @Override
    public void destroy() {
        this.personService.close();
        HibernateUtil.close();
        super.destroy();
    }
}

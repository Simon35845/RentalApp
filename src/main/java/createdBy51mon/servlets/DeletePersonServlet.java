package createdBy51mon.servlets;

import createdBy51mon.service.CommonService;
import createdBy51mon.service.impl.PersonServiceImpl;
import createdBy51mon.utils.EncodingUtil;
import createdBy51mon.utils.HibernateUtil;
import createdBy51mon.utils.ServletConstants;
import createdBy51mon.utils.ServletParamUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deletePersonServlet", value = "/delete")
public class DeletePersonServlet extends HttpServlet {
    private final CommonService personService = new PersonServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EncodingUtil.setUTF8(req, resp);

        this.personService.delete(
                ServletParamUtil.getIntegerParam(req, ServletConstants.PERSON_ID_PARAM));
        resp.sendRedirect(ServletConstants.PERSONS_LIST_SERVLET);
    }

    @Override
    public void destroy() {
        this.personService.closeDao();
        HibernateUtil.close();
        super.destroy();
    }
}

package createdBy51mon.servlets.landlord;

import createdBy51mon.service.LandlordService;
import createdBy51mon.service.PersonService;
import createdBy51mon.service.impl.LandlordServiceImpl;
import createdBy51mon.service.impl.PersonServiceImpl;
import createdBy51mon.utils.EncodingUtil;
import createdBy51mon.utils.HibernateUtil;
import createdBy51mon.utils.ParsingUtil;
import createdBy51mon.utils.servlet_constants.LandlordServletConstants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteLandlordServlet", value = "/landlord_delete")
public class DeleteLandlordServlet extends HttpServlet {
    private final LandlordService landlordService = new LandlordServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EncodingUtil.setUTF8(req, resp);

        this.landlordService.delete(
                ParsingUtil.getIntegerParam(req, LandlordServletConstants.LANDLORD_ID_PARAM));
        resp.sendRedirect(LandlordServletConstants.LANDLORDS_LIST_SERVLET);
    }

    @Override
    public void destroy() {
        this.landlordService.closeDao();
        HibernateUtil.close();
        super.destroy();
    }
}

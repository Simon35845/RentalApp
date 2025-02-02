package createdBy51mon.servlets.landlord;

import createdBy51mon.service.LandlordService;
import createdBy51mon.service.impl.LandlordServiceImpl;
import createdBy51mon.utils.EncodingUtil;
import createdBy51mon.utils.HibernateUtil;
import createdBy51mon.utils.MappingUtil;
import createdBy51mon.utils.servlet_constants.LandlordServletConstants;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "saveLandlordServlet", value = "/landlord_save")
public class SaveLandlordServlet extends HttpServlet {
    private final LandlordService landlordService = new LandlordServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EncodingUtil.setUTF8(req, resp);

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher(LandlordServletConstants.LANDLORD_SAVE_JSP);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EncodingUtil.setUTF8(req, resp);

        this.landlordService.save(MappingUtil.mapLandlord(req));
        resp.sendRedirect(LandlordServletConstants.LANDLORDS_LIST_SERVLET);
    }

    @Override
    public void destroy() {
        this.landlordService.closeDao();
        HibernateUtil.close();
        super.destroy();
    }
}
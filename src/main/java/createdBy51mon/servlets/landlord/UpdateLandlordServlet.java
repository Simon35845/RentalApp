package createdBy51mon.servlets.landlord;

import createdBy51mon.dto.LandlordDTO;
import createdBy51mon.service.LandlordService;
import createdBy51mon.service.impl.LandlordServiceImpl;
import createdBy51mon.utils.EncodingUtil;
import createdBy51mon.utils.HibernateUtil;
import createdBy51mon.utils.MappingUtil;
import createdBy51mon.utils.ParsingUtil;
import createdBy51mon.utils.servlet_constants.CommonServletConstants;
import createdBy51mon.utils.servlet_constants.LandlordServletConstants;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updateLandlordServlet", value = "/landlord_update")
public class UpdateLandlordServlet extends HttpServlet {
    private final LandlordService landlordService = new LandlordServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EncodingUtil.setUTF8(req, resp);

        Integer id = ParsingUtil.getIntegerParam(req, LandlordServletConstants.LANDLORD_ID_PARAM);
        if (id == null) {
            resp.sendRedirect(CommonServletConstants.ERROR_JSP);
            return;
        }

        LandlordDTO landlordDTO = this.landlordService.get(id);
        req.setAttribute(LandlordServletConstants.LANDLORD_ATTRIBUTE, landlordDTO);

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher(LandlordServletConstants.LANDLORDS_UPDATE_JSP);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EncodingUtil.setUTF8(req, resp);

        this.landlordService.update(
                ParsingUtil.getIntegerParam(req, LandlordServletConstants.LANDLORD_ID_PARAM),
                MappingUtil.mapLandlord(req));

        resp.sendRedirect(LandlordServletConstants.LANDLORDS_LIST_SERVLET);
    }

    @Override
    public void destroy() {
        this.landlordService.closeDao();
        HibernateUtil.close();
        super.destroy();
    }
}
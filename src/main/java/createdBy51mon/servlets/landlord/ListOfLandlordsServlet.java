package createdBy51mon.servlets.landlord;

import createdBy51mon.dto.LandlordDTO;
import createdBy51mon.service.LandlordService;
import createdBy51mon.service.impl.LandlordServiceImpl;
import createdBy51mon.utils.EncodingUtil;
import createdBy51mon.utils.HibernateUtil;
import createdBy51mon.utils.servlet_constants.LandlordServletConstants;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "listOfLandlordsServlet", value = "/landlords_list")
public class ListOfLandlordsServlet extends HttpServlet {
    private final LandlordService landlordService = new LandlordServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final List<LandlordDTO> landlords = this.landlordService.getAll();
        EncodingUtil.setUTF8(req, resp);

        req.setAttribute(LandlordServletConstants.LANDLORDS_LIST_ATTRIBUTE, landlords);
        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher(LandlordServletConstants.LANDLORDS_LIST_JSP);
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void destroy() {
        this.landlordService.closeDao();
        HibernateUtil.close();
        super.destroy();
    }
}

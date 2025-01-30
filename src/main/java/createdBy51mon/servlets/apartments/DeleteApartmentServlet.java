package createdBy51mon.servlets.apartments;

import createdBy51mon.dto.ApartmentDTO;
import createdBy51mon.service.ApartmentService;
import createdBy51mon.service.impl.ApartmentServiceImpl;
import createdBy51mon.utils.EncodingUtil;
import createdBy51mon.utils.HibernateUtil;
import createdBy51mon.utils.ParsingUtil;
import createdBy51mon.utils.servlet_constants.ApartmentServletConstants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteApartmentServlet", value = "/apartment_delete")
public class DeleteApartmentServlet extends HttpServlet {
    private final ApartmentService<ApartmentDTO> apartmentService = new ApartmentServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EncodingUtil.setUTF8(req, resp);

        this.apartmentService.delete(
                ParsingUtil.getIntegerParam(req, ApartmentServletConstants.APARTMENT_ID_PARAM));
        resp.sendRedirect(ApartmentServletConstants.APARTMENTS_LIST_SERVLET);
    }

    @Override
    public void destroy() {
        this.apartmentService.closeDao();
        HibernateUtil.close();
        super.destroy();
    }
}

package createdBy51mon.servlets.apartments;

import createdBy51mon.dto.AddressDTO;
import createdBy51mon.dto.ApartmentDTO;
import createdBy51mon.service.CommonService;
import createdBy51mon.service.impl.AddressServiceImpl;
import createdBy51mon.service.impl.ApartmentServiceImpl;
import createdBy51mon.utils.EncodingUtil;
import createdBy51mon.utils.HibernateUtil;
import createdBy51mon.utils.ServletParamUtil;
import createdBy51mon.utils.servlet_constants.ApartmentServletConstants;
import createdBy51mon.utils.servlet_constants.CommonServletConstants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteApartmentServlet", value = "/apartment_delete")
public class DeleteApartmentServlet extends HttpServlet {
    private final CommonService<ApartmentDTO> apartmentService = new ApartmentServiceImpl();
    private final CommonService<AddressDTO> addressService = new AddressServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EncodingUtil.setUTF8(req, resp);

        Integer apartmentId = ServletParamUtil.getIntegerParam(req, CommonServletConstants.ID_PARAM);
        if (apartmentId == null) {
            resp.sendRedirect(CommonServletConstants.ERROR_JSP);
            return;
        }

        this.apartmentService.delete(
                ServletParamUtil.getIntegerParam(req, CommonServletConstants.ID_PARAM));
        resp.sendRedirect(ApartmentServletConstants.APARTMENTS_LIST_SERVLET);
    }

    @Override
    public void destroy() {
        this.apartmentService.closeDao();
        this.apartmentService.closeDao();
        HibernateUtil.close();
        super.destroy();
    }
}

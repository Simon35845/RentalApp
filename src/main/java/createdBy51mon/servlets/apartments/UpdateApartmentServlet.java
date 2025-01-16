package createdBy51mon.servlets.apartments;

import createdBy51mon.dto.AddressDTO;
import createdBy51mon.dto.ApartmentDTO;
import createdBy51mon.service.CommonService;
import createdBy51mon.service.impl.AddressServiceImpl;
import createdBy51mon.service.impl.ApartmentServiceImpl;
import createdBy51mon.utils.EncodingUtil;
import createdBy51mon.utils.HibernateUtil;
import createdBy51mon.utils.MappingUtil;
import createdBy51mon.utils.ServletParamUtil;
import createdBy51mon.utils.servlet_constants.ApartmentServletConstants;
import createdBy51mon.utils.servlet_constants.CommonServletConstants;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updateApartmentServlet", value = "/apartment_update")
public class UpdateApartmentServlet extends HttpServlet {
    private final CommonService<ApartmentDTO> apartmentService = new ApartmentServiceImpl();
    private final CommonService<AddressDTO> addressService = new AddressServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EncodingUtil.setUTF8(req, resp);

        Integer apartmentId = ServletParamUtil.getIntegerParam(req, CommonServletConstants.ID_PARAM);
        if (apartmentId == null) {
            resp.sendRedirect(CommonServletConstants.ERROR_JSP);
            return;
        }

        ApartmentDTO apartmentDTO = this.apartmentService.get(apartmentId);
        req.setAttribute(ApartmentServletConstants.APARTMENT_ATTRIBUTE, apartmentDTO);

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher(ApartmentServletConstants.APARTMENT_UPDATE_JSP);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EncodingUtil.setUTF8(req, resp);

        Integer apartmentId = ServletParamUtil.getIntegerParam(req, CommonServletConstants.ID_PARAM);
        if (apartmentId == null) {
            resp.sendRedirect(CommonServletConstants.ERROR_JSP);
            return;
        }

        this.addressService.update(
                ServletParamUtil.getIntegerParam(req, CommonServletConstants.ID_PARAM),
                MappingUtil.mapAddress(req));

        this.apartmentService.update(
                ServletParamUtil.getIntegerParam(req, CommonServletConstants.ID_PARAM),
                MappingUtil.mapApartment(req));

        resp.sendRedirect(ApartmentServletConstants.APARTMENTS_LIST_SERVLET);
    }

    @Override
    public void destroy() {
        this.addressService.closeDao();
        this.apartmentService.closeDao();
        HibernateUtil.close();
        super.destroy();
    }
}

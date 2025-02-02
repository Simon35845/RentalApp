package createdBy51mon.servlets.apartments;

import createdBy51mon.dto.AddressDTO;
import createdBy51mon.dto.ApartmentDTO;
import createdBy51mon.service.ApartmentService;
import createdBy51mon.service.impl.ApartmentServiceImpl;
import createdBy51mon.utils.EncodingUtil;
import createdBy51mon.utils.HibernateUtil;
import createdBy51mon.utils.MappingUtil;
import createdBy51mon.utils.ParsingUtil;
import createdBy51mon.utils.servlet_constants.AddressServletConstants;
import createdBy51mon.utils.servlet_constants.ApartmentServletConstants;
import createdBy51mon.utils.servlet_constants.CommonServletConstants;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "updateApartmentServlet", value = "/apartment_update")
public class UpdateApartmentServlet extends HttpServlet {
    private final ApartmentService apartmentService = new ApartmentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EncodingUtil.setUTF8(req, resp);

        Integer id = ParsingUtil.getIntegerParam(req, ApartmentServletConstants.APARTMENT_ID_PARAM);
        if (id == null) {
            resp.sendRedirect(CommonServletConstants.ERROR_JSP);
            return;
        }

        List<AddressDTO> addresses = apartmentService.getAddresses();
        req.setAttribute(AddressServletConstants.ADDRESSES_LIST_ATTRIBUTE, addresses);

        ApartmentDTO apartmentDTO = this.apartmentService.get(id);
        req.setAttribute(ApartmentServletConstants.APARTMENT_ATTRIBUTE, apartmentDTO);

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher(ApartmentServletConstants.APARTMENT_UPDATE_JSP);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EncodingUtil.setUTF8(req, resp);

        this.apartmentService.update(
                ParsingUtil.getIntegerParam(req, ApartmentServletConstants.APARTMENT_ID_PARAM),
                MappingUtil.mapApartment(req));

        resp.sendRedirect(ApartmentServletConstants.APARTMENTS_LIST_SERVLET);
    }

    @Override
    public void destroy() {
        this.apartmentService.closeDao();
        HibernateUtil.close();
        super.destroy();
    }
}
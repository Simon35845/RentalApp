package createdBy51mon.servlets.apartments;

import createdBy51mon.dto.AddressDTO;
import createdBy51mon.dto.ApartmentDTO;
import createdBy51mon.service.AddressService;
import createdBy51mon.service.impl.AddressServiceImpl;
import createdBy51mon.utils.EncodingUtil;
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

@WebServlet(name = "apartmentsForAddressServlet", value = "/apartments_for_address")
public class ApartmentsForAddressServlet extends HttpServlet {
    private final AddressService addressService = new AddressServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EncodingUtil.setUTF8(req, resp);
        Integer addressId = ParsingUtil.getIntegerParam(req, AddressServletConstants.ADDRESS_ID_PARAM);
        if (addressId == null) {
            resp.sendRedirect(CommonServletConstants.ERROR_JSP);
            return;
        }

        AddressDTO address = addressService.get(addressId);
        final List<ApartmentDTO> apartments = this.addressService.getApartmentsByAddress(addressId);

        req.setAttribute(ApartmentServletConstants.APARTMENT_LIST_ATTRIBUTE, apartments);
        req.setAttribute(AddressServletConstants.ADDRESS_ATTRIBUTE, address);

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher(ApartmentServletConstants.APARTMENTS_FOR_ADDRESS_JSP);
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void destroy() {
        this.addressService.closeDao();
        super.destroy();
    }
}

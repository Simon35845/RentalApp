package createdBy51mon.servlets.apartments;

import createdBy51mon.dto.AddressDTO;
import createdBy51mon.dto.ApartmentDTO;
import createdBy51mon.service.AddressService;
import createdBy51mon.service.ApartmentService;
import createdBy51mon.service.impl.AddressServiceImpl;
import createdBy51mon.service.impl.ApartmentServiceImpl;
import createdBy51mon.utils.EncodingUtil;
import createdBy51mon.utils.HibernateUtil;
import createdBy51mon.utils.MappingUtil;
import createdBy51mon.utils.ServletParamUtil;
import createdBy51mon.utils.servlet_constants.AddressServletConstants;
import createdBy51mon.utils.servlet_constants.ApartmentServletConstants;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "saveApartmentServlet", value = "/apartment_save")
public class SaveApartmentServlet extends HttpServlet {
    private final ApartmentService<ApartmentDTO> apartmentService = new ApartmentServiceImpl();
    private final AddressService<AddressDTO> addressService = new AddressServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EncodingUtil.setUTF8(req, resp);
        List<AddressDTO> addresses = this.addressService.getAll();
        req.setAttribute(AddressServletConstants.ADDRESSES_LIST_ATTRIBUTE, addresses);

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher(ApartmentServletConstants.APARTMENT_SAVE_JSP);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EncodingUtil.setUTF8(req, resp);

        Integer addressId = ServletParamUtil.getIntegerParam(req, AddressServletConstants.ADDRESS_ID_PARAM);
        ApartmentDTO apartmentDTO = MappingUtil.mapApartment(req);

        if (addressId != null) {
            AddressDTO addressDTO = addressService.get(addressId);
            apartmentDTO.setAddress(addressDTO);
        }

        this.apartmentService.save(apartmentDTO);
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
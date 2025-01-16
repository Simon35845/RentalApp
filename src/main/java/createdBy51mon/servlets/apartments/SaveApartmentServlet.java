package createdBy51mon.servlets.apartments;

import createdBy51mon.dto.AddressDTO;
import createdBy51mon.dto.ApartmentDTO;
import createdBy51mon.service.CommonService;
import createdBy51mon.service.impl.AddressServiceImpl;
import createdBy51mon.service.impl.ApartmentServiceImpl;
import createdBy51mon.utils.EncodingUtil;
import createdBy51mon.utils.HibernateUtil;
import createdBy51mon.utils.MappingUtil;
import createdBy51mon.utils.servlet_constants.ApartmentServletConstants;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "saveApartmentServlet", value = "/apartment_save")
public class SaveApartmentServlet extends HttpServlet {
    private final CommonService<ApartmentDTO> apartmentService = new ApartmentServiceImpl();
    private final CommonService<AddressDTO> addressService = new AddressServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EncodingUtil.setUTF8(req, resp);

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher(ApartmentServletConstants.APARTMENT_SAVE_JSP);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EncodingUtil.setUTF8(req, resp);

        this.addressService.save(MappingUtil.mapAddress(req));
        this.apartmentService.save(MappingUtil.mapApartment(req));
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
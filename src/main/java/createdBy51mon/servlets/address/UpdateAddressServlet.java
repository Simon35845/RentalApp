package createdBy51mon.servlets.address;

import createdBy51mon.dto.AddressDTO;
import createdBy51mon.service.AddressService;
import createdBy51mon.service.impl.AddressServiceImpl;
import createdBy51mon.utils.EncodingUtil;
import createdBy51mon.utils.HibernateUtil;
import createdBy51mon.utils.MappingUtil;
import createdBy51mon.utils.ParsingUtil;
import createdBy51mon.utils.servlet_constants.AddressServletConstants;
import createdBy51mon.utils.servlet_constants.CommonServletConstants;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updateAddressServlet", value = "/address_update")
public class UpdateAddressServlet extends HttpServlet {
    private final AddressService addressService = new AddressServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EncodingUtil.setUTF8(req, resp);

        Integer id = ParsingUtil.getIntegerParam(req, AddressServletConstants.ADDRESS_ID_PARAM);
        if (id == null) {
            resp.sendRedirect(CommonServletConstants.ERROR_JSP);
            return;
        }

        AddressDTO addressDTO = this.addressService.get(id);
        req.setAttribute(AddressServletConstants.ADDRESS_ATTRIBUTE, addressDTO);

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher(AddressServletConstants.ADDRESS_UPDATE_JSP);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EncodingUtil.setUTF8(req, resp);

        this.addressService.update(
                ParsingUtil.getIntegerParam(req, AddressServletConstants.ADDRESS_ID_PARAM),
                MappingUtil.mapAddress(req));

        resp.sendRedirect(AddressServletConstants.ADDRESSES_LIST_SERVLET);
    }

    @Override
    public void destroy() {
        this.addressService.closeDao();
        HibernateUtil.close();
        super.destroy();
    }
}
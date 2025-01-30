package createdBy51mon.servlets.address;

import createdBy51mon.dto.AddressDTO;
import createdBy51mon.service.AddressService;
import createdBy51mon.service.impl.AddressServiceImpl;
import createdBy51mon.utils.EncodingUtil;
import createdBy51mon.utils.HibernateUtil;
import createdBy51mon.utils.ParsingUtil;
import createdBy51mon.utils.servlet_constants.AddressServletConstants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteAddressServlet", value = "/address_delete")
public class DeleteAddressServlet extends HttpServlet {
    private final AddressService<AddressDTO> addressService = new AddressServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EncodingUtil.setUTF8(req, resp);

        this.addressService.delete(
                ParsingUtil.getIntegerParam(req, AddressServletConstants.ADDRESS_ID_PARAM));
        resp.sendRedirect(AddressServletConstants.ADDRESSES_LIST_SERVLET);
    }

    @Override
    public void destroy() {
        this.addressService.closeDao();
        HibernateUtil.close();
        super.destroy();
    }
}

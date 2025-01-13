package createdBy51mon.servlets.address;

import createdBy51mon.dto.AddressDTO;
import createdBy51mon.service.CommonService;
import createdBy51mon.service.impl.AddressServiceImpl;
import createdBy51mon.utils.EncodingUtil;
import createdBy51mon.utils.HibernateUtil;
import createdBy51mon.utils.servlet_constants.AddressServletConstants;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "listOfAddressesServlet", value = "/addresses_list")
public class ListOfAddressesServlet extends HttpServlet {
    private final CommonService<AddressDTO> addressService = new AddressServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final List<AddressDTO> addressDTOList = this.addressService.getAll();
        EncodingUtil.setUTF8(req, resp);

        req.setAttribute(AddressServletConstants.ADDRESSES_LIST_ATTRIBUTE, addressDTOList);
        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher(AddressServletConstants.ADDRESSES_LIST_JSP);
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void destroy() {
        this.addressService.closeDao();
        HibernateUtil.close();
        super.destroy();
    }
}
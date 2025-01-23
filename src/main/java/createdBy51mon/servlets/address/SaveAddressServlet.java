package createdBy51mon.servlets.address;

import createdBy51mon.dto.AddressDTO;
import createdBy51mon.exception.DuplicateExistingEntryException;
import createdBy51mon.service.CommonService;
import createdBy51mon.service.impl.AddressServiceImpl;
import createdBy51mon.utils.EncodingUtil;
import createdBy51mon.utils.HibernateUtil;
import createdBy51mon.utils.MappingUtil;
import createdBy51mon.utils.servlet_constants.AddressServletConstants;
import createdBy51mon.utils.servlet_constants.CommonServletConstants;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "saveAddressServlet", value = "/address_save")
public class SaveAddressServlet extends HttpServlet {
    private final CommonService<AddressDTO> addressService = new AddressServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EncodingUtil.setUTF8(req, resp);

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher(AddressServletConstants.ADDRESS_SAVE_JSP);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EncodingUtil.setUTF8(req, resp);

        try {
            this.addressService.save(MappingUtil.mapAddress(req));
            resp.sendRedirect(AddressServletConstants.ADDRESSES_LIST_SERVLET);
        } catch (DuplicateExistingEntryException e) {
            req.setAttribute(CommonServletConstants.ERROR_MESSAGE_ATTRIBUTE, e.getMessage());
            req.setAttribute(CommonServletConstants.ERROR_STACKTRACE_ATTRIBUTE, e.getStackTrace());
            req.getRequestDispatcher(CommonServletConstants.ERROR_JSP).forward(req, resp);
        } catch (Exception e) {
            req.setAttribute(CommonServletConstants.ERROR_MESSAGE_ATTRIBUTE, "Произошла ошибка при добавлении записи.");
            req.setAttribute(CommonServletConstants.ERROR_STACKTRACE_ATTRIBUTE, e.getStackTrace()); // Сохраняем стек-трейс
            RequestDispatcher dispatcher = req.getRequestDispatcher("error.jsp");
            dispatcher.forward(req, resp);
        }
    }

    @Override
    public void destroy() {
        this.addressService.closeDao();
        HibernateUtil.close();
        super.destroy();
    }
}
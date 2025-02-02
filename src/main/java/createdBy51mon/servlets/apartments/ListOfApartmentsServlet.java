package createdBy51mon.servlets.apartments;

import createdBy51mon.dto.ApartmentDTO;
import createdBy51mon.service.ApartmentService;
import createdBy51mon.service.impl.ApartmentServiceImpl;
import createdBy51mon.utils.EncodingUtil;
import createdBy51mon.utils.HibernateUtil;
import createdBy51mon.utils.servlet_constants.ApartmentServletConstants;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "listOfApartmentsServlet", value = "/apartments_list")
public class ListOfApartmentsServlet extends HttpServlet {
    private final ApartmentService apartmentService = new ApartmentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final List<ApartmentDTO> apartments = this.apartmentService.getAll();
        EncodingUtil.setUTF8(req, resp);

        req.setAttribute(ApartmentServletConstants.APARTMENT_LIST_ATTRIBUTE, apartments);
        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher(ApartmentServletConstants.APARTMENTS_LIST_JSP);
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void destroy() {
        this.apartmentService.closeDao();
        HibernateUtil.close();
        super.destroy();
    }
}

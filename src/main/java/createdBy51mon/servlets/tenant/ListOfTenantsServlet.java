package createdBy51mon.servlets.tenant;

import createdBy51mon.dto.TenantDTO;
import createdBy51mon.service.TenantService;
import createdBy51mon.service.impl.TenantServiceImpl;
import createdBy51mon.utils.EncodingUtil;
import createdBy51mon.utils.HibernateUtil;
import createdBy51mon.utils.servlet_constants.TenantServletConstants;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "listOfTenantsServlet", value = "/tenants_list")
public class ListOfTenantsServlet extends HttpServlet {
    private final TenantService tenantService = new TenantServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final List<TenantDTO> tenants = this.tenantService.getAll();
        EncodingUtil.setUTF8(req, resp);

        req.setAttribute(TenantServletConstants.TENANTS_LIST_ATTRIBUTE, tenants);
        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher(TenantServletConstants.TENANTS_LIST_JSP);
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void destroy() {
        this.tenantService.closeDao();
        HibernateUtil.close();
        super.destroy();
    }
}

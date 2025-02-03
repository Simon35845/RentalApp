package createdBy51mon.servlets.tenant;

import createdBy51mon.dto.TenantDTO;
import createdBy51mon.service.TenantService;
import createdBy51mon.service.impl.TenantServiceImpl;
import createdBy51mon.utils.EncodingUtil;
import createdBy51mon.utils.HibernateUtil;
import createdBy51mon.utils.MappingUtil;
import createdBy51mon.utils.ParsingUtil;
import createdBy51mon.utils.servlet_constants.CommonServletConstants;
import createdBy51mon.utils.servlet_constants.TenantServletConstants;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updateTenantServlet", value = "/tenant_update")
public class UpdateTenantServlet extends HttpServlet {
    private final TenantService tenantService = new TenantServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EncodingUtil.setUTF8(req, resp);

        Integer id = ParsingUtil.getIntegerParam(req, TenantServletConstants.TENANT_ID_PARAM);
        if (id == null) {
            resp.sendRedirect(CommonServletConstants.ERROR_JSP);
            return;
        }

        TenantDTO tenantDTO = this.tenantService.get(id);
        req.setAttribute(TenantServletConstants.TENANT_ATTRIBUTE, tenantDTO);

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher(TenantServletConstants.TENANTS_UPDATE_JSP);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EncodingUtil.setUTF8(req, resp);

        this.tenantService.update(
                ParsingUtil.getIntegerParam(req, TenantServletConstants.TENANT_ID_PARAM),
                MappingUtil.mapTenant(req));

        resp.sendRedirect(TenantServletConstants.TENANTS_LIST_SERVLET);
    }

    @Override
    public void destroy() {
        this.tenantService.closeDao();
        HibernateUtil.close();
        super.destroy();
    }
}
package createdBy51mon.servlets.tenant;

import createdBy51mon.service.TenantService;
import createdBy51mon.service.impl.TenantServiceImpl;
import createdBy51mon.utils.EncodingUtil;
import createdBy51mon.utils.HibernateUtil;
import createdBy51mon.utils.ParsingUtil;
import createdBy51mon.utils.servlet_constants.TenantServletConstants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteTenantServlet", value = "/tenant_delete")
public class DeleteTenantServlet extends HttpServlet {
    private final TenantService tenantService = new TenantServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EncodingUtil.setUTF8(req, resp);

        this.tenantService.delete(
                ParsingUtil.getIntegerParam(req, TenantServletConstants.TENANT_ID_PARAM));
        resp.sendRedirect(TenantServletConstants.TENANTS_LIST_SERVLET);
    }

    @Override
    public void destroy() {
        this.tenantService.closeDao();
        HibernateUtil.close();
        super.destroy();
    }
}

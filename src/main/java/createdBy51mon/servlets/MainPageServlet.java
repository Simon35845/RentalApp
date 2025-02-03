package createdBy51mon.servlets;

import createdBy51mon.utils.EncodingUtil;
import createdBy51mon.utils.servlet_constants.CommonServletConstants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "mainPageServlet", value = "/main_page")
public class MainPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EncodingUtil.setUTF8(req, resp);
        req.getRequestDispatcher(CommonServletConstants.MAIN_PAGE_JSP).forward(req, resp);
    }
}

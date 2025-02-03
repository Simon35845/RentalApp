package createdBy51mon.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class EncodingUtil {
    public static void setUTF8(HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html; charset=UTF-8");
        } catch (UnsupportedEncodingException e) {
            System.out.println("Ошибка установки кодировки UTF-8");
            e.printStackTrace();
        }
    }
}

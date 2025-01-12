package createdBy51mon.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class ServletParamUtil {
    /**
     * Получает из объекта HttpServletRequest параметр по его имени
     *
     * @param req       объект HttpServletRequest
     * @param nameField имя параметра, который получаем из HttpServletRequest
     * @return представление параметра типа {@code String}
     */
    public static String getStringParam(HttpServletRequest req, String nameField) {
        return Optional.ofNullable(req.getParameter(nameField))
                .filter(StringUtils::isNotBlank)
                .orElse(null);
    }

    /**
     * Получает из объекта HttpServletRequest параметр по его имени
     *
     * @param req       объект HttpServletRequest
     * @param nameField имя параметра, который получаем из HttpServletRequest
     * @return представление параметра типа {@code Integer}
     */
    public static Integer getIntegerParam(HttpServletRequest req, String nameField) {
        return Optional.ofNullable(req.getParameter(nameField))
                .filter(StringUtils::isNotBlank)
                .map(Integer::parseInt)
                .orElse(null);
    }

    /**
     * Получает из объекта HttpServletRequest параметр по его имени
     *
     * @param req       объект HttpServletRequest
     * @param nameField имя параметра, который получаем из HttpServletRequest
     * @return представление параметра типа {@code Double}
     */
    public static Double getDoubleParam(HttpServletRequest req, String nameField) {
        return Optional.ofNullable(req.getParameter(nameField))
                .filter(StringUtils::isNotBlank)
                .map(Double::parseDouble)
                .orElse(null);
    }

    /**
     * Получает из объекта HttpServletRequest параметр по его имени
     *
     * @param req       объект HttpServletRequest
     * @param nameField имя параметра, который получаем из HttpServletRequest
     * @return представление параметра типа {@code Boolean}
     */
    public static Boolean getBooleanParam(HttpServletRequest req, String nameField) {
        return Optional.ofNullable(req.getParameter(nameField))
                .filter(StringUtils::isNotBlank)
                .map(Boolean::parseBoolean)
                .orElse(null);
    }

}

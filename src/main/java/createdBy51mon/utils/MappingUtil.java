package createdBy51mon.utils;

import createdBy51mon.dto.PersonDTO;
import createdBy51mon.utils.servlet_constants.PersonServletConstants;

import javax.servlet.http.HttpServletRequest;

public class MappingUtil {
    /**
     * Создает объект типа {@code PersonDTO}, заполняя поля значениями из параметров,
     * полученных из объекта HttpServletRequest
     * @param req объект HttpServletRequest
     * @return объект типа {@code PersonDTO}
     */
    public static PersonDTO mapPerson(HttpServletRequest req){
        return PersonDTO.builder()
                .name(ServletParamUtil.getStringParam(req, PersonServletConstants.PERSON_NAME_PARAM))
                .surname(ServletParamUtil.getStringParam(req, PersonServletConstants.PERSON_SURNAME_PARAM))
                .patronymic(ServletParamUtil.getStringParam(req, PersonServletConstants.PERSON_PATRONYMIC_PARAM))
                .age(ServletParamUtil.getIntegerParam(req, PersonServletConstants.PERSON_AGE_PARAM))
                .build();
    }
}

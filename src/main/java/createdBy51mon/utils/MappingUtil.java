package createdBy51mon.utils;

import createdBy51mon.dto.PersonDTO;

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
                .name(ServletParamUtil.getStringParam(req, ServletConstants.PERSON_NAME_PARAM))
                .surname(ServletParamUtil.getStringParam(req, ServletConstants.PERSON_SURNAME_PARAM))
                .patronymic(ServletParamUtil.getStringParam(req, ServletConstants.PERSON_PATRONYMIC_PARAM))
                .age(ServletParamUtil.getIntegerParam(req, ServletConstants.PERSON_AGE_PARAM))
                .build();
    }
}

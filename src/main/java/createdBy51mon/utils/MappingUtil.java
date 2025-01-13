package createdBy51mon.utils;

import createdBy51mon.dto.AddressDTO;
import createdBy51mon.dto.PersonDTO;
import createdBy51mon.utils.servlet_constants.AddressServletConstants;
import createdBy51mon.utils.servlet_constants.PersonServletConstants;

import javax.servlet.http.HttpServletRequest;

public class MappingUtil {
    public static AddressDTO mapAddress(HttpServletRequest req) {
        return AddressDTO.builder()
                .city(ServletParamUtil.getStringParam(req, AddressServletConstants.ADDRESS_CITY_PARAM))
                .street(ServletParamUtil.getStringParam(req, AddressServletConstants.ADDRESS_STREET_PARAM))
                .houseNumber(ServletParamUtil.getIntegerParam(req, AddressServletConstants.ADDRESS_HOUSE_NUMBER_PARAM))
                .build();
    }

    public static PersonDTO mapPerson(HttpServletRequest req) {
        return PersonDTO.builder()
                .name(ServletParamUtil.getStringParam(req, PersonServletConstants.PERSON_NAME_PARAM))
                .surname(ServletParamUtil.getStringParam(req, PersonServletConstants.PERSON_SURNAME_PARAM))
                .patronymic(ServletParamUtil.getStringParam(req, PersonServletConstants.PERSON_PATRONYMIC_PARAM))
                .age(ServletParamUtil.getIntegerParam(req, PersonServletConstants.PERSON_AGE_PARAM))
                .build();
    }
}

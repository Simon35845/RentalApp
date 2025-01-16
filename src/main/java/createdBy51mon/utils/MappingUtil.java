package createdBy51mon.utils;

import createdBy51mon.dto.AddressDTO;
import createdBy51mon.dto.ApartmentDTO;
import createdBy51mon.dto.PersonDTO;
import createdBy51mon.utils.servlet_constants.ApartmentServletConstants;
import createdBy51mon.utils.servlet_constants.CommonServletConstants;
import createdBy51mon.utils.servlet_constants.PersonServletConstants;

import javax.servlet.http.HttpServletRequest;

public class MappingUtil {
    public static AddressDTO mapAddress(HttpServletRequest req) {
        return AddressDTO.builder()
                .id(ServletParamUtil.getIntegerParam(req, CommonServletConstants.ID_PARAM))
                .city(ServletParamUtil.getStringParam(req, ApartmentServletConstants.ADDRESS_CITY_PARAM))
                .street(ServletParamUtil.getStringParam(req, ApartmentServletConstants.ADDRESS_STREET_PARAM))
                .houseNumber(ServletParamUtil.getIntegerParam(req, ApartmentServletConstants.ADDRESS_HOUSE_NUMBER_PARAM))
                .build();
    }

    public static ApartmentDTO mapApartment(HttpServletRequest req) {
        return ApartmentDTO.builder()
                .number(ServletParamUtil.getIntegerParam(req, ApartmentServletConstants.APARTMENT_NUMBER_PARAM))
                .floor(ServletParamUtil.getIntegerParam(req, ApartmentServletConstants.APARTMENT_FLOOR_PARAM))
                .countOfRooms(ServletParamUtil.getIntegerParam(req, ApartmentServletConstants.APARTMENT_COUNT_OF_ROOMS_PARAM))
                .totalSquare(ServletParamUtil.getDoubleParam(req, ApartmentServletConstants.APARTMENT_TOTAL_SQUARE_PARAM))
                .address(mapAddress(req))
                .build();
    }

    public static PersonDTO mapPerson(HttpServletRequest req) {
        return PersonDTO.builder()
                .id(ServletParamUtil.getIntegerParam(req, CommonServletConstants.ID_PARAM))
                .name(ServletParamUtil.getStringParam(req, PersonServletConstants.PERSON_NAME_PARAM))
                .surname(ServletParamUtil.getStringParam(req, PersonServletConstants.PERSON_SURNAME_PARAM))
                .patronymic(ServletParamUtil.getStringParam(req, PersonServletConstants.PERSON_PATRONYMIC_PARAM))
                .age(ServletParamUtil.getIntegerParam(req, PersonServletConstants.PERSON_AGE_PARAM))
                .build();
    }
}

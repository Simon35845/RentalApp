package createdBy51mon.utils;

import createdBy51mon.dto.AddressDTO;
import createdBy51mon.dto.ApartmentDTO;
import createdBy51mon.dto.PersonDTO;
import createdBy51mon.utils.servlet_constants.AddressServletConstants;
import createdBy51mon.utils.servlet_constants.ApartmentServletConstants;
import createdBy51mon.utils.servlet_constants.PersonServletConstants;

import javax.servlet.http.HttpServletRequest;

public class MappingUtil {
    public static AddressDTO mapAddress(HttpServletRequest req) {
        return AddressDTO.builder()
                .id(ParsingUtil.getIntegerParam(req, AddressServletConstants.ADDRESS_ID_PARAM))
                .city(ParsingUtil.getStringParam(req, AddressServletConstants.ADDRESS_CITY_PARAM))
                .street(ParsingUtil.getStringParam(req, AddressServletConstants.ADDRESS_STREET_PARAM))
                .houseNumber(ParsingUtil.getIntegerParam(req, AddressServletConstants.ADDRESS_HOUSE_NUMBER_PARAM))
                .build();
    }

    public static ApartmentDTO mapApartment(HttpServletRequest req) {
        return ApartmentDTO.builder()
                .id(ParsingUtil.getIntegerParam(req, ApartmentServletConstants.APARTMENT_ID_PARAM))
                .apartmentNumber(ParsingUtil.getIntegerParam(req, ApartmentServletConstants.APARTMENT_NUMBER_PARAM))
                .floor(ParsingUtil.getIntegerParam(req, ApartmentServletConstants.APARTMENT_FLOOR_PARAM))
                .countOfRooms(ParsingUtil.getIntegerParam(req, ApartmentServletConstants.APARTMENT_COUNT_OF_ROOMS_PARAM))
                .totalSquare(ParsingUtil.getDoubleParam(req, ApartmentServletConstants.APARTMENT_TOTAL_SQUARE_PARAM))
                .addressId(ParsingUtil.getIntegerParam(req, ApartmentServletConstants.APARTMENT_ADDRESS_ID_PARAM))
                .address(mapAddress(req))
                .build();
    }

    public static PersonDTO mapPerson(HttpServletRequest req) {
        return PersonDTO.builder()
                .id(ParsingUtil.getIntegerParam(req, PersonServletConstants.PERSON_ID_PARAM))
                .name(ParsingUtil.getStringParam(req, PersonServletConstants.PERSON_NAME_PARAM))
                .surname(ParsingUtil.getStringParam(req, PersonServletConstants.PERSON_SURNAME_PARAM))
                .patronymic(ParsingUtil.getStringParam(req, PersonServletConstants.PERSON_PATRONYMIC_PARAM))
                .age(ParsingUtil.getIntegerParam(req, PersonServletConstants.PERSON_AGE_PARAM))
                .build();
    }
}

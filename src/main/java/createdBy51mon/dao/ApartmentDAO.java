package createdBy51mon.dao;

import createdBy51mon.entity.ApartmentEntity;

public interface ApartmentDAO extends CommonDAO<ApartmentEntity> {
/**
     * Метод возвращает уникальную строку (запись) таблицы apartment, которая ищется по существующим значениям
     * полей объекта класса {@code ApartmentEntity}.
     * @param apartmentEntity объект класса {@code ApartmentEntity}.
     * @return строка (запись) таблицы apartment, соответствующая условию, описанном в реализации этого метода
     */
    ApartmentEntity getByFields(ApartmentEntity apartmentEntity);
}

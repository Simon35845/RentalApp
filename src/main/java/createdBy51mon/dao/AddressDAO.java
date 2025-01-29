package createdBy51mon.dao;

import createdBy51mon.entity.AddressEntity;

public interface AddressDAO extends DAO<AddressEntity> {
    /**
     * Метод возвращает уникальную строку (запись) таблицы address, которая ищется по существующим значениям
     * полей объекта класса {@code AddressEntity}.
     * @param addressEntity объект класса {@code AddressEntity}.
     * @return строка (запись) таблицы address, соответствующая условию, описанном в реализации этого метода
     */
    AddressEntity getByFields(AddressEntity addressEntity);
}

package createdBy51mon.dao;

import createdBy51mon.entity.PersonEntity;

public interface PersonDAO extends DAO<PersonEntity> {
    /**
     * Метод возвращает уникальную строку (запись) таблицы person, которая ищется по существующим значениям
     * полей объекта класса {@code PersonEntity}.
     * @param personEntity объект класса {@code PersonEntity}.
     * @return строка (запись) таблицы person, соответствующая условию, описанном в реализации этого метода
     */
    PersonEntity getByFields(PersonEntity personEntity);
}


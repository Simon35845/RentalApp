package createdBy51mon.service;

import createdBy51mon.dto.PersonDTO;

import java.util.List;

public interface PersonService {
    /**
     * Получает из сервлета DTO, конвертирует в Entity
     * и передает на слой DAO для сохранения
     *
     * @param personDTO DTO, который нужно записать в БД
     * @return записанный в БД объект с id
     */
    PersonDTO save(PersonDTO personDTO);

    /**
     * Получает из слоя DAO объект Entity по id,
     * конвертирует в объект DTO для дальнейшей передачи сервлету
     *
     * @param id идентификатор записи в БД
     * @return полученная запись или null в случае, если запись не найдена
     */
    PersonDTO get(Integer id);

    /**
     * Получает из слоя DAO список всех объектов Entity в БД,
     * конвертирует их в объекты DTO для дальнейшей передачи сервлету
     *
     * @return список объектов DTO
     */
    List<PersonDTO> getAll();

    /**
     * Получает из сервлета DTO и id, конвертирует DTO в Entity
     * и передает на слой DAO для обновления записи в БД
     * @param id идентификатор записи в БД
     * @param personDTO DTO, который нужно обновить в БД
     * @return обновленный в БД объект
     */
    PersonDTO update(Integer id, PersonDTO personDTO);

    /**
     * С помощью слоя DAO инициирует удаление объекта из БД
     *
     * @param id идентификатор записи для удаления
     * @return true, если запись удалена, false, если запись не была найдена
     * или не произошло удаление
     */
    boolean delete(Integer id);

    /**
     * Закрывает сессию у объекта DAO
     */
    void close();
}

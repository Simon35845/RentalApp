package createdBy51mon.utils;

import javax.persistence.EntityManager;

/**
 * Функциональный интерфейс {@code HibernateExecutor} необходим для выполнения стрима:
 * подключение к БД -> формирование запроса -> вывод результата по запросу.
 * @param <T> тип данных, который возвращает абстрактный метод {@code execute}
 */
@FunctionalInterface
public interface HibernateExecutor<T> {
    /**
     * Метод позволяет управлять данными в таблице БД
     * @param em объект EntityManager, который взаимодействует с БД
     * @return результат выполнения операции
     */
    T execute(EntityManager em);
}

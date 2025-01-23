package createdBy51mon.utils;

import createdBy51mon.exception.DuplicateExistingEntryException;
import org.hibernate.exception.ConstraintViolationException;

import javax.persistence.EntityManager;

public class ExecutorUtil {
    /**
     * Метод запускает транзакцию и делает коммит, если операция с БД прошла успешно
     * Отменяет изменения, если во время выполнения транзакции произошла ошибка
     * @param entityManager     сессия для работы с БД
     * @param hibernateExecutor функциональный интерфейс, который выполняет операции с БД
     * @param <T>               тип объекта, с таблицей которого проводятся операции в БД
     * @return результат выполнения метода интерфейса HibernateExecutor
     */
    public static <T> T executeHibernate(EntityManager entityManager,
                                         HibernateExecutor<T> hibernateExecutor) {
        try {
            entityManager.getTransaction().begin();
            T t = hibernateExecutor.execute(entityManager);
            entityManager.getTransaction().commit();
            return t;
        } catch (ConstraintViolationException e) {
            entityManager.getTransaction().rollback();
            throw new DuplicateExistingEntryException("Такая запись в таблице уже существует");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
    }
}

package createdBy51mon.utils;

import javax.persistence.EntityManager;

@FunctionalInterface
public interface HibernateExecutor<T> {
    T execute(EntityManager em);
}

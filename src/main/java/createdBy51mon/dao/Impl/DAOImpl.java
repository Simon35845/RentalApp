package createdBy51mon.dao.Impl;

import createdBy51mon.dao.DAO;
import createdBy51mon.utils.ExecutorUtil;
import createdBy51mon.utils.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class DAOImpl<T> implements DAO<T> {
    private final EntityManager entityManager;
    private final Class<T> clazz;

    public DAOImpl(Class<T> clazz) {
        this.entityManager = HibernateUtil.getEntityManager();
        this.clazz = clazz;
    }

    @Override
    public T save(T t) {
        return ExecutorUtil.executeHibernate(this.entityManager, em -> {
            em.persist(t);
            return t;
        });
    }

    @Override
    public T get(Integer id) {
        return ExecutorUtil.executeHibernate(this.entityManager, em ->
                em.find(clazz, id));
    }

    @Override
    public List<T> getAll() {
        String query = "FROM " + clazz.getSimpleName();
        return ExecutorUtil.executeHibernate(this.entityManager, em ->
                em.createQuery(query, clazz).getResultList());
    }

    @Override
    public T update(Integer id, T t) {
        return ExecutorUtil.executeHibernate(this.entityManager, em -> {
            T updatedEntity = em.find(clazz, id);
            if (updatedEntity != null) {
                updatedEntity = em.merge(t);
            }
            return updatedEntity;
        });
    }

    @Override
    public boolean delete(Integer id) {
        return Boolean.TRUE.equals(ExecutorUtil.executeHibernate(this.entityManager, em -> {
            T t = em.find(clazz, id);
            if (t != null) {
                em.remove(t);
                return true;
            } else {
                return false;
            }
        }));
    }

    @Override
    public void close() {
        if (this.entityManager.isOpen()) {
            this.entityManager.close();
        }
    }
}

package createdBy51mon.dao.Impl;

import createdBy51mon.dao.PersonDAO;
import createdBy51mon.entity.PersonEntity;
import createdBy51mon.utils.ExecutorUtil;
import createdBy51mon.utils.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PersonDAOImpl implements PersonDAO {
    private final EntityManager entityManager;

    public PersonDAOImpl() {
        this.entityManager = HibernateUtil.getEntityManager();
    }

    @Override
    public PersonEntity save(PersonEntity personEntity) {
        return ExecutorUtil.executeHibernate(this.entityManager, em -> {
            em.persist(personEntity);
            return personEntity;
        });
    }

    @Override
    public PersonEntity get(Integer id) {
        return ExecutorUtil.executeHibernate(this.entityManager, em ->
                em.find(PersonEntity.class, id));
    }

    @Override
    public List<PersonEntity> getAll() {
        String query = "FROM " + PersonEntity.class.getSimpleName();
        return ExecutorUtil.executeHibernate(this.entityManager, em ->
                em.createQuery(query, PersonEntity.class).getResultList());
    }

    @Override
    public PersonEntity update(Integer id, PersonEntity personEntity) {
        return ExecutorUtil.executeHibernate(this.entityManager, em -> {
            PersonEntity updatedPerson = em.find(PersonEntity.class, id);
            if (updatedPerson != null) {
                updatedPerson.setName(personEntity.getName());
                updatedPerson.setSurname(personEntity.getSurname());
                updatedPerson.setPatronymic(personEntity.getPatronymic());
                updatedPerson.setAge(personEntity.getAge());
//                updatedPerson = em.merge(updatedPerson);
            }
            return updatedPerson;
        });
    }

    @Override
    public boolean delete(Integer id) {
        return Boolean.TRUE.equals(ExecutorUtil.executeHibernate(this.entityManager, em -> {
            PersonEntity person = em.find(PersonEntity.class, id);
            if (person != null) {
                em.remove(person);
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

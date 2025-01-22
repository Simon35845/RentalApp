package createdBy51mon.dao.Impl;

import createdBy51mon.dao.PersonDAO;
import createdBy51mon.entity.PersonEntity;
import createdBy51mon.utils.ExecutorUtil;
import createdBy51mon.utils.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class PersonDAOImpl extends CommonDAOImpl<PersonEntity> implements PersonDAO  {

    private final EntityManager entityManager;

    public PersonDAOImpl() {
        super(PersonEntity.class);
        this.entityManager = HibernateUtil.getEntityManager();
    }

    @Override
    public PersonEntity getByFields (PersonEntity personEntity) {
        String name = personEntity.getName();
        String surname = personEntity.getSurname();
        String patronymic = personEntity.getPatronymic();

        String query = "SELECT p FROM PersonEntity p " +
                "WHERE p.name = :name " +
                "AND p.surname = :surname "+
                "AND p.patronymic = :patronymic ";

        return ExecutorUtil.executeHibernate(this.entityManager, em -> {
            TypedQuery<PersonEntity> typedQuery = this.entityManager.createQuery(query, PersonEntity.class);
            typedQuery.setParameter("name", name);
            typedQuery.setParameter("surname", surname);
            typedQuery.setParameter("patronymic", patronymic);

            List<PersonEntity> results = typedQuery.getResultList();
            return results.isEmpty() ? null : results.get(0);
        });
    }
}

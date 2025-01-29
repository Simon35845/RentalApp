package createdBy51mon.dao.impl;

import createdBy51mon.dao.AddressDAO;
import createdBy51mon.entity.AddressEntity;
import createdBy51mon.utils.ExecutorUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class AddressDAOImpl extends DAOImpl<AddressEntity> implements AddressDAO {
    private final EntityManager entityManager;

    public AddressDAOImpl() {
        super(AddressEntity.class);
        this.entityManager = super.getEntityManager();
    }

    @Override
    public AddressEntity getByFields (AddressEntity addressEntity) {
        String city = addressEntity.getCity();
        String street = addressEntity.getStreet();
        Integer houseNumber = addressEntity.getHouseNumber();

        String query = "SELECT a FROM AddressEntity a " +
                "WHERE a.city = :city " +
                "AND a.street = :street "+
                "AND a.houseNumber = :house_number ";

        return ExecutorUtil.executeHibernate(this.entityManager, em -> {
            TypedQuery<AddressEntity> typedQuery = this.entityManager.createQuery(query, AddressEntity.class);
            typedQuery.setParameter("city", city);
            typedQuery.setParameter("street", street);
            typedQuery.setParameter("house_number", houseNumber);

            List<AddressEntity> results = typedQuery.getResultList();
            return results.isEmpty() ? null : results.get(0);
        });
    }
}

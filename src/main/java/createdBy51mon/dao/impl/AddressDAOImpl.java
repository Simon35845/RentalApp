package createdBy51mon.dao.impl;

import createdBy51mon.dao.AddressDAO;
import createdBy51mon.entity.AddressEntity;
import createdBy51mon.entity.ApartmentEntity;
import createdBy51mon.utils.ExecutorUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.Set;

public class AddressDAOImpl extends DAOImpl<AddressEntity> implements AddressDAO {
    private final EntityManager entityManager;

    public AddressDAOImpl() {
        super(AddressEntity.class);
        this.entityManager = super.getEntityManager();
    }

    @Override
    public Set<ApartmentEntity> getApartmentsByAddress(Integer addressId) {
        String query = "FROM ApartmentEntity a WHERE a.address.id = :address_id";
        return ExecutorUtil.executeHibernate(this.entityManager, em -> {
            TypedQuery<ApartmentEntity> typedQuery = this.entityManager.createQuery(query, ApartmentEntity.class);
            typedQuery.setParameter("address_id", addressId);
            return new HashSet<>(typedQuery.getResultList());
        });
    }
}

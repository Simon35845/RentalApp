package createdBy51mon.dao.Impl;

import createdBy51mon.dao.ApartmentDAO;
import createdBy51mon.entity.AddressEntity;
import createdBy51mon.entity.ApartmentEntity;
import createdBy51mon.utils.ExecutorUtil;
import createdBy51mon.utils.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ApartmentDAOImpl extends CommonDAOImpl<ApartmentEntity> implements ApartmentDAO {
    private final EntityManager entityManager;

    public ApartmentDAOImpl() {
        super(ApartmentEntity.class);
        this.entityManager = super.getEntityManager();
    }

    @Override
    public ApartmentEntity save(ApartmentEntity apartmentEntity) {
        return ExecutorUtil.executeHibernate(this.entityManager, em -> {
            AddressEntity addressEntity = apartmentEntity.getAddress();
            if (addressEntity != null && addressEntity.getId() == null) {
                em.persist(addressEntity); // Сохраняем новый адрес
            }
// Костыльный способ сохранения apartmentEntity с detached полем address через persist
            apartmentEntity.setAddress(addressEntity);
            ApartmentEntity newApartment = new ApartmentEntity();
            newApartment.setApartmentNumber(apartmentEntity.getApartmentNumber());
            newApartment.setFloor(apartmentEntity.getFloor());
            newApartment.setCountOfRooms(apartmentEntity.getCountOfRooms());
            newApartment.setTotalSquare(apartmentEntity.getTotalSquare());
            newApartment.setAddress(addressEntity);
            em.persist(newApartment);
            return newApartment;
        });
    }

    @Override
    public ApartmentEntity getByFields(ApartmentEntity apartmentEntity) {
        Integer apartmentNumber = apartmentEntity.getApartmentNumber();
        AddressEntity address = apartmentEntity.getAddress();

        String query = "SELECT a FROM ApartmentEntity a " +
                "WHERE a.apartmentNumber = :apartment_number " +
                "AND a.address = :address ";

        return ExecutorUtil.executeHibernate(this.entityManager, em -> {
            TypedQuery<ApartmentEntity> typedQuery = this.entityManager.createQuery(query, ApartmentEntity.class);
            typedQuery.setParameter("apartment_number", apartmentNumber);
            typedQuery.setParameter("address", address);

            List<ApartmentEntity> results = typedQuery.getResultList();
            return results.isEmpty() ? null : results.get(0);
        });
    }

    @Override
    public void close() {
        if (this.entityManager.isOpen()) {
            this.entityManager.close();
        }
    }
}

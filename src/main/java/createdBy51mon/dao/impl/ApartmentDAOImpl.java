package createdBy51mon.dao.impl;

import createdBy51mon.dao.ApartmentDAO;
import createdBy51mon.entity.AddressEntity;
import createdBy51mon.entity.ApartmentEntity;
import createdBy51mon.utils.ExecutorUtil;

import javax.persistence.EntityManager;

public class ApartmentDAOImpl extends DAOImpl<ApartmentEntity> implements ApartmentDAO {
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
                em.persist(addressEntity);
            }

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
    public ApartmentEntity update(Integer id, ApartmentEntity apartmentEntity) {
        return ExecutorUtil.executeHibernate(this.entityManager, em -> {
            ApartmentEntity newApartment = em.find(ApartmentEntity.class, id);

            newApartment.setApartmentNumber(apartmentEntity.getApartmentNumber());
            newApartment.setFloor(apartmentEntity.getFloor());
            newApartment.setCountOfRooms(apartmentEntity.getCountOfRooms());
            newApartment.setTotalSquare(apartmentEntity.getTotalSquare());

            em.merge(newApartment);
            return newApartment;
        });
    }

    @Override
    public void close() {
        if (this.entityManager.isOpen()) {
            this.entityManager.close();
        }
    }
}

package createdBy51mon.dao;

import createdBy51mon.entity.AddressEntity;
import createdBy51mon.entity.ApartmentEntity;

import java.util.Set;

public interface AddressDAO extends DAO<AddressEntity> {
    Set<ApartmentEntity> getApartmentsByAddress(Integer addressId);
}

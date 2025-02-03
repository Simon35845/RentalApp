package createdBy51mon.dao.impl;

import createdBy51mon.dao.ApartmentDAO;
import createdBy51mon.entity.ApartmentEntity;

public class ApartmentDAOImpl extends DAOImpl<ApartmentEntity> implements ApartmentDAO {
    public ApartmentDAOImpl() {
        super(ApartmentEntity.class);
    }
}

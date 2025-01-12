package createdBy51mon.dao.Impl;

import createdBy51mon.dao.ApartmentDAO;
import createdBy51mon.entity.ApartmentEntity;

public class ApartmentDAOImpl extends CommonDAOImpl<ApartmentEntity> implements ApartmentDAO {
    public ApartmentDAOImpl() {
        super(ApartmentEntity.class);
    }
}

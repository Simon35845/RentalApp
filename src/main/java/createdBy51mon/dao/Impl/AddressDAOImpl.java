package createdBy51mon.dao.Impl;

import createdBy51mon.dao.AddressDAO;
import createdBy51mon.entity.AddressEntity;

public class AddressDAOImpl extends CommonDAOImpl<AddressEntity> implements AddressDAO {
    public AddressDAOImpl() {
        super(AddressEntity.class);
    }
}

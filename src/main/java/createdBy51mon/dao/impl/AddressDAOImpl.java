package createdBy51mon.dao.impl;

import createdBy51mon.dao.AddressDAO;
import createdBy51mon.entity.AddressEntity;

public class AddressDAOImpl extends DAOImpl<AddressEntity> implements AddressDAO {
    public AddressDAOImpl() {
        super(AddressEntity.class);
    }
}


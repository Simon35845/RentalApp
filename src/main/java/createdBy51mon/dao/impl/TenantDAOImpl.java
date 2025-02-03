package createdBy51mon.dao.impl;

import createdBy51mon.dao.TenantDAO;
import createdBy51mon.entity.TenantEntity;

public class TenantDAOImpl extends DAOImpl<TenantEntity> implements TenantDAO {
    public TenantDAOImpl() {
        super(TenantEntity.class);
    }
}

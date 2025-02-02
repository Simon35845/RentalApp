package createdBy51mon.dao.impl;

import createdBy51mon.dao.LandlordDAO;
import createdBy51mon.entity.LandlordEntity;

public class LandlordDAOImpl extends DAOImpl<LandlordEntity> implements LandlordDAO {
    public LandlordDAOImpl() {
        super(LandlordEntity.class);
    }
}

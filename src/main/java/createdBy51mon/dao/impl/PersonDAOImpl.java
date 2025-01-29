package createdBy51mon.dao.impl;

import createdBy51mon.dao.PersonDAO;
import createdBy51mon.entity.PersonEntity;

public class PersonDAOImpl extends DAOImpl<PersonEntity> implements PersonDAO {
    public PersonDAOImpl() {
        super(PersonEntity.class);
    }
}

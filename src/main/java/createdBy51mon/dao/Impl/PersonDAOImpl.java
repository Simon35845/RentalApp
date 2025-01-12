package createdBy51mon.dao.Impl;

import createdBy51mon.dao.PersonDAO;
import createdBy51mon.entity.PersonEntity;

public class PersonDAOImpl extends CommonDAOImpl<PersonEntity> implements PersonDAO  {

    public PersonDAOImpl() {
        super(PersonEntity.class);
    }
}

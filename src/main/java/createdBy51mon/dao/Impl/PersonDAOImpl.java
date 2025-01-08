package createdBy51mon.dao.Impl;

import createdBy51mon.dao.PersonDAO;
import createdBy51mon.entity.PersonEntity;
import createdBy51mon.utils.ExecutorUtil;
import createdBy51mon.utils.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PersonDAOImpl extends DAOImpl<PersonEntity> implements PersonDAO  {

    public PersonDAOImpl() {
        super(PersonEntity.class);
    }
}

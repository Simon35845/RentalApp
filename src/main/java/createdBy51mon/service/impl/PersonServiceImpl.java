package createdBy51mon.service.impl;

import createdBy51mon.dao.LandlordDAO;
import createdBy51mon.dao.PersonDAO;
import createdBy51mon.dao.TenantDAO;
import createdBy51mon.dao.impl.LandlordDAOImpl;
import createdBy51mon.dao.impl.PersonDAOImpl;
import createdBy51mon.dao.impl.TenantDAOImpl;
import createdBy51mon.dto.PersonDTO;
import createdBy51mon.entity.LandlordEntity;
import createdBy51mon.entity.PersonEntity;
import createdBy51mon.entity.TenantEntity;
import createdBy51mon.service.PersonService;
import createdBy51mon.utils.converters.PersonConverter;
import createdBy51mon.utils.converters.TenantConverter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PersonServiceImpl implements PersonService {
    private final PersonDAO personDAO;
    private final LandlordDAO landlordDAO;
    private final TenantDAO tenantDAO;

    public PersonServiceImpl() {
        this.personDAO = new PersonDAOImpl();
        this.landlordDAO = new LandlordDAOImpl();
        this.tenantDAO = new TenantDAOImpl();
    }

    @Override
    public PersonDTO save(PersonDTO personDTO) {
        PersonEntity newEntity = PersonConverter.toEntity(personDTO);
        PersonEntity savedEntity = personDAO.save(newEntity);

        if (savedEntity.getIsLandlord()) {
            LandlordEntity landlordEntity = new LandlordEntity();
            landlordEntity.setId(savedEntity.getId());
            landlordEntity.setName(savedEntity.getName());
            landlordEntity.setSurname(savedEntity.getSurname());
            landlordEntity.setPatronymic(savedEntity.getPatronymic());
            landlordEntity.setAge(savedEntity.getAge());
            landlordEntity.setIsLandlord(savedEntity.getIsLandlord());
            landlordDAO.save(landlordEntity);
        } else {
            landlordDAO.delete(savedEntity.getId());
        }

        if (savedEntity.getIsTenant()) {
            TenantEntity tenantEntity = TenantEntity.builder()
                    .id(savedEntity.getId())
                    .name(savedEntity.getName())
                    .surname(savedEntity.getSurname())
                    .patronymic(savedEntity.getPatronymic())
                    .build();
            tenantDAO.save(tenantEntity);
        }

        if (savedEntity.getIsTenant()) {
            TenantEntity tenantEntity = new TenantEntity();
            tenantEntity.setId(savedEntity.getId());
            tenantEntity.setName(savedEntity.getName());
            tenantEntity.setSurname(savedEntity.getSurname());
            tenantEntity.setPatronymic(savedEntity.getPatronymic());
            tenantEntity.setAge(savedEntity.getAge());
            tenantEntity.setIsLandlord(savedEntity.getIsLandlord());
            tenantDAO.save(tenantEntity);
        }

        personDTO.setId(savedEntity.getId());
        return personDTO;
    }

    @Override
    public PersonDTO get(Integer id) {
        return PersonConverter.toDTO(personDAO.get(id));
    }

    @Override
    public List<PersonDTO> getAll() {
        return personDAO.getAll().stream()
                .map(PersonConverter::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PersonDTO update(Integer id, PersonDTO personDTO) {
        PersonEntity newEntity = PersonConverter.toEntity(personDTO);
        PersonEntity oldEntity = personDAO.get(id);

        if (newEntity != null && newEntity != oldEntity) {
            PersonEntity updatedEntity = personDAO.update(id, newEntity);

            if (updatedEntity.getIsLandlord()) {
                LandlordEntity landlordEntity = new LandlordEntity();
                landlordEntity.setId(updatedEntity.getId());
                landlordEntity.setName(updatedEntity.getName());
                landlordEntity.setSurname(updatedEntity.getSurname());
                landlordEntity.setPatronymic(updatedEntity.getPatronymic());
                landlordEntity.setAge(updatedEntity.getAge());
                landlordEntity.setIsLandlord(updatedEntity.getIsLandlord());
                landlordDAO.save(landlordEntity);
            } else {
                landlordDAO.delete(updatedEntity.getId());
            }

            if (updatedEntity.getIsTenant()) {
                TenantEntity tenantEntity = new TenantEntity();
                tenantEntity.setId(updatedEntity.getId());
                tenantEntity.setName(updatedEntity.getName());
                tenantEntity.setSurname(updatedEntity.getSurname());
                tenantEntity.setPatronymic(updatedEntity.getPatronymic());
                tenantEntity.setAge(updatedEntity.getAge());
                tenantEntity.setIsLandlord(updatedEntity.getIsLandlord());
                tenantDAO.save(tenantEntity);
            } else {
                tenantDAO.delete(updatedEntity.getId());
            }

            personDTO.setId(updatedEntity.getId());
        }
        return personDTO;
    }

    @Override
    public boolean delete(Integer id) {
        return personDAO.delete(id);
    }

    @Override
    public void closeDao() {
        personDAO.close();
        landlordDAO.close();
        tenantDAO.close();
    }
}

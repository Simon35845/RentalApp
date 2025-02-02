package createdBy51mon.service.impl;

import createdBy51mon.dao.PersonDAO;
import createdBy51mon.dao.impl.PersonDAOImpl;
import createdBy51mon.dto.PersonDTO;
import createdBy51mon.entity.PersonEntity;
import createdBy51mon.service.PersonService;
import createdBy51mon.utils.converters.PersonConverter;

import java.util.List;
import java.util.stream.Collectors;

public class PersonServiceImpl implements PersonService {
    private final PersonDAO personDAO;

    public PersonServiceImpl() {
        this.personDAO = new PersonDAOImpl();
    }

    @Override
    public PersonDTO save(PersonDTO personDTO) {
            PersonEntity newEntity = PersonConverter.toEntity(personDTO);
            PersonEntity savedEntity = personDAO.save(newEntity);
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
    }
}

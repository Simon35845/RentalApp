package createdBy51mon.service.impl;

import createdBy51mon.dao.PersonDAO;
import createdBy51mon.dao.impl.PersonDAOImpl;
import createdBy51mon.dto.PersonDTO;
import createdBy51mon.entity.PersonEntity;
import createdBy51mon.exception.DuplicateExistingEntryException;
import createdBy51mon.service.PersonService;
import createdBy51mon.utils.converters.PersonConverter;

import java.util.List;
import java.util.stream.Collectors;

public class PersonServiceImpl implements PersonService<PersonDTO> {
    private final PersonDAO personDAO = new PersonDAOImpl();

    @Override
    public PersonDTO save(PersonDTO personDTO) {
        try {
            PersonEntity personEntity = PersonConverter.toEntity(personDTO);
            PersonEntity savedEntity = personDAO.save(personEntity);
            if (savedEntity == null) {
                throw new DuplicateExistingEntryException("Такая запись в таблице уже существует");
            }
            personDTO.setId(savedEntity.getId());
            return personDTO;
        } catch (DuplicateExistingEntryException e) {
            throw e;
        }
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
        PersonEntity personEntity = PersonConverter.toEntity(personDTO);
        personEntity.setId(id);
        personDTO.setId(personDAO.update(id, personEntity).getId());
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

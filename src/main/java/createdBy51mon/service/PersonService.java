package createdBy51mon.service;

import createdBy51mon.dto.PersonDTO;

import java.util.List;

public interface PersonService {
    PersonDTO save(PersonDTO personDTO);

    PersonDTO get(Integer id);

    List<PersonDTO> getAll();

    PersonDTO update(Integer id, PersonDTO personDTO);

    boolean delete(Integer id);

    void closeDao();
}

package createdBy51mon.service;

import createdBy51mon.dto.AddressDTO;

import java.util.List;

public interface AddressService<T> {
    AddressDTO save(AddressDTO addressDTO);

    AddressDTO get(Integer id);

    List<AddressDTO> getAll();

    AddressDTO update(Integer id, AddressDTO addressDTO);

    boolean delete(Integer id);

    void closeDao();
}

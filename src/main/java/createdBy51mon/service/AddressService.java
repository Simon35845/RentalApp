package createdBy51mon.service;

import createdBy51mon.dto.AddressDTO;
import createdBy51mon.dto.ApartmentDTO;

import java.util.List;

public interface AddressService {
    AddressDTO save(AddressDTO addressDTO);

    AddressDTO get(Integer id);

    List<AddressDTO> getAll();

    AddressDTO update(Integer id, AddressDTO addressDTO);

    boolean delete(Integer id);

    List<ApartmentDTO> getApartmentsByAddress(Integer addressId);

    void closeDao();
}

package createdBy51mon.service;

import createdBy51mon.dto.AddressDTO;
import createdBy51mon.dto.ApartmentDTO;

import java.util.List;

public interface ApartmentService {
    ApartmentDTO save(ApartmentDTO apartmentDTO);

    ApartmentDTO get(Integer id);

    List<ApartmentDTO> getAll();

    List<AddressDTO> getAddresses();

    ApartmentDTO update(Integer id, ApartmentDTO apartmentDTO);

    boolean delete(Integer id);

    void closeDao();
}

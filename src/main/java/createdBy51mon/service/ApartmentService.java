package createdBy51mon.service;

import createdBy51mon.dto.ApartmentDTO;

import java.util.List;

public interface ApartmentService<T> {
    ApartmentDTO save(ApartmentDTO apartmentDTO);

    ApartmentDTO get(Integer id);

    List<ApartmentDTO> getAll();

    ApartmentDTO update(Integer id, ApartmentDTO apartmentDTO);

    boolean delete(Integer id);

    void closeDao();
}

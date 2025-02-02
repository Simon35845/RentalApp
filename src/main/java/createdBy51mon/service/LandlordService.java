package createdBy51mon.service;

import createdBy51mon.dto.LandlordDTO;

import java.util.List;

public interface LandlordService {
    LandlordDTO save(LandlordDTO landlordDTO);

    LandlordDTO get(Integer id);

    List<LandlordDTO> getAll();

    LandlordDTO update(Integer id, LandlordDTO landlordDTO);

    boolean delete(Integer id);

    void closeDao();
}

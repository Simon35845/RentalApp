package createdBy51mon.service.impl;

import createdBy51mon.dao.LandlordDAO;
import createdBy51mon.dao.impl.LandlordDAOImpl;
import createdBy51mon.dto.LandlordDTO;
import createdBy51mon.entity.LandlordEntity;
import createdBy51mon.service.LandlordService;
import createdBy51mon.utils.converters.LandlordConverter;

import java.util.List;
import java.util.stream.Collectors;

public class LandlordServiceImpl implements LandlordService {
    private final LandlordDAO landlordDAO;

    public LandlordServiceImpl() {
        this.landlordDAO = new LandlordDAOImpl();
    }

    public LandlordDTO save(LandlordDTO landlordDTO) {
        LandlordEntity newEntity = LandlordConverter.toEntity(landlordDTO);
        LandlordEntity savedEntity = landlordDAO.save(newEntity);
        landlordDTO.setId(savedEntity.getId());
        return landlordDTO;
    }

    @Override
    public LandlordDTO get(Integer id) {
        return LandlordConverter.toDTO(landlordDAO.get(id));
    }

    @Override
    public List<LandlordDTO> getAll() {
        return landlordDAO.getAll().stream()
                .map(LandlordConverter::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LandlordDTO update(Integer id, LandlordDTO landlordDTO) {
        LandlordEntity newEntity = LandlordConverter.toEntity(landlordDTO);
        LandlordEntity oldEntity = landlordDAO.get(id);

        if (newEntity != null && newEntity != oldEntity) {
            LandlordEntity updatedEntity = landlordDAO.update(id, newEntity);
            landlordDTO.setId(updatedEntity.getId());
        }
        return landlordDTO;
    }

    @Override
    public boolean delete(Integer id) {
        return landlordDAO.delete(id);
    }

    @Override
    public void closeDao() {
        landlordDAO.close();
    }
}

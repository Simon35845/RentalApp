package createdBy51mon.service.impl;

import createdBy51mon.dao.ApartmentDAO;
import createdBy51mon.dao.impl.ApartmentDAOImpl;
import createdBy51mon.dto.ApartmentDTO;
import createdBy51mon.entity.ApartmentEntity;
import createdBy51mon.exception.DuplicateExistingEntryException;
import createdBy51mon.service.ApartmentService;
import createdBy51mon.utils.converters.ApartmentConverter;
import java.util.List;
import java.util.stream.Collectors;

public class ApartmentServiceImpl implements ApartmentService<ApartmentDTO> {
    private final ApartmentDAO apartmentDAO = new ApartmentDAOImpl();

    @Override
    public ApartmentDTO save(ApartmentDTO apartmentDTO) {
        try {
            ApartmentEntity apartmentEntity = ApartmentConverter.toEntity(apartmentDTO);
            ApartmentEntity savedEntity = apartmentDAO.save(apartmentEntity);

            if (savedEntity == null) {
                throw new DuplicateExistingEntryException("Такая запись в таблице уже существует");
            }
            apartmentDTO.setId(savedEntity.getId());
            return apartmentDTO;
        } catch (DuplicateExistingEntryException e) {
            throw e;
        }
    }

    @Override
    public ApartmentDTO get(Integer id) {
        return ApartmentConverter.toDTO(apartmentDAO.get(id));
    }

    @Override
    public List<ApartmentDTO> getAll() {
        return apartmentDAO.getAll().stream()
                .map(ApartmentConverter::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ApartmentDTO update(Integer id, ApartmentDTO apartmentDTO) {
        ApartmentEntity apartmentEntity = ApartmentConverter.toEntity(apartmentDTO);
        apartmentEntity.setId(id);
        apartmentDTO.setId(apartmentDAO.update(id, apartmentEntity).getId());
        return apartmentDTO;
    }

    @Override
    public boolean delete(Integer id) {
        return apartmentDAO.delete(id);
    }

    @Override
    public void closeDao() {
        apartmentDAO.close();
    }
}

package createdBy51mon.service.impl;

import createdBy51mon.dao.ApartmentDAO;
import createdBy51mon.dao.Impl.ApartmentDAOImpl;
import createdBy51mon.dto.AddressDTO;
import createdBy51mon.dto.ApartmentDTO;
import createdBy51mon.entity.ApartmentEntity;
import createdBy51mon.service.CommonService;
import createdBy51mon.utils.converters.ApartmentConverter;

import java.util.List;
import java.util.stream.Collectors;

public class ApartmentServiceImpl implements CommonService<ApartmentDTO> {
    private final ApartmentDAO apartmentDAO = new ApartmentDAOImpl();
    private final CommonService<AddressDTO> addressService = new AddressServiceImpl();

    @Override
    public ApartmentDTO save(ApartmentDTO apartmentDTO) {
        AddressDTO addressDTO = apartmentDTO.getAddress();
        if (addressDTO != null) {
            addressDTO = addressService.save(addressDTO);
            apartmentDTO.setAddress(addressDTO);
        }

        ApartmentEntity apartmentEntity = ApartmentConverter.toEntity(apartmentDTO);
        apartmentDTO.setId(apartmentDAO.save(apartmentEntity).getId());
        return apartmentDTO;
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
        addressService.closeDao();
    }
}

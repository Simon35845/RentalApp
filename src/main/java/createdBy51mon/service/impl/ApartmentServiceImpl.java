package createdBy51mon.service.impl;

import createdBy51mon.dao.AddressDAO;
import createdBy51mon.dao.ApartmentDAO;
import createdBy51mon.dao.impl.AddressDAOImpl;
import createdBy51mon.dao.impl.ApartmentDAOImpl;
import createdBy51mon.dto.AddressDTO;
import createdBy51mon.dto.ApartmentDTO;
import createdBy51mon.entity.AddressEntity;
import createdBy51mon.entity.ApartmentEntity;
import createdBy51mon.service.ApartmentService;
import createdBy51mon.utils.converters.AddressConverter;
import createdBy51mon.utils.converters.ApartmentConverter;

import java.util.List;
import java.util.stream.Collectors;

public class ApartmentServiceImpl implements ApartmentService {
    private final ApartmentDAO apartmentDAO;
    private final AddressDAO addressDAO;

    public ApartmentServiceImpl() {
        this.apartmentDAO = new ApartmentDAOImpl();
        this.addressDAO = new AddressDAOImpl();
    }

    @Override
    public ApartmentDTO save(ApartmentDTO apartmentDTO) {
        ApartmentEntity newEntity = ApartmentConverter.toEntity(apartmentDTO);
        Integer addressId = apartmentDTO.getAddressId();

        if (addressId != null) {
            AddressEntity addressEntity = addressDAO.get(addressId);
            newEntity.setAddress(addressEntity);
        }

        ApartmentEntity savedEntity = apartmentDAO.save(newEntity);
        apartmentDTO.setId(savedEntity.getId());
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
    public List<AddressDTO> getAddresses() {
        return addressDAO.getAll().stream()
                .map(AddressConverter::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ApartmentDTO update(Integer id, ApartmentDTO apartmentDTO) {
        ApartmentEntity newEntity = ApartmentConverter.toEntity(apartmentDTO);
        ApartmentEntity oldEntity = apartmentDAO.get(id);
        Integer newAddressId = apartmentDTO.getAddressId();
        Integer oldAddressId = oldEntity.getAddress().getId();

        if (newEntity != null && newEntity != oldEntity) {
            if (newAddressId != null && !newAddressId.equals(oldAddressId)) {
                AddressEntity addressEntity = addressDAO.get(newAddressId);
                newEntity.setAddress(addressEntity);
            }
            ApartmentEntity updatedEntity = apartmentDAO.update(id, newEntity);
            apartmentDTO.setId(updatedEntity.getId());
        }
        return apartmentDTO;
    }

    @Override
    public boolean delete(Integer id) {
        return apartmentDAO.delete(id);
    }

    @Override
    public void closeDao() {
        apartmentDAO.close();
        addressDAO.close();
    }
}

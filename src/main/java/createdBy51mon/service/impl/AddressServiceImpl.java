package createdBy51mon.service.impl;

import createdBy51mon.dao.AddressDAO;
import createdBy51mon.dao.impl.AddressDAOImpl;
import createdBy51mon.dto.AddressDTO;
import createdBy51mon.dto.ApartmentDTO;
import createdBy51mon.entity.AddressEntity;
import createdBy51mon.entity.ApartmentEntity;
import createdBy51mon.service.AddressService;
import createdBy51mon.utils.converters.AddressConverter;
import createdBy51mon.utils.converters.ApartmentConverter;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AddressServiceImpl implements AddressService {
    private final AddressDAO addressDAO;

    public AddressServiceImpl() {
        this.addressDAO = new AddressDAOImpl();
    }

    @Override
    public AddressDTO save(AddressDTO addressDTO) {
        AddressEntity newEntity = AddressConverter.toEntity(addressDTO);
        AddressEntity savedEntity = addressDAO.save(newEntity);
        addressDTO.setId(savedEntity.getId());
        return addressDTO;
    }

    @Override
    public AddressDTO get(Integer id) {
        return AddressConverter.toDTO(addressDAO.get(id));
    }

    @Override
    public List<AddressDTO> getAll() {
        return addressDAO.getAll().stream()
                .map(AddressConverter::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AddressDTO update(Integer id, AddressDTO addressDTO) {
        AddressEntity newEntity = AddressConverter.toEntity(addressDTO);
        AddressEntity oldEntity = addressDAO.get(id);

        if (newEntity != null && newEntity != oldEntity) {
            AddressEntity updatedEntity = addressDAO.update(id, newEntity);
            addressDTO.setId(updatedEntity.getId());
        }

        newEntity.setId(id);
        addressDTO.setId(addressDAO.update(id, newEntity).getId());
        return addressDTO;
    }

    @Override
    public boolean delete(Integer id) {
        return addressDAO.delete(id);
    }

    @Override
    public List<ApartmentDTO> getApartmentsByAddress(Integer id) {
        Set<ApartmentEntity> apartments = addressDAO.getApartmentsByAddress(id);
        return apartments.stream()
                .map(ApartmentConverter::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void closeDao() {
        addressDAO.close();
    }
}

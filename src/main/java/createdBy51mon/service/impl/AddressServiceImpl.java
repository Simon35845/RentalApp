package createdBy51mon.service.impl;

import createdBy51mon.dao.AddressDAO;
import createdBy51mon.dao.Impl.AddressDAOImpl;
import createdBy51mon.dto.AddressDTO;
import createdBy51mon.entity.AddressEntity;
import createdBy51mon.service.CommonService;
import createdBy51mon.utils.converters.AddressConverter;

import java.util.List;
import java.util.stream.Collectors;

public class AddressServiceImpl implements CommonService<AddressDTO> {
    private final AddressDAO addressDAO = new AddressDAOImpl();

    @Override
    public AddressDTO save(AddressDTO addressDTO) {
        AddressEntity addressEntity = AddressConverter.toEntity(addressDTO);
        addressDTO.setId(addressDAO.save(addressEntity).getId());
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
        AddressEntity addressEntity = AddressConverter.toEntity(addressDTO);
        addressEntity.setId(id);
        addressDTO.setId(addressDAO.update(id, addressEntity).getId());
        return addressDTO;
    }

    @Override
    public boolean delete(Integer id) {
        return addressDAO.delete(id);
    }

    @Override
    public void closeDao() {
        addressDAO.close();
    }
}

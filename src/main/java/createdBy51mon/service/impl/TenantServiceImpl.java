package createdBy51mon.service.impl;

import createdBy51mon.dao.TenantDAO;
import createdBy51mon.dao.impl.TenantDAOImpl;
import createdBy51mon.dto.TenantDTO;
import createdBy51mon.entity.TenantEntity;
import createdBy51mon.service.TenantService;
import createdBy51mon.utils.converters.TenantConverter;

import java.util.List;
import java.util.stream.Collectors;

public class TenantServiceImpl implements TenantService {
    private final TenantDAO tenantDAO;

    public TenantServiceImpl() {
        this.tenantDAO = new TenantDAOImpl();
    }

    public TenantDTO save(TenantDTO tenantDTO) {
        TenantEntity newEntity = TenantConverter.toEntity(tenantDTO);
        TenantEntity savedEntity = tenantDAO.save(newEntity);
        tenantDTO.setId(savedEntity.getId());
        return tenantDTO;
    }

    @Override
    public TenantDTO get(Integer id) {
        return TenantConverter.toDTO(tenantDAO.get(id));
    }

    @Override
    public List<TenantDTO> getAll() {
        return tenantDAO.getAll().stream()
                .map(TenantConverter::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TenantDTO update(Integer id, TenantDTO tenantDTO) {
        TenantEntity newEntity = TenantConverter.toEntity(tenantDTO);
        TenantEntity oldEntity = tenantDAO.get(id);

        if (newEntity != null && newEntity != oldEntity) {
            TenantEntity updatedEntity = tenantDAO.update(id, newEntity);
            tenantDTO.setId(updatedEntity.getId());
        }

        newEntity.setId(id);
        tenantDTO.setId(tenantDAO.update(id, newEntity).getId());
        return tenantDTO;
    }

    @Override
    public boolean delete(Integer id) {
        return tenantDAO.delete(id);
    }

    @Override
    public void closeDao() {
        tenantDAO.close();
    }
}

package createdBy51mon.service;

import createdBy51mon.dto.TenantDTO;

import java.util.List;

public interface TenantService {
    TenantDTO save(TenantDTO tenantDTO);

    TenantDTO get(Integer id);

    List<TenantDTO> getAll();

    TenantDTO update(Integer id, TenantDTO tenantDTO);

    boolean delete(Integer id);

    void closeDao();
}

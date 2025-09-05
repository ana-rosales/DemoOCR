package saif.casetas.demoOcr.services.Entradas;

import saif.casetas.demoOcr.entity.EntradasEntity;

import java.util.List;

public interface EntradasService {
    EntradasEntity save(EntradasEntity registro_entradas);
    List<EntradasEntity> findAll();
}
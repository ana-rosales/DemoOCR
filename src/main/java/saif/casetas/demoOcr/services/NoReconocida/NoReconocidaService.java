package saif.casetas.demoOcr.services.NoReconocida;

import java.util.List;

import saif.casetas.demoOcr.entity.NoReconocidaEntity;

public interface NoReconocidaService {
	
	NoReconocidaEntity save(NoReconocidaEntity noReconocida);
	
	List<NoReconocidaEntity> findAll();
}

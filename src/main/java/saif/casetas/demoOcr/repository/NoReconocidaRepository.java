package saif.casetas.demoOcr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import saif.casetas.demoOcr.entity.NoReconocidaEntity;

@Repository
public interface NoReconocidaRepository extends JpaRepository<NoReconocidaEntity, Long>{
	
}

package saif.casetas.demoOcr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import saif.casetas.demoOcr.entity.EntradasEntity;

@Repository
public interface EntradasRepository extends JpaRepository<EntradasEntity,Long> {

}
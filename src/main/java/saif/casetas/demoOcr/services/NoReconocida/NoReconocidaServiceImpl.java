package saif.casetas.demoOcr.services.NoReconocida;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import saif.casetas.demoOcr.entity.NoReconocidaEntity;
import saif.casetas.demoOcr.repository.NoReconocidaRepository;

@Service
public class NoReconocidaServiceImpl implements NoReconocidaService{
	
	@Autowired
	NoReconocidaRepository noReconocidaRepository;
	
	@Override
	@Transactional
	public NoReconocidaEntity save(NoReconocidaEntity noReconocidaEntity) {
		return noReconocidaRepository.save(noReconocidaEntity);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<NoReconocidaEntity> findAll(){
		return noReconocidaRepository.findAll();
	}
	
}

package saif.casetas.demoOcr.services.Entradas;

import ch.qos.logback.core.net.server.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import saif.casetas.demoOcr.entity.EntradasEntity;
import saif.casetas.demoOcr.repository.EntradasRepository;

import java.util.List;

@Service
public class EntradasServiceImpl implements EntradasService {
    @Autowired
    EntradasRepository entradasRepository;

    @Override
    @Transactional
    public EntradasEntity save(EntradasEntity registro_entradas){return  entradasRepository.save(registro_entradas);}

    @Override
    @Transactional(readOnly = true)
    public List<EntradasEntity> findAll(){return  entradasRepository.findAll();}
}
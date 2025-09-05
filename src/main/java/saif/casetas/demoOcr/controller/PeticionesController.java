package saif.casetas.demoOcr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import saif.casetas.demoOcr.entity.EntradasEntity;
import saif.casetas.demoOcr.entity.NoReconocidaEntity;
import saif.casetas.demoOcr.repository.EntradasComponentRepository;
import saif.casetas.demoOcr.services.Entradas.EntradasService;
import saif.casetas.demoOcr.services.NoReconocida.NoReconocidaService;

@RestController
@RequestMapping("/")
public class PeticionesController {
	
	/*@Autowired
	NoReconocidaService noReconocidaService;
	@Autowired
    EntradasService entradasService;//private o sin Impl
	
	@PostMapping("/no-reconocidas-insert")
	public ResponseEntity<?> noReconocidas(@RequestBody NoReconocidaEntity noReconocidaEntity){
		System.out.println("Recibí: " + noReconocidaEntity);
		NoReconocidaEntity nuevaNoReconocida = noReconocidaService.guardar(noReconocidaEntity);
		return ResponseEntity.status(HttpStatus.CREATED).body(nuevaNoReconocida);
	}
	
	@GetMapping("/no-reconocidas")
	public ResponseEntity<List<NoReconocidaEntity>> traerNoReconocida(){
		List<NoReconocidaEntity> lista = noReconocidaService.listar();
		return ResponseEntity.ok(lista);
	}
	
    @PostMapping("entradas-correctas-insert")
    public ResponseEntity<?> Entradas(@RequestBody EntradasEntity entradasEntity) {
        EntradasEntity entradas = entradasService.save(entradasEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(entradas);
    }

    @GetMapping("entradas-correctas")
    public ResponseEntity<List<EntradasEntity>> traerEntradas(){
        List<EntradasEntity> lista=entradasService.findAll();
        //model.addAttribute("lista",lista);
        return ResponseEntity.ok(lista);
    }

    /*private final EntradasComponentRepository myRepository;

    public PeticionesController(EntradasComponentRepository myRepository) {
        this.myReposistory = myRepository;
    }

    @GetMapping("/names")
    public ResponseEntity<List<String>> fetchNames() {
        return ResponseEntity.ok(myRepository.getNames());
    }*/
}

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

import saif.casetas.demoOcr.entity.NoReconocidaEntity;
import saif.casetas.demoOcr.repository.NoReconocidaRepository;
import saif.casetas.demoOcr.services.NoReconocida.NoReconocidaService;

@RestController
@RequestMapping("/")
public class PeticionesController {
	// endpoint jdbc

	private final NoReconocidaRepository myRepository;
	
	public PeticionesController(NoReconocidaRepository myRepository) {
	    this.myRepository = myRepository;
	}
	
	@GetMapping("/names")
	public ResponseEntity<List<String>> fetchNames() {
	    return ResponseEntity.ok(myRepository.getNames());
	}
	
	/*@Autowired
	NoReconocidaService noReconocidaService;
	
	@PostMapping("/ingresarNoReconocidas")
	public ResponseEntity<?> ingresarNoReconocida(@RequestBody NoReconocidaEntity noReconocidaEntity){
		System.out.println("Recibí: " + noReconocidaEntity);
		NoReconocidaEntity nuevaNoReconocida = noReconocidaService.guardar(noReconocidaEntity);
		return ResponseEntity.status(HttpStatus.CREATED).body(nuevaNoReconocida);
	}
	
	@GetMapping("/verNoReconocida")
	public ResponseEntity<List<NoReconocidaEntity>> traerNoReconocida(){
		List<NoReconocidaEntity> lista = noReconocidaService.listar();
		return ResponseEntity.ok(lista);
	}*/
	
	
 
}

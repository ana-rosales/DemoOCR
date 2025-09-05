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
import saif.casetas.demoOcr.services.NoReconocida.NoReconocidaServiceImpl;

@RestController
@RequestMapping("/")
public class PeticionesController {
	
	@Autowired
	NoReconocidaServiceImpl noReconocidaServiceImpl;
	
	@PostMapping("/ingresarNoReconocidas")
	public ResponseEntity<?> ingresarNoReconocida(@RequestBody NoReconocidaEntity noReconocidaEntity){
		NoReconocidaEntity nuevaNoReconocida = noReconocidaServiceImpl.save(noReconocidaEntity);
		return ResponseEntity.status(HttpStatus.CREATED).body(nuevaNoReconocida);
	}
	
	@GetMapping("/verNoReconocida")
	public ResponseEntity<List<NoReconocidaEntity>> traerNoReconocida(){
		List<NoReconocidaEntity> lista = noReconocidaServiceImpl.findAll();
		return ResponseEntity.ok(lista);
	}
}

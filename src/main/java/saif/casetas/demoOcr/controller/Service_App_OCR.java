package saif.casetas.demoOcr.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import saif.casetas.demoOcr.classes.Autobus;
import saif.casetas.demoOcr.classes.dto.BusEntradaTipoME_DTO;
import saif.casetas.demoOcr.classes.dto.NoReconocidas_DTO;
import saif.casetas.demoOcr.consultas.ConsultasService;

@RestController
@RequestMapping("/")
public class Service_App_OCR {
	
	private final ConsultasService consultasService;

	public Service_App_OCR(ConsultasService consultasService) {
		super();
		this.consultasService = consultasService;
	}
	
	@GetMapping("prueba-autobuses")
	public ResponseEntity<List<Autobus>> consultarBuses (){
		List<Autobus> buses = consultasService.consultaPruebaAutobuses();
		return ResponseEntity.status(HttpStatus.OK).body(buses);
	}
	
	@GetMapping("buses-capturas-exitosas")
	public ResponseEntity<List<BusEntradaTipoME_DTO>> consultaBusesCapturasExitosas_CTLR(){
		List<BusEntradaTipoME_DTO> infoBuses = consultasService.consultaBusesCapturasExitosas_BD();
		return ResponseEntity.status(HttpStatus.OK).body(infoBuses);		
	}
	
	@GetMapping("no-reconocidas")
	public ResponseEntity<List<NoReconocidas_DTO>> consultaCapturasNoReconocidas_CTLR(){
		List<NoReconocidas_DTO> infoCaptura = consultasService.consultaCapturasNoReconocidas_BD();
		return ResponseEntity.status(HttpStatus.OK).body(infoCaptura);	
	}
	
}

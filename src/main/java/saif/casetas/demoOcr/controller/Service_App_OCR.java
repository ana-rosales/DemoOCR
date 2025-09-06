package saif.casetas.demoOcr.controller;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import saif.casetas.demoOcr.classes.Autobus;
import saif.casetas.demoOcr.classes.CambioNoReconocidoBody;
import saif.casetas.demoOcr.classes.Entradas;
import saif.casetas.demoOcr.classes.EntradasImg;
import saif.casetas.demoOcr.classes.EntradasImgBody;
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

	@GetMapping("entradas-imagen")
	public ResponseEntity</*List<EntradasImg>*/ EntradasImg> consultaImagen (@RequestBody EntradasImgBody entradasImgBody){
		if (entradasImgBody.getTipo() == 1) {
			/*List<EntradasImg>*/ EntradasImg bus = consultasService.consultaPruebaImagen(entradasImgBody.getCve_entrada());
			//convertirStringABytes(buses.get(0))
			System.out.println(/*(buses.get(0))*/bus);
			return ResponseEntity.status(HttpStatus.OK).body(bus);
		}else  {
			/*List<EntradasImg>*/EntradasImg bus = consultasService.consultaPruebaNoRecImagen(entradasImgBody.getCve_entrada());
			//convertirStringABytes(buses.get(0))
			System.out.println(/*(buses.get(0))*/bus);
			return ResponseEntity.status(HttpStatus.OK).body(bus);
		}
	}
	
	@GetMapping("insert-cambio-entrada")
	public ResponseEntity<String> insertarRegistroEntrada_CTRL(
			@RequestBody CambioNoReconocidoBody cambioNoReconocidoBody){
		
		Boolean insert = consultasService.insertarRegistroEntrada_BD(
				cambioNoReconocidoBody.getCve_entrada(),
				cambioNoReconocidoBody.getCve_vehiculo(),
				cambioNoReconocidoBody.getPlaca(),
				cambioNoReconocidoBody.getNumero_economico(),
				cambioNoReconocidoBody.getMarca());		
		if (insert) {
			return ResponseEntity.status(HttpStatus.OK).body("Cambio exitoso.");
		}
		
		return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("Error al cambiar.");
	}
}

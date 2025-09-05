package saif.casetas.demoOcr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import saif.casetas.demoOcr.entity.EntradasEntity;
import saif.casetas.demoOcr.repository.EntradasComponentRepository;
import saif.casetas.demoOcr.services.Entradas.EntradasService;
import saif.casetas.demoOcr.services.Entradas.EntradasServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/")
public class PeticionesController {
    @Autowired
    EntradasService entradasService;//private o sin Impl

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

    private final EntradasComponentRepository myRepository;

    public PeticionesController(EntradasComponentRepository myRepository) {
        this.myRepository = myRepository;
    }

    @GetMapping("/names")
    public ResponseEntity<List<String>> fetchNames() {
        return ResponseEntity.ok(myRepository.getNames());
    }

}

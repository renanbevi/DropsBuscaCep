package br.com.mandae.DropsBuscaCep.Controller;

import br.com.mandae.DropsBuscaCep.Response.ResponseResults;
import br.com.mandae.DropsBuscaCep.Response.ServiceCep.ServiceCep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cep")
public class CepController {

    @Autowired
    private ServiceCep serviceCep;

    @GetMapping("/cep/{postalcode}")
    public ResponseEntity consultarDistrito(@PathVariable String postalcode) {

       ResponseResults responseResults = serviceCep.RetornarPontoCep(postalcode).getBody();
        return ResponseEntity.ok(responseResults);
    }
}

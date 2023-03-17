package br.com.mandae.DropsBuscaCep.Response.ServiceCep;

import br.com.mandae.DropsBuscaCep.Response.ResponseResults;
import org.junit.jupiter.api.Assertions;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceCep {

    public ResponseEntity<ResponseResults> RetornarPontoCep(String postalcode) {

        RestTemplate restTemplate = new RestTemplate();

        //https://pudo-api.pontodrops.com.br/businessunits/api/v1/business-units/nearby/02126040 exemplo
        String URI = "https://pudo-api.pontodrops.com.br/businessunits/api/v1/business-units/nearby/" + postalcode;

        ResponseEntity<ResponseResults> responseReults =  restTemplate.getForEntity(URI,ResponseResults.class);

         return  responseReults;


    }


}

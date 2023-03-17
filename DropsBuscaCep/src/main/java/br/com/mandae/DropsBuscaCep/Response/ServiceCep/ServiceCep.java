package br.com.mandae.DropsBuscaCep.Response.ServiceCep;

import br.com.mandae.DropsBuscaCep.Response.ResponseResults;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ServiceCep {
    public ResponseResults RetornarPontoCep(String postalcode) {


        String url = "https://pudo-api.pontodrops.com.br/businessunits";
        String uri = "/api/v1/business-units/nearby/{postalcode}";

        ResponseResults responseResults = WebClient
                .create(url)
                .get()
                .uri(uri, postalcode)
                .retrieve()
                .bodyToMono(ResponseResults.class).block();

        return responseResults;
    }
}



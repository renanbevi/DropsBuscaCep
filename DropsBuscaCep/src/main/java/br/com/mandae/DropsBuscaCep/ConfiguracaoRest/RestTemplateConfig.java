package br.com.mandae.DropsBuscaCep.ConfiguracaoRest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate getRestTemplate(@Value("${tokenacesso}") String tokenAcesso) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add((request, body, clientHttpRequestExecution) -> {
            HttpHeaders headers = request.getHeaders();
            if (!headers.containsKey("Authorization")) {
                String token = tokenAcesso.toLowerCase().startsWith("bearer") ? tokenAcesso : "Bearer " + tokenAcesso;
                request.getHeaders().add("Authorization", token);
            }
            return clientHttpRequestExecution.execute(request, body);
        });
        return restTemplate;
    }
}

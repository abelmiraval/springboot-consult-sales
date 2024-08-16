package com.novasoft.springbootconsultsales.infrastructure.services.apiperu;

import com.novasoft.springbootconsultsales.domain.exceptions.BaseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ApiPeruService implements IApiPeruService {

    @Value("${service.apiperu.url}")
    private String url;

    @Value("${service.apiperu.token}")
    private String token;

    private final RestTemplate restTemplate;

    public ApiPeruService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ApiPeruResponseModel<ApiPeruPersonModel> getPerson(String documentNumber) {
        try {

             var type = getTypePerson(documentNumber);

            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url+ "/" + type);

            var headers = new HttpHeaders();
            headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
            headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + token);

            Map<String, String> request = new HashMap<>();
            request.put("dni", documentNumber);

            HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(request, headers);

            ResponseEntity<ApiPeruResponseModel<ApiPeruPersonModel>> response = restTemplate.exchange(
                    builder.toUriString(),
                    HttpMethod.POST,
                    httpEntity,
                    new ParameterizedTypeReference<>() {
                    }
            );

            return response.getStatusCode().equals(HttpStatus.OK) ? response.getBody() : null;


        } catch (Exception e) {
            throw new BaseException("Error al consultar el servicio de ApiPeru");
        }
    }

    private String getTypePerson(String documentNumber) {
        return documentNumber.length() == 8 ? "dni" : "ruc";
    }
}

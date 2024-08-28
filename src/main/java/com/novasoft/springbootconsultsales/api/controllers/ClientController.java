package com.novasoft.springbootconsultsales.api.controllers;

import com.novasoft.springbootconsultsales.api.controllers.request.client.ClientRequest;
import com.novasoft.springbootconsultsales.api.controllers.response.BaseResponse;
import com.novasoft.springbootconsultsales.api.controllers.response.client.ClientResponse;
import com.novasoft.springbootconsultsales.application.mapper.ClientMapper;
import com.novasoft.springbootconsultsales.application.queries.client.IClientQuery;
import com.novasoft.springbootconsultsales.infrastructure.services.apiperu.ApiPeruPersonModel;
import com.novasoft.springbootconsultsales.infrastructure.services.apiperu.ApiPeruResponseModel;
import com.novasoft.springbootconsultsales.infrastructure.services.apiperu.IApiPeruService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {
    private final IClientQuery clientQuery;
    private final IApiPeruService apiPeruService;

    public static final String SUCCESS = "Success";

    public ClientController(IClientQuery clientQuery, IApiPeruService apiPeruService) {
        this.clientQuery = clientQuery;
        this.apiPeruService = apiPeruService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<ClientResponse>> getById(@PathVariable String id) {
        var optional = clientQuery.findById(id);
        var response = optional.map(ClientMapper.INSTANCE::clientToResponse).orElse(null);

        return new ResponseEntity<>(new BaseResponse<>(response, SUCCESS, true), HttpStatus.OK);
    }

    @GetMapping("/autocomplete")
    public ResponseEntity<BaseResponse<List<ClientResponse>>> autocomplete(@RequestParam  String search) {
        var optional = clientQuery.autocomplete(search);
        var response = optional.map(ClientMapper.INSTANCE::clientsToResponse).orElse(null);

        return new ResponseEntity<>(new BaseResponse<>(response, SUCCESS, true), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<BaseResponse<List<ClientResponse>>> search(@RequestParam  String search, @RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
        var optional = clientQuery.search(search, pageNumber, pageSize);
        var response = optional.map(ClientMapper.INSTANCE::clientsToResponse).orElse(null);

        return new ResponseEntity<>(new BaseResponse<>(response, SUCCESS, true), HttpStatus.OK);
    }

    @GetMapping("/person")
    public ResponseEntity<BaseResponse<ApiPeruResponseModel<ApiPeruPersonModel>>> people(@RequestParam  String numberDocument) {
        var response = apiPeruService.getPerson(numberDocument);

        return new ResponseEntity<>(new BaseResponse<>(response, SUCCESS, true), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BaseResponse<Boolean>> create(@RequestBody @Valid ClientRequest clientRequest) {
         var client = ClientMapper.INSTANCE.requestToClient(clientRequest);
         var response = clientQuery.create(client);

        return new ResponseEntity<>(new BaseResponse<>(response, SUCCESS, true), HttpStatus.OK);
    }

}




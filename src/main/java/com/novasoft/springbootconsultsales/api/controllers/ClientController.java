package com.novasoft.springbootconsultsales.api.controllers;

import com.novasoft.springbootconsultsales.api.controllers.response.BaseResponse;
import com.novasoft.springbootconsultsales.api.controllers.response.client.ClientResponse;
import com.novasoft.springbootconsultsales.application.mapper.ClientMapper;
import com.novasoft.springbootconsultsales.application.queries.client.IClientQuery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    private final IClientQuery clientQuery;
    public static final String SUCCESS = "Success";

    public ClientController(IClientQuery clientQuery) {
        this.clientQuery = clientQuery;
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
}




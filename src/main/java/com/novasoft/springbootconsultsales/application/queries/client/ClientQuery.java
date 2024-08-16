package com.novasoft.springbootconsultsales.application.queries.client;

import com.novasoft.springbootconsultsales.domain.aggregates.client.Client;
import com.novasoft.springbootconsultsales.domain.aggregates.client.IClientRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientQuery implements IClientQuery {

    private final IClientRepository clientRepository;

    public ClientQuery(IClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Optional<Client> findById(String id) {
        return clientRepository.findById(id);
    }

    public Optional<List<Client>> autocomplete(String search) {
        Pageable pageable = PageRequest.of(0, 10);
        return clientRepository.autocomplete(search, pageable);
    }

    public Optional<List<Client>> search(String search, int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("cliente").ascending());

        return clientRepository.search(search, pageable);
    }
}

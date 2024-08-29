package com.novasoft.springbootconsultsales.application.queries.client;

import com.novasoft.springbootconsultsales.domain.aggregates.client.Client;
import com.novasoft.springbootconsultsales.infrastructure.repository.IClientRepository;
import com.novasoft.springbootconsultsales.application.exceptions.BusinessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    public Boolean create(Client client){
        var result = clientRepository.findByRuc(client.getRuc(), client.getDni());

        if(result.isPresent()){
            throw new BusinessException("numberDocument", "Ya existe un cliente con el número de documento ingresado");
        }

       validateDocumentType(client.getRuc());

        int maxIdClient = getMaxIdClient() + 1;
        client.setId(String.valueOf(maxIdClient));
        client.setDate(new Date());

        clientRepository.save(client);

        return true;
    }

    private void validateDocumentType(String numberDocument) {
        int size = numberDocument.length();

        if (size != 8 && size != 11) {
            throw new BusinessException("numberDocument", "Número de documento no valido");
        }
    }
    private int getMaxIdClient() {
        Integer maxId = clientRepository.getMaxIdClient();
        return maxId != null ? maxId : 0;
    }

}

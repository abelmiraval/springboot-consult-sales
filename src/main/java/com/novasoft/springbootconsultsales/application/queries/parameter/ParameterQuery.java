package com.novasoft.springbootconsultsales.application.queries.parameter;

import com.novasoft.springbootconsultsales.domain.aggregates.parameter.Parameter;
import com.novasoft.springbootconsultsales.infrastructure.repository.IParameterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParameterQuery implements IParameterQuery {

    private final IParameterRepository parameterRepository;

    public ParameterQuery(IParameterRepository parameterRepository){
        this.parameterRepository = parameterRepository;
    }

    @Override
    public Optional<List<Parameter>> getAll() {
        return Optional.of(parameterRepository.findAll());
    }
}

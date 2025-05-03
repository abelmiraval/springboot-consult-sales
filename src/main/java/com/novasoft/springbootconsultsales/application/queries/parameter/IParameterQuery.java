package com.novasoft.springbootconsultsales.application.queries.parameter;

import com.novasoft.springbootconsultsales.domain.aggregates.parameter.Parameter;

import java.util.List;
import java.util.Optional;

public interface IParameterQuery {
    Optional<List<Parameter>> getAll();
}

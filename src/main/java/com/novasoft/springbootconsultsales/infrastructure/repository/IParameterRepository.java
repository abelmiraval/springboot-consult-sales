package com.novasoft.springbootconsultsales.infrastructure.repository;

import com.novasoft.springbootconsultsales.domain.aggregates.parameter.Parameter;
import org.springframework.stereotype.Repository;

@Repository
public interface IParameterRepository extends IBaseRepository<Parameter, String> {


}

package com.novasoft.springbootconsultsales.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IBaseRepository<T, Id> extends JpaRepository<T, Id> {

}
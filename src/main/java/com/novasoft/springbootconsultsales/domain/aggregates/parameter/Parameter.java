package com.novasoft.springbootconsultsales.domain.aggregates.parameter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="parametros")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Parameter {
    @Id
    @Column(name ="idparametro")
    private String id;

    @Column(name ="tcambio")
    private double exchangeRate;

}

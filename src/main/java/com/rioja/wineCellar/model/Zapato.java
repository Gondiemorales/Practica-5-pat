package com.rioja.wineCellar.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Table("ZAPATOS")
public class Zapato {
    

    @Id
    
    @Column("ZAPATO")
    private String zapato;

    @Column("STOCK")
    private Integer stock;


    public Zapato(String zapato, Integer stock) {
        this.zapato = zapato;
        this.stock = stock;
    }

  

}

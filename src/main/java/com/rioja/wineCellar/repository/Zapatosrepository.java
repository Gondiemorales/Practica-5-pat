package com.rioja.wineCellar.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.rioja.wineCellar.model.Zapato;

public interface Zapatosrepository  extends CrudRepository<Zapato, String>{
    

    @Query("SELECT * FROM ZAPATOS WHERE ZAPATOS.ZAPATO= :zapato")
    public Iterable<Zapato> getZapato(String zapato);


}

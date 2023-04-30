package com.rioja.wineCellar.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rioja.wineCellar.model.Zapato;
import com.rioja.wineCellar.repository.Zapatosrepository;
import com.rioja.wineCellar.service.ZapatoService;


@Service
public class Zapatosimplementation implements ZapatoService{
    
    @Autowired
    private Zapatosrepository zapatorepository;

    

    @Override
    public Iterable<Zapato> getZapatos(){

        return zapatorepository.findAll();

    }

    @Override
    public Zapato getZapato(String zapato){
        Zapato response = null;
        if (zapatorepository.existsById(zapato)) {
            Iterable<Zapato> zapatos = zapatorepository.getZapato(zapato);
            for (Zapato z : zapatos) {
                response = z;
            }
            return response;
        }
        return response;
    }

    
}

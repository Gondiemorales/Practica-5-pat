package com.rioja.wineCellar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rioja.wineCellar.model.Zapato;
import com.rioja.wineCellar.service.ZapatoService;

@RestController
//@RequestMapping("/api/v1")
public class ZapatoController {

    @Autowired
    private ZapatoService zapatoservice;

    @GetMapping("/Zapatos")
    public ResponseEntity<Iterable<Zapato>> getZapatos(){

        Iterable<Zapato> response = zapatoservice.getZapatos();
        return ResponseEntity.ok().body(response);


    }

    @GetMapping("/Zapatos/{nombre}")
    public ResponseEntity<Zapato> getZapato(@PathVariable String nombre) {
        Zapato response = zapatoservice.getZapato(nombre);
        return ResponseEntity.ok().body(response);
    }



    
    
}


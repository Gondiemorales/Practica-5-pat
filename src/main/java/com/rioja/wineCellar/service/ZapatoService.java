package com.rioja.wineCellar.service;

import com.rioja.wineCellar.model.Zapato;

public interface ZapatoService {
    Iterable<Zapato> getZapatos();
    Zapato getZapato(String zapato);
}

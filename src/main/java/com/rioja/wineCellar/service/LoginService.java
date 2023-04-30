package com.rioja.wineCellar.service;

import com.rioja.wineCellar.model.Usuario;

public interface LoginService {

    Iterable<Usuario> getUsuarios();
    Usuario getUsuario(String nombre);
    void createUsuario(Usuario usuario);
    void deleteUsuario(String name);
   
    
}

package com.rioja.wineCellar.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rioja.wineCellar.model.Usuario;
import com.rioja.wineCellar.repository.Loginrepository;
import com.rioja.wineCellar.service.LoginService;


@Service
public class Loginimplementation implements LoginService  {

    @Autowired
    private Loginrepository loginrepository;


    @Override
    public Iterable<Usuario> getUsuarios(){

        return loginrepository.findAll();

    }

    @Override
    public Usuario getUsuario(String nombre){
        Usuario response = null;
        if (loginrepository.existsById(nombre)) {
            Iterable<Usuario> users = loginrepository.getUsuario(nombre);
            for (Usuario u : users) {
                response = u;
            }
            return response;
        }
        return response;
    }

    @Override
    public void createUsuario(Usuario usuario){
        loginrepository.createUsuario(usuario.getUsername(), usuario.getPassword());
    }

    @Override
    public void deleteUsuario(String nombre){
        loginrepository.deleteById(nombre);
    }

  


    


 
   

}

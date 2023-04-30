package com.rioja.wineCellar.repository;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rioja.wineCellar.model.Usuario;

public interface Loginrepository extends CrudRepository <Usuario, String> {

    @Query("SELECT * FROM USERS WHERE USERS.USERNAME= :usuario")
    public Iterable<Usuario> getUsuario(String usuario);

    @Modifying
    @Query("INSERT INTO USERS (USERNAME, PASSWORD) VALUES (:username, :password)")
    void createUsuario(@Param("username") String username, @Param("password") String password);

    


    

}


package com.rioja.wineCellar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rioja.wineCellar.model.Usuario;
import com.rioja.wineCellar.service.LoginService;

@RestController
//@RequestMapping("/api/v1")
public class LoginController {

    @Autowired
    private LoginService loginservice;

    @GetMapping("/Usuarios")
    public ResponseEntity<Iterable<Usuario>> getUsuarios(@RequestParam(required=false) String nombre){

        Iterable<Usuario> response = loginservice.getUsuarios();
        return ResponseEntity.ok().body(response);


    }

    @GetMapping("/Usuarios/{nombre}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable String nombre) {
        Usuario response = loginservice.getUsuario(nombre);
        return ResponseEntity.ok().body(response);
    }


    @PostMapping("/Usuarios")
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        
        Usuario response = loginservice.getUsuario(usuario.getUsername());
        if(response==null){
            loginservice.createUsuario(usuario);
            return ResponseEntity.ok().body(usuario);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        
        
   
    }
    

    @DeleteMapping("/Usuarios/{nombre}")
    public ResponseEntity<Usuario> deleteUsuario(@PathVariable String nombre) {
        loginservice.deleteUsuario(nombre);
        return ResponseEntity.noContent().build();
    }

    
    
}


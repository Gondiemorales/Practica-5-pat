package com.rioja.wineCellar.controller;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.rioja.wineCellar.model.Usuario;
import com.rioja.wineCellar.repository.Loginrepository;

import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class LoginE2ETest {
    @LocalServerPort
    private int port;

    @Autowired
    private Loginrepository loginrepository;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void usersGetTest(){
        Iterable<Usuario> usuarios = loginrepository.findAll();
        String url = "http://localhost:" + Integer.toString(port) + "/Usuarios";
        HttpHeaders headers = new org.springframework.http.HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity <Iterable<Usuario>> result = restTemplate.exchange(
            url, 
            HttpMethod.GET, 
            entity, 
            new ParameterizedTypeReference<Iterable<Usuario>>() {}
            );

            then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
            then(result.getBody()).isEqualTo(usuarios);
    
    
    }



    @Test
    public void userGetTest(){
        
        Usuario user = new Usuario("Pablo", "123");

        String url = "http://localhost:" + Integer.toString(port) + "/Usuarios/" + user.getUsername();
        HttpHeaders headers = new org.springframework.http.HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(user.getUsername(), headers);

        ResponseEntity <Usuario> result = restTemplate.exchange(
            url, 
            HttpMethod.GET, 
            entity, 
            new ParameterizedTypeReference<Usuario>() {}
            );

        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result.getBody()).isEqualTo(user);
    
    
    }

    @Test
    public void userGetTestMalo(){
        
        Usuario user = new Usuario("Gonzalo", "123");

        String url = "http://localhost:" + Integer.toString(port) + "/Usuarios/" + user.getUsername();
        HttpHeaders headers = new org.springframework.http.HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(user.getUsername(), headers);

        ResponseEntity <Usuario> result = restTemplate.exchange(
            url, 
            HttpMethod.GET, 
            entity, 
            new ParameterizedTypeReference<Usuario>() {}
            );

        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result.getBody()).isEqualTo(null);
    
    
    }



    @Test
    public void userPostTest(){

        Usuario user = new Usuario("Alberto", "123");

        String url = "http://localhost:" + Integer.toString(port) + "/Usuarios";
        HttpHeaders headers = new org.springframework.http.HttpHeaders();
        HttpEntity<Usuario> entity = new HttpEntity<>(user, headers);

        ResponseEntity <Usuario> result = restTemplate.exchange(
            url, 
            HttpMethod.POST, 
            entity, 
            new ParameterizedTypeReference<Usuario>() {}
            );

        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result.getBody()).isEqualTo(user);
    


    }

    @Test
    public void userPostTestMalo(){

        Usuario user = new Usuario("Pablo", "123");

        String url = "http://localhost:" + Integer.toString(port) + "/Usuarios";
        HttpHeaders headers = new org.springframework.http.HttpHeaders();
        HttpEntity<Usuario> entity = new HttpEntity<>(user, headers);

        ResponseEntity <Usuario> result = restTemplate.exchange(
            url, 
            HttpMethod.POST, 
            entity, 
            new ParameterizedTypeReference<Usuario>() {}
            );

        then(result.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        then(result.getBody()).isEqualTo(null);
    


    }




}

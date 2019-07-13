package com.gym.controller;

import com.gym.dto.ClientDto;
import com.gym.entity.Client;
import com.gym.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(value = "/id/{id}")
    ResponseEntity<Client> findById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(clientService.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/")
    ResponseEntity<List<Client>> findAll(){
        return new ResponseEntity<>(clientService.findAll(), HttpStatus.OK); }

    @DeleteMapping(value = "/{id}")
    ResponseEntity<Void> deleteById(@RequestParam("id") Integer id){
        clientService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/name/{name}")
    ResponseEntity<List<Client>> findByName(@PathVariable("name") String name){
        return new ResponseEntity<>(clientService.findByName(name), HttpStatus.OK);
    }

    @GetMapping(value = "/login/{login}")
    ResponseEntity<Client> findByLogin(@PathVariable("login") String login){
        return new ResponseEntity<>(clientService.findByLogin(login), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<Client> save(@Validated @RequestBody ClientDto clientDto){
        return new ResponseEntity<>(clientService.save(clientDto), HttpStatus.CREATED);
    }






}

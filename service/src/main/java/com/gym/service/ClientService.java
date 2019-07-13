package com.gym.service;

import com.gym.dto.ClientDto;
import com.gym.entity.Client;

import java.util.List;

public interface ClientService {

    List<Client> findAll();

    Client findById(Integer id);

    List<Client> findByName(String name);

    Client findByLogin(String login);

    void deleteById(Integer id);

    Client save(ClientDto clientDto);


}

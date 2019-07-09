package com.gym.service;

import com.gym.dto.ClientDto;

import java.util.List;

public interface ClientService {

    List<ClientDto> findAll();

    ClientDto findById(Integer id);

    List<ClientDto> findByName(String name);

    ClientDto findByLogin(String login);

    void deleteById(Integer id);

    ClientDto save(ClientDto clientDto);


}

package com.gym.service.impl;

import com.gym.convertors.ClientConvert;
import com.gym.convertors.OfficeConvert;
import com.gym.dto.ClientDto;
import com.gym.entity.Client;
import com.gym.myException.ClientNotFoundException;
import com.gym.service.ClientService;
import com.gym.repository.ClientRepository;
import com.gym.validate.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    private final ClientConvert clientConvert;

    private final OfficeServiceImpl officeService;

    private final OfficeConvert officeConvert;


    private final Validate validate;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, ClientConvert clientConvert, OfficeServiceImpl officeService, OfficeConvert officeConvert, Validate validate) {
        this.clientRepository = clientRepository;
        this.clientConvert = clientConvert;
        this.officeService = officeService;
        this.officeConvert = officeConvert;
        this.validate = validate;
    }

    @Override
    public List<ClientDto> findAll() {
        return clientRepository.findAll()
                .stream()
                .map(clientConvert::convert)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDto findById(Integer id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()){
            return clientConvert.convert(optionalClient.get());
        }
        throw new ClientNotFoundException("No such client");
    }

    @Override
    public List<ClientDto> findByName(String name) {
        return clientRepository.findByName(name)
                .stream()
                .map(clientConvert::convert)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDto findByLogin(String login) {
        return clientConvert.convert(clientRepository.findByLogin(login));
    }

    @Override
    public void deleteById(Integer id) {
        this.findById(id);
        clientRepository.deleteById(id);

    }

    @Override
    public ClientDto save(ClientDto clientDto) {

        if (!validate.correctPhoneNumber(clientDto.getPhoneNumber())) {
            throw new IllegalArgumentException("This is not phoneNumber");
        }
        Client client = clientConvert.convert(clientDto);
        client.setOffice(officeConvert.convert(officeService.findById(clientDto.getOfficeId())));
        return clientConvert.convert(clientRepository.save(client)) ;
    }
}

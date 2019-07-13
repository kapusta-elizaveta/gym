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
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(Integer id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()){
            return optionalClient.get();
        }
        throw new ClientNotFoundException("No such client");
    }

    @Override
    public List<Client> findByName(String name) {
        return clientRepository.findByName(name);
    }

    @Override
    public Client findByLogin(String login) {

        return clientRepository.findByLogin(login);
    }

    @Override
    public void deleteById(Integer id) {
        this.findById(id);
        clientRepository.deleteById(id);

    }

    @Override
    public Client save(ClientDto clientDto) {

        if (!validate.correctPhoneNumber(clientDto.getPhoneNumber())) {
            throw new IllegalArgumentException("This is not phoneNumber");
        }
        Client client = clientConvert.convert(clientDto);
        client.setOffice(officeService.findById(clientDto.getOfficeId()));
        return clientRepository.save(client) ;
    }
}

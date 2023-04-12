package com.project.project_web_service_bank_system.service.impl;

import com.project.project_web_service_bank_system.adapter.repository.ClientRepository;
import com.project.project_web_service_bank_system.domain.dto.request.CreateClientRequest;
import com.project.project_web_service_bank_system.domain.dto.response.ClientResponse;
import com.project.project_web_service_bank_system.domain.entity.Client;
import com.project.project_web_service_bank_system.domain.entity.context.ClientContext;
import com.project.project_web_service_bank_system.service.ClientService;
import com.project.project_web_service_bank_system.service.factory.ClientFactory;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;


import java.util.List;

import static lombok.AccessLevel.PRIVATE;


@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class ClientServiceImpl implements ClientService {

    ClientRepository clientRepository;
    ClientFactory clientFactory;


    @Override
    public ClientResponse addNewClient(CreateClientRequest clientRequest) {
        ClientContext clientContext = clientFactory.createContext(clientRequest);
        Client client = Client.createClient(clientContext);
        Client clientEntity = clientRepository.save(client);
        return clientFactory.createClientResponse(clientEntity);
    }

    @Override
    public List<ClientResponse> readAllClients() {
        List<Client> clientList = clientRepository.findAll();
        return clientFactory.createListClientResponse(clientList);
    }
}

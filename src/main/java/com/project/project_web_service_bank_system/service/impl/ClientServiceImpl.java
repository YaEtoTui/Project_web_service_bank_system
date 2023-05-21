package com.project.project_web_service_bank_system.service.impl;

import com.project.project_web_service_bank_system.adapter.repository.ClientRepository;
import com.project.project_web_service_bank_system.domain.dto.request.CreateClientRequest;
import com.project.project_web_service_bank_system.domain.dto.response.ClientResponse;
import com.project.project_web_service_bank_system.domain.entity.Client;
import com.project.project_web_service_bank_system.domain.entity.context.ClientContext;
import com.project.project_web_service_bank_system.service.ClientService;
import com.project.project_web_service_bank_system.service.factory.ClientFactory;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
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
        Client client = new Client(clientContext);
        Client clientEntity = clientRepository.save(client);
        return clientFactory.createClientResponse(clientEntity);
    }

    @Override
    public List<ClientResponse> readAllClients() {
        List<Client> clientList = clientRepository.findAll();
        return clientFactory.createListClientResponse(clientList);
    }

    @Async
    @Scheduled(fixedRate = 60000)
    @SneakyThrows
    public void checkCommand() {
        long startAt = System.currentTimeMillis();
        readAllClients();
        long time = System.currentTimeMillis() - startAt;
        System.out.printf("Method called: 'readAllClients'. Time: '%s' ms \n", time);
    }
}

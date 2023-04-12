package com.project.project_web_service_bank_system.service;


import com.project.project_web_service_bank_system.domain.dto.request.CreateClientRequest;
import com.project.project_web_service_bank_system.domain.dto.response.ClientResponse;

import java.util.List;

public interface ClientService {
    ClientResponse addNewClient(CreateClientRequest clientRequest);
    List<ClientResponse> readAllClients();
}

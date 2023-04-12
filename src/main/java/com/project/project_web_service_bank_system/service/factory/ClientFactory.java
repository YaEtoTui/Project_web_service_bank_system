package com.project.project_web_service_bank_system.service.factory;

import com.project.project_web_service_bank_system.domain.dto.request.CreateClientRequest;
import com.project.project_web_service_bank_system.domain.dto.response.ClientResponse;
import com.project.project_web_service_bank_system.domain.entity.Client;
import com.project.project_web_service_bank_system.domain.entity.context.ClientContext;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ClientFactory {
    public ClientResponse createClientResponse(Client client) {
        return new ClientResponse(
                client.getId(),
                client.getName(),
                client.getAge()
        );
    }

    public List<ClientResponse> createListClientResponse(List<Client> clientList) {
        return clientList.stream()
                .map(this::createClientResponse)
                .toList();
    }

    public ClientContext createContext(CreateClientRequest requestClient) {
        return new ClientContext(requestClient.getName(), requestClient.getAge());
    }
}

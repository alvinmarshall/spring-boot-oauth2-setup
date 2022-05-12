package com.cheise_proj.authservice.domain.service;

import com.cheise_proj.authservice.domain.model.CustomClientDetail;
import com.cheise_proj.authservice.domain.repository.ClientRepository;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

@Service
public class CustomClientDetailService implements ClientDetailsService {
    private final ClientRepository clientRepository;

    public CustomClientDetailService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDetails loadClientByClientId(String s) throws ClientRegistrationException {
        return clientRepository.findClientByClientId(s)
                .map(CustomClientDetail::new)
                .orElseThrow(() -> new ClientRegistrationException("client with " + s + " is not available"));
    }
}

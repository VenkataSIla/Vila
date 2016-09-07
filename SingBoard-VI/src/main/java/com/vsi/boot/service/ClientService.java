package com.vsi.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsi.boot.domain.Client;
import com.vsi.boot.repository.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;
    
    ///Client
    
    public List<Client> findAllClient(){
        return (List<Client>) clientRepository.findAll();
    }
    
    public Client findClientById(Long shopId){
        return  clientRepository.findOne(shopId);
    }
    
    public Client saveClient(Client client){
        return  clientRepository.save(client);
    }

}

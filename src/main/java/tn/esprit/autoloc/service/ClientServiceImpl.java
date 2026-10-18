package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.repository.ClientRepository;

import java.util.List;

@Service
public class ClientServiceImpl implements IclientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client getById(long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public Boolean update(Client c) {
        clientRepository.save(c);
        return true;
    }

    @Override
    public Boolean remove(Client c) {
        clientRepository.delete(c);
        return true;
    }

    @Override
    public Client addcli(Client c) {
        return clientRepository.save(c);
    }
}

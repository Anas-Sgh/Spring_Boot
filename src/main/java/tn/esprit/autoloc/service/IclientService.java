package tn.esprit.autoloc.service;


import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.repository.ClientRepository;

import java.util.List;

public interface IclientService extends ClientRepository {
    Client getById(long id);
    List<Client> getAll();
    Boolean update(Client c);
    Boolean remove(Client c);
    Client addcli(Client c);
}

package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Client;

import java.util.List;

public interface IclientService {
    Client getById(long id);
    List<Client> getAll();
    Boolean update(Client c);
    Boolean remove(Client c);
    Client addcli(Client c);
}

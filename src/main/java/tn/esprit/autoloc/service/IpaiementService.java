package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.repository.PaiementRepository;

import java.util.List;

public interface IpaiementService extends PaiementRepository {
    Paiement getById(long id);
    List<Paiement> getAll();
    Boolean update(Paiement p);
    Boolean remove(Paiement p);
    Paiement addp(Paiement p);
}

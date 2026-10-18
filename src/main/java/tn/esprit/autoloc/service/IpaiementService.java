package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Paiement;

import java.util.List;

public interface IpaiementService {
    Paiement getById(long id);
    List<Paiement> getAll();
    Boolean update(Paiement p);
    Boolean remove(Paiement p);
    Paiement addp(Paiement p);
}

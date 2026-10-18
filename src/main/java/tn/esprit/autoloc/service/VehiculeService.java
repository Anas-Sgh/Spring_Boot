package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Vehicule;

import java.util.List;

public interface VehiculeService {
    Vehicule getById(long id);
    List<Vehicule> getAll();
    Boolean update(Vehicule v);
    Boolean remove(Vehicule v);
    Vehicule addv(Vehicule v);
}

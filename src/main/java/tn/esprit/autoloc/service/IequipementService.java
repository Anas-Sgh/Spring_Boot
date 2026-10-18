package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Equipement;

import java.util.List;

public interface IequipementService {
    Equipement getById(long id);
    List<Equipement> getAll();
    Boolean update(Equipement e);
    Boolean remove(Equipement e);
    Equipement addeq(Equipement e);
}

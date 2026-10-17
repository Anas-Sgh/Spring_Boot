package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.repository.EquipementRepository;

import java.util.List;

public interface IequipementService extends EquipementRepository {
    Equipement getById(long id);
    List<Equipement> getAll();
    Boolean update(Equipement e);
    Boolean remove(Equipement e);
    Equipement addeq(Equipement e);
}

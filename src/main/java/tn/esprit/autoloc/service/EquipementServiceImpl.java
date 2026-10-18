package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.repository.EquipementRepository;

import java.util.List;

@Service
public class EquipementServiceImpl implements IequipementService {

    private final EquipementRepository equipementRepository;

    public EquipementServiceImpl(EquipementRepository equipementRepository) {
        this.equipementRepository = equipementRepository;
    }

    @Override
    public Equipement getById(long id) {
        return equipementRepository.findById(id).orElse(null);
    }

    @Override
    public List<Equipement> getAll() {
        return equipementRepository.findAll();
    }

    @Override
    public Boolean update(Equipement e) {
        equipementRepository.save(e);
        return true;
    }

    @Override
    public Boolean remove(Equipement e) {
        equipementRepository.delete(e);
        return true;
    }

    @Override
    public Equipement addeq(Equipement e) {
        return equipementRepository.save(e);
    }
}

package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.util.List;

@Service
public class VehiculeServiceImpl implements VehiculeService {

    private final VehiculeRepository vehiculeRepository;

    public VehiculeServiceImpl(VehiculeRepository vehiculeRepository) {
        this.vehiculeRepository = vehiculeRepository;
    }

    @Override
    public Vehicule getById(long id) {
        return vehiculeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Vehicule> getAll() {
        return vehiculeRepository.findAll();
    }

    @Override
    public Boolean update(Vehicule v) {
        vehiculeRepository.save(v);
        return true;
    }

    @Override
    public Boolean remove(Vehicule v) {
        vehiculeRepository.delete(v);
        return true;
    }

    @Override
    public Vehicule addv(Vehicule v) {
        return vehiculeRepository.save(v);
    }
}

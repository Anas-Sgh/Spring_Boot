package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.repository.MaintenanceRepository;

import java.util.List;

@Service
public class MaintenanceServiceImpl implements ImaintenanceService {

    private final MaintenanceRepository maintenanceRepository;

    public MaintenanceServiceImpl(MaintenanceRepository maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
    }

    @Override
    public Maintenance getById(long id) {
        return maintenanceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Maintenance> getAll() {
        return maintenanceRepository.findAll();
    }

    @Override
    public Boolean update(Maintenance m) {
        maintenanceRepository.save(m);
        return true;
    }

    @Override
    public Boolean remove(Maintenance m) {
        maintenanceRepository.delete(m);
        return true;
    }

    @Override
    public Maintenance addm(Maintenance m) {
        return maintenanceRepository.save(m);
    }
}

package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.repository.MaintenanceRepository;

import java.util.List;

public interface ImaintenanceService extends MaintenanceRepository {
    Maintenance getById(long id);
    List<Maintenance> getAll();
    Boolean update(Maintenance m);
    Boolean remove(Maintenance m);
    Maintenance addm(Maintenance m);
}

package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Maintenance;

import java.util.List;

public interface ImaintenanceService {
    Maintenance getById(long id);
    List<Maintenance> getAll();
    Boolean update(Maintenance m);
    Boolean remove(Maintenance m);
    Maintenance addm(Maintenance m);
}

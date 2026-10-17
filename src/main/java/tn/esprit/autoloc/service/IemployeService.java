package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.repository.EmployeRepository;

import java.util.List;

public interface IemployeService extends EmployeRepository{
    Employe getById(long id);
    List<Employe> getAll();
    Boolean update(Employe e);
    Boolean remove(Employe e);
    Employe addemp(Employe e);
}

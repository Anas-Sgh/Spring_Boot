package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Employe;

import java.util.List;

public interface IemployeService {
    Employe getById(long id);
    List<Employe> getAll();
    Boolean update(Employe e);
    Boolean remove(Employe e);
    Employe addemp(Employe e);
}

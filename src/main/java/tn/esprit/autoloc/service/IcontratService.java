package tn.esprit.autoloc.service;

import java.util.List;
import tn.esprit.autoloc.domain.Contrat;

public interface IcontratService {
    Contrat create(Contrat contrat);
    Contrat findByid(Long id);
    List<Contrat> findAll();
    Contrat update(Long id, Contrat contrat);
    void deleteById(Long id);
}

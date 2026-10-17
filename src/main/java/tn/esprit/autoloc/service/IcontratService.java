package tn.esprit.autoloc.service;
import java.util.List;
import java.util.Optional;

import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.repository.ContratRepository;

public interface IcontratService extends ContratRepository {
    Contrat create(Contrat contrat);
    Contrat findByid(Long id);
    List<Contrat> findAll();
    Contrat update(Long id, Contrat contrat);
    void deleteById(Long id);
}

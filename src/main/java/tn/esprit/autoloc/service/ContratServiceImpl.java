package tn.esprit.autoloc.service;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.exception.ResourceNotFoundException;
import tn.esprit.autoloc.repository.ContratRepository;


@Service
public class ContratServiceImpl implements IcontratService {

    @Autowired
    private ContratRepository contratRepository;

    @Override
    public Contrat create(Contrat contrat) {
        if (contrat.getIdContrat() != null) {
            throw new IllegalArgumentException("Un nouveau contrat ne doit pas avoir d'identifiant");
        }
        return contratRepository.save(contrat);
    }

    @Override
    public Contrat findByid(Long id) {
        return contratRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Contrat", id));
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public <S extends Contrat> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Contrat> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Contrat> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<Contrat> findAll() {
        return contratRepository.findAll();
    }

    @Override
    public List<Contrat> findAllById(Iterable<Long> longs) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public Contrat update(Long id, Contrat contrat) {
        Contrat existant = findByid(id);
        existant.setMontantTotal(contrat.getMontantTotal());
        // recopier ici les autres attributs modifiables du contrat (Atelier 2),
        // sans toucher à l'identifiant ni à la collection de paiements
        return contratRepository.save(existant);
    }
    @Override
    public void deleteById(Long id) {
        if (!contratRepository.existsById(id)) {
            throw new ResourceNotFoundException("Contrat", id);
        }
        contratRepository.deleteById(id);
    }

    @Override
    public void delete(Contrat entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Contrat> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Contrat> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Contrat> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Contrat> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Contrat getOne(Long aLong) {
        return null;
    }

    @Override
    public Contrat getById(Long aLong) {
        return null;
    }

    @Override
    public Contrat getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Contrat> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Contrat> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Contrat> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Contrat> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Contrat> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Contrat> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Contrat, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public List<Contrat> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Contrat> findAll(Pageable pageable) {
        return null;
    }
}
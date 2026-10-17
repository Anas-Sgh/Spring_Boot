package tn.esprit.autoloc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.repository.PaiementRepository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class PaiementServiceImpl implements IpaiementService{

    @Autowired
    private PaiementRepository paiementRepository;

    @Override
    public Paiement getById(long id) {
        return paiementRepository.findById(id).orElse(null);
    }

    @Override
    public List<Paiement> getAll() {
        return paiementRepository.findAll();
    }

    @Override
    public Boolean update(Paiement p) {
        paiementRepository.save(p);
        return true;
    }

    @Override
    public Boolean remove(Paiement p) {
        paiementRepository.delete(p);
        return true;
    }

    @Override
    public Paiement addp(Paiement p) {
        return paiementRepository.save(p);
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Paiement> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Paiement> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Paiement> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Paiement getOne(Long aLong) {
        return null;
    }

    @Override
    public Paiement getById(Long aLong) {
        return null;
    }

    @Override
    public Paiement getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Paiement> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Paiement> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Paiement> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Paiement> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Paiement> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Paiement> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Paiement, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Paiement> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Paiement> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Paiement> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Paiement> findAll() {
        return List.of();
    }

    @Override
    public List<Paiement> findAllById(Iterable<Long> longs) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Paiement entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Paiement> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Paiement> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Paiement> findAll(Pageable pageable) {
        return null;
    }
}

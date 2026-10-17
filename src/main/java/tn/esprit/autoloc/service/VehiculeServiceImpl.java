package tn.esprit.autoloc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class VehiculeServiceImpl implements VehiculeService {

    @Autowired
    private VehiculeRepository vehiculeRepository;

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

    public Boolean remove(Vehicule v) {
        vehiculeRepository.delete(v);
        return true;
    }

    public Vehicule addv(Vehicule v) {
        return vehiculeRepository.save(v);
    }

    @Override
    public void flush() {
    }

    @Override
    public <S extends Vehicule> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Vehicule> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Vehicule> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Vehicule getOne(Long aLong) {
        return null;
    }

    @Override
    public Vehicule getById(Long aLong) {
        return null;
    }

    @Override
    public Vehicule getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Vehicule> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Vehicule> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Vehicule> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Vehicule> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Vehicule> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Vehicule> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Vehicule, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Vehicule> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Vehicule> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Vehicule> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Vehicule> findAll() {
        return List.of();
    }

    @Override
    public List<Vehicule> findAllById(Iterable<Long> longs) {
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
    public void delete(Vehicule entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Vehicule> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Vehicule> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Vehicule> findAll(Pageable pageable) {
        return null;
    }
}

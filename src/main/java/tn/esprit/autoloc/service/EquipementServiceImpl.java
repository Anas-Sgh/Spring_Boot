package tn.esprit.autoloc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.repository.EquipementRepository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class EquipementServiceImpl implements IequipementService{

    @Autowired
    private EquipementRepository equipementRepository;

    @Override
    public Equipement getById(long id) {
        return equipementRepository.findById(id).orElse(null);
    }

    @Override
    public List<Equipement> getAll() {
        return equipementRepository.findAll();
    }

    @Override
    public Boolean update(Equipement e) {
        equipementRepository.save(e);
        return true;
    }

    @Override
    public Boolean remove(Equipement e) {
        equipementRepository.delete(e);
        return false;
    }

    @Override
    public Equipement addeq(Equipement e) {
        return equipementRepository.save(e);
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Equipement> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Equipement> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Equipement> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Equipement getOne(Long aLong) {
        return null;
    }

    @Override
    public Equipement getById(Long aLong) {
        return null;
    }

    @Override
    public Equipement getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Equipement> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Equipement> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Equipement> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Equipement> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Equipement> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Equipement> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Equipement, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Equipement> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Equipement> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Equipement> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Equipement> findAll() {
        return List.of();
    }

    @Override
    public List<Equipement> findAllById(Iterable<Long> longs) {
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
    public void delete(Equipement entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Equipement> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Equipement> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Equipement> findAll(Pageable pageable) {
        return null;
    }
}

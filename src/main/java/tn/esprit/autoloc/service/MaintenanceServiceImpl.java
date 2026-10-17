package tn.esprit.autoloc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.repository.MaintenanceRepository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class MaintenanceServiceImpl implements ImaintenanceService{

    @Autowired
    private MaintenanceRepository maintenanceRepository;

    @Override
    public Maintenance getById(long id) {
        return maintenanceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Maintenance> getAll() {
       return maintenanceRepository.findAll();
    }

    @Override
    public Boolean update(Maintenance m) {
        maintenanceRepository.save(m);
        return true;
    }

    @Override
    public Boolean remove(Maintenance m) {
        maintenanceRepository.delete(m);
        return true;
    }

    @Override
    public Maintenance addm(Maintenance m) {
        return maintenanceRepository.save(m);
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Maintenance> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Maintenance> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Maintenance> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Maintenance getOne(Long aLong) {
        return null;
    }

    @Override
    public Maintenance getById(Long aLong) {
        return null;
    }

    @Override
    public Maintenance getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Maintenance> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Maintenance> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Maintenance> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Maintenance> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Maintenance> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Maintenance> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Maintenance, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Maintenance> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Maintenance> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Maintenance> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Maintenance> findAll() {
        return List.of();
    }

    @Override
    public List<Maintenance> findAllById(Iterable<Long> longs) {
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
    public void delete(Maintenance entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Maintenance> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Maintenance> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Maintenance> findAll(Pageable pageable) {
        return null;
    }
}

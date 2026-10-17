package tn.esprit.autoloc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.repository.EmployeRepository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class EmployeServiceImpl implements IemployeService{

    @Autowired
    private EmployeRepository employeRepository;

    @Override
    public Employe getById(long id) {
        return employeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employe> getAll() {
        return employeRepository.findAll();
    }

    @Override
    public Boolean update(Employe e) {
        employeRepository.save(e);
        return true;
    }

    @Override
    public Boolean remove(Employe e) {
        employeRepository.delete(e);
        return true;
    }

    @Override
    public Employe addemp(Employe e) {
        return employeRepository.save(e);
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Employe> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Employe> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Employe> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Employe getOne(Long aLong) {
        return null;
    }

    @Override
    public Employe getById(Long aLong) {
        return null;
    }

    @Override
    public Employe getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Employe> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Employe> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Employe> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Employe> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Employe> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Employe> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Employe, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Employe> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Employe> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Employe> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Employe> findAll() {
        return List.of();
    }

    @Override
    public List<Employe> findAllById(Iterable<Long> longs) {
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
    public void delete(Employe entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Employe> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Employe> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Employe> findAll(Pageable pageable) {
        return null;
    }
}

package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.repository.EmployeRepository;

import java.util.List;

@Service
public class EmployeServiceImpl implements IemployeService {

    private final EmployeRepository employeRepository;

    public EmployeServiceImpl(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
    }

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
}

package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.repository.ReservationRepository;

import java.util.List;

@Service
public class ReservationServiceImpl implements IreservationService {

    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Reservation getById(long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Boolean update(Reservation r) {
        reservationRepository.save(r);
        return true;
    }

    @Override
    public Boolean remove(Reservation r) {
        reservationRepository.delete(r);
        return true;
    }

    @Override
    public Reservation addre(Reservation r) {
        return reservationRepository.save(r);
    }
}

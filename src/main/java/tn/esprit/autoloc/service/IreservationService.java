package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.repository.ReservationRepository;

import java.util.List;

public interface IreservationService extends ReservationRepository {
    Reservation getById(long id);
    List<Reservation> getAll();
    Boolean update(Reservation r);
    Boolean remove(Reservation r);
    Reservation addre(Reservation r);
}

package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Reservation;

import java.util.List;

public interface IreservationService {
    Reservation getById(long id);
    List<Reservation> getAll();
    Boolean update(Reservation r);
    Boolean remove(Reservation r);
    Reservation addre(Reservation r);
}

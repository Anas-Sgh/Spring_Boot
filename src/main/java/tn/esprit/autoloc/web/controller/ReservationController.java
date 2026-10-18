package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.exception.ResourceNotFoundException;
import tn.esprit.autoloc.service.IreservationService;

import java.util.List;

@Tag(name = "Réservations", description = "Gestion des réservations")
@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final IreservationService reservationService;

    @Operation(summary = "Lister toutes les réservations", description = "Récupère la liste complète des réservations enregistrées")
    @ApiResponse(responseCode = "200", description = "Liste des réservations récupérée avec succès")
    @GetMapping
    public List<Reservation> findAll() {
        return reservationService.getAll();
    }

    @Operation(summary = "Consulter une réservation", description = "Recherche et renvoie une réservation par son identifiant")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Réservation trouvée"),
            @ApiResponse(responseCode = "404", description = "Réservation introuvable")
    })
    @GetMapping("/{id}")
    public Reservation findById(
            @Parameter(description = "Identifiant unique de la réservation", required = true, example = "1")
            @PathVariable Long id) {
        Reservation reservation = reservationService.getById(id);
        if (reservation == null) {
            throw new ResourceNotFoundException("Reservation", id);
        }
        return reservation;
    }

    @Operation(summary = "Créer une réservation", description = "Enregistre une nouvelle réservation")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Réservation créée avec succès"),
            @ApiResponse(responseCode = "400", description = "Données fournies invalides")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation create(@RequestBody Reservation reservation) {
        return reservationService.addre(reservation);
    }

    @Operation(summary = "Modifier une réservation", description = "Met à jour les informations d'une réservation existante")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Réservation mise à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "Réservation introuvable"),
            @ApiResponse(responseCode = "400", description = "Données fournies invalides")
    })
    @PutMapping("/{id}")
    public Reservation update(
            @Parameter(description = "Identifiant de la réservation à mettre à jour", required = true, example = "1")
            @PathVariable Long id,
            @RequestBody Reservation reservation) {
        Reservation existing = reservationService.getById(id);
        if (existing == null) {
            throw new ResourceNotFoundException("Reservation", id);
        }
        reservation.setIdReservation(id);
        reservationService.update(reservation);
        return reservation;
    }

    @Operation(summary = "Supprimer une réservation", description = "Supprime une réservation existante à partir de son identifiant")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Réservation supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "Réservation introuvable")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(
            @Parameter(description = "Identifiant de la réservation à supprimer", required = true, example = "1")
            @PathVariable Long id) {
        Reservation existing = reservationService.getById(id);
        if (existing == null) {
            throw new ResourceNotFoundException("Reservation", id);
        }
        reservationService.remove(existing);
    }
}

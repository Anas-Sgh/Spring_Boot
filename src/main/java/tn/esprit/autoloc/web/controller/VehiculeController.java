package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.exception.ResourceNotFoundException;
import tn.esprit.autoloc.service.VehiculeService;

import java.util.List;

@Tag(name = "Véhicules", description = "Gestion du parc de véhicules")
@RestController
@RequestMapping("/vehicules")
@RequiredArgsConstructor
public class VehiculeController {

    private final VehiculeService vehiculeService;

    @Operation(summary = "Lister tous les véhicules", description = "Récupère la liste complète des véhicules du parc")
    @ApiResponse(responseCode = "200", description = "Liste des véhicules récupérée avec succès")
    @GetMapping
    public List<Vehicule> findAll() {
        return vehiculeService.getAll();
    }

    @Operation(summary = "Consulter un véhicule", description = "Recherche et renvoie un véhicule par son identifiant")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Véhicule trouvé"),
            @ApiResponse(responseCode = "404", description = "Véhicule introuvable")
    })
    @GetMapping("/{id}")
    public Vehicule findById(
            @Parameter(description = "Identifiant unique du véhicule", required = true, example = "1")
            @PathVariable Long id) {
        Vehicule vehicule = vehiculeService.getById(id);
        if (vehicule == null) {
            throw new ResourceNotFoundException("Vehicule", id);
        }
        return vehicule;
    }

    @Operation(summary = "Créer un véhicule", description = "Enregistre un nouveau véhicule dans le parc")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Véhicule créé avec succès"),
            @ApiResponse(responseCode = "400", description = "Données fournies invalides")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vehicule create(@RequestBody Vehicule vehicule) {
        return vehiculeService.addv(vehicule);
    }

    @Operation(summary = "Modifier un véhicule", description = "Met à jour les informations d'un véhicule existant")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Véhicule mis à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "Véhicule introuvable"),
            @ApiResponse(responseCode = "400", description = "Données fournies invalides")
    })
    @PutMapping("/{id}")
    public Vehicule update(
            @Parameter(description = "Identifiant du véhicule à mettre à jour", required = true, example = "1")
            @PathVariable Long id,
            @RequestBody Vehicule vehicule) {
        Vehicule existing = vehiculeService.getById(id);
        if (existing == null) {
            throw new ResourceNotFoundException("Vehicule", id);
        }
        vehicule.setIdVehicule(id);
        vehiculeService.update(vehicule);
        return vehicule;
    }

    @Operation(summary = "Supprimer un véhicule", description = "Supprime un véhicule existant à partir de son identifiant")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Véhicule supprimé avec succès"),
            @ApiResponse(responseCode = "404", description = "Véhicule introuvable")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(
            @Parameter(description = "Identifiant du véhicule à supprimer", required = true, example = "1")
            @PathVariable Long id) {
        Vehicule existing = vehiculeService.getById(id);
        if (existing == null) {
            throw new ResourceNotFoundException("Vehicule", id);
        }
        vehiculeService.remove(existing);
    }
}

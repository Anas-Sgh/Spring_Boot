package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.exception.ResourceNotFoundException;
import tn.esprit.autoloc.service.IequipementService;

import java.util.List;

@Tag(name = "Equipements", description = "Gestion des équipements")
@RestController
@RequestMapping("/equipements")
@RequiredArgsConstructor
public class EquipementController {

    private final IequipementService equipementService;

    @Operation(summary = "Lister tous les équipements", description = "Récupère la liste complète des équipements enregistrés")
    @ApiResponse(responseCode = "200", description = "Liste des équipements récupérée avec succès")
    @GetMapping
    public List<Equipement> findAll() {
        return equipementService.getAll();
    }

    @Operation(summary = "Consulter un équipement", description = "Recherche et renvoie un équipement par son identifiant")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Equipement trouvé"),
            @ApiResponse(responseCode = "404", description = "Equipement introuvable")
    })
    @GetMapping("/{id}")
    public Equipement findById(
            @Parameter(description = "Identifiant unique de l'équipement", required = true, example = "1")
            @PathVariable Long id) {
        Equipement equipement = equipementService.getById(id);
        if (equipement == null) {
            throw new ResourceNotFoundException("Equipement", id);
        }
        return equipement;
    }

    @Operation(summary = "Créer un équipement", description = "Enregistre un nouvel équipement")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Equipement créé avec succès"),
            @ApiResponse(responseCode = "400", description = "Données fournies invalides")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Equipement create(@RequestBody Equipement equipement) {
        return equipementService.addeq(equipement);
    }

    @Operation(summary = "Modifier un équipement", description = "Met à jour les informations d'un équipement existant")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Equipement mis à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "Equipement introuvable"),
            @ApiResponse(responseCode = "400", description = "Données fournies invalides")
    })
    @PutMapping("/{id}")
    public Equipement update(
            @Parameter(description = "Identifiant de l'équipement à mettre à jour", required = true, example = "1")
            @PathVariable Long id,
            @RequestBody Equipement equipement) {
        Equipement existing = equipementService.getById(id);
        if (existing == null) {
            throw new ResourceNotFoundException("Equipement", id);
        }
        equipement.setIdEquipement(id);
        equipementService.update(equipement);
        return equipement;
    }

    @Operation(summary = "Supprimer un équipement", description = "Supprime un équipement existant à partir de son identifiant")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Equipement supprimé avec succès"),
            @ApiResponse(responseCode = "404", description = "Equipement introuvable")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(
            @Parameter(description = "Identifiant de l'équipement à supprimer", required = true, example = "1")
            @PathVariable Long id) {
        Equipement existing = equipementService.getById(id);
        if (existing == null) {
            throw new ResourceNotFoundException("Equipement", id);
        }
        equipementService.remove(existing);
    }
}

package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.exception.ResourceNotFoundException;
import tn.esprit.autoloc.service.ImaintenanceService;

import java.util.List;

@Tag(name = "Maintenances", description = "Gestion des opérations de maintenance")
@RestController
@RequestMapping("/maintenances")
@RequiredArgsConstructor
public class MaintenanceController {

    private final ImaintenanceService maintenanceService;

    @Operation(summary = "Lister toutes les maintenances", description = "Récupère la liste complète des maintenances enregistrées")
    @ApiResponse(responseCode = "200", description = "Liste des maintenances récupérée avec succès")
    @GetMapping
    public List<Maintenance> findAll() {
        return maintenanceService.getAll();
    }

    @Operation(summary = "Consulter une maintenance", description = "Recherche et renvoie une maintenance par son identifiant")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Maintenance trouvée"),
            @ApiResponse(responseCode = "404", description = "Maintenance introuvable")
    })
    @GetMapping("/{id}")
    public Maintenance findById(
            @Parameter(description = "Identifiant unique de la maintenance", required = true, example = "1")
            @PathVariable Long id) {
        Maintenance maintenance = maintenanceService.getById(id);
        if (maintenance == null) {
            throw new ResourceNotFoundException("Maintenance", id);
        }
        return maintenance;
    }

    @Operation(summary = "Créer une maintenance", description = "Enregistre une nouvelle opération de maintenance")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Maintenance créée avec succès"),
            @ApiResponse(responseCode = "400", description = "Données fournies invalides")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Maintenance create(@RequestBody Maintenance maintenance) {
        return maintenanceService.addm(maintenance);
    }

    @Operation(summary = "Modifier une maintenance", description = "Met à jour les informations d'une maintenance existante")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Maintenance mise à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "Maintenance introuvable"),
            @ApiResponse(responseCode = "400", description = "Données fournies invalides")
    })
    @PutMapping("/{id}")
    public Maintenance update(
            @Parameter(description = "Identifiant de la maintenance à mettre à jour", required = true, example = "1")
            @PathVariable Long id,
            @RequestBody Maintenance maintenance) {
        Maintenance existing = maintenanceService.getById(id);
        if (existing == null) {
            throw new ResourceNotFoundException("Maintenance", id);
        }
        maintenance.setIdMaintenance(id);
        maintenanceService.update(maintenance);
        return maintenance;
    }

    @Operation(summary = "Supprimer une maintenance", description = "Supprime une maintenance existante à partir de son identifiant")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Maintenance supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "Maintenance introuvable")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(
            @Parameter(description = "Identifiant de la maintenance à supprimer", required = true, example = "1")
            @PathVariable Long id) {
        Maintenance existing = maintenanceService.getById(id);
        if (existing == null) {
            throw new ResourceNotFoundException("Maintenance", id);
        }
        maintenanceService.remove(existing);
    }
}

package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.exception.ResourceNotFoundException;
import tn.esprit.autoloc.service.IpaiementService;

import java.util.List;

@Tag(name = "Paiements", description = "Gestion des paiements")
@RestController
@RequestMapping("/paiements")
@RequiredArgsConstructor
public class PaiementController {

    private final IpaiementService paiementService;

    @Operation(summary = "Lister tous les paiements", description = "Récupère la liste complète des paiements enregistrés")
    @ApiResponse(responseCode = "200", description = "Liste des paiements récupérée avec succès")
    @GetMapping
    public List<Paiement> findAll() {
        return paiementService.getAll();
    }

    @Operation(summary = "Consulter un paiement", description = "Recherche et renvoie un paiement par son identifiant")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Paiement trouvé"),
            @ApiResponse(responseCode = "404", description = "Paiement introuvable")
    })
    @GetMapping("/{id}")
    public Paiement findById(
            @Parameter(description = "Identifiant unique du paiement", required = true, example = "1")
            @PathVariable Long id) {
        Paiement paiement = paiementService.getById(id);
        if (paiement == null) {
            throw new ResourceNotFoundException("Paiement", id);
        }
        return paiement;
    }

    @Operation(summary = "Créer un paiement", description = "Enregistre un nouveau paiement")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Paiement créé avec succès"),
            @ApiResponse(responseCode = "400", description = "Données fournies invalides")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Paiement create(@RequestBody Paiement paiement) {
        return paiementService.addp(paiement);
    }

    @Operation(summary = "Modifier un paiement", description = "Met à jour les informations d'un paiement existant")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Paiement mis à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "Paiement introuvable"),
            @ApiResponse(responseCode = "400", description = "Données fournies invalides")
    })
    @PutMapping("/{id}")
    public Paiement update(
            @Parameter(description = "Identifiant du paiement à mettre à jour", required = true, example = "1")
            @PathVariable Long id,
            @RequestBody Paiement paiement) {
        Paiement existing = paiementService.getById(id);
        if (existing == null) {
            throw new ResourceNotFoundException("Paiement", id);
        }
        paiement.setIdPaiement(id);
        paiementService.update(paiement);
        return paiement;
    }

    @Operation(summary = "Supprimer un paiement", description = "Supprime un paiement existant à partir de son identifiant")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Paiement supprimé avec succès"),
            @ApiResponse(responseCode = "404", description = "Paiement introuvable")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(
            @Parameter(description = "Identifiant du paiement à supprimer", required = true, example = "1")
            @PathVariable Long id) {
        Paiement existing = paiementService.getById(id);
        if (existing == null) {
            throw new ResourceNotFoundException("Paiement", id);
        }
        paiementService.remove(existing);
    }
}

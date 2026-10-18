package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.service.IcontratService;

import java.util.List;

@Tag(name = "Contrats", description = "Gestion des contrats de location")
@RestController
@RequestMapping("/contrats")
@RequiredArgsConstructor
public class ContratController {

    private final IcontratService contratService;

    @Operation(summary = "Lister tous les contrats", description = "Récupère la liste complète des contrats de location")
    @ApiResponse(responseCode = "200", description = "Liste des contrats récupérée avec succès")
    @GetMapping
    public List<Contrat> findAll() {
        return contratService.findAll();
    }

    @Operation(summary = "Consulter un contrat", description = "Recherche et renvoie un contrat par son identifiant")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Contrat trouvé"),
            @ApiResponse(responseCode = "404", description = "Contrat introuvable")
    })
    @GetMapping("/{id}")
    public Contrat findById(
            @Parameter(description = "Identifiant unique du contrat", required = true, example = "1")
            @PathVariable Long id) {
        return contratService.findByid(id);
    }

    @Operation(summary = "Créer un contrat", description = "Enregistre un nouveau contrat de location")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Contrat créé avec succès"),
            @ApiResponse(responseCode = "400", description = "Données fournies invalides")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contrat create(@RequestBody Contrat contrat) {
        return contratService.create(contrat);
    }

    @Operation(summary = "Modifier un contrat", description = "Met à jour les informations d'un contrat existant")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Contrat mis à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "Contrat introuvable"),
            @ApiResponse(responseCode = "400", description = "Données fournies invalides")
    })
    @PutMapping("/{id}")
    public Contrat update(
            @Parameter(description = "Identifiant du contrat à mettre à jour", required = true, example = "1")
            @PathVariable Long id,
            @RequestBody Contrat contrat) {
        return contratService.update(id, contrat);
    }

    @Operation(summary = "Supprimer un contrat", description = "Supprime un contrat existant à partir de son identifiant")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Contrat supprimé avec succès"),
            @ApiResponse(responseCode = "404", description = "Contrat introuvable")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(
            @Parameter(description = "Identifiant du contrat à supprimer", required = true, example = "1")
            @PathVariable Long id) {
        contratService.deleteById(id);
    }
}
package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.exception.ResourceNotFoundException;
import tn.esprit.autoloc.service.IemployeService;

import java.util.List;

@Tag(name = "Employés", description = "Gestion des employés")
@RestController
@RequestMapping("/employes")
@RequiredArgsConstructor
public class EmployeController {

    private final IemployeService employeService;

    @Operation(summary = "Lister tous les employés", description = "Récupère la liste complète des employés enregistrés")
    @ApiResponse(responseCode = "200", description = "Liste des employés récupérée avec succès")
    @GetMapping
    public List<Employe> findAll() {
        return employeService.getAll();
    }

    @Operation(summary = "Consulter un employé", description = "Recherche et renvoie un employé par son identifiant")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Employé trouvé"),
            @ApiResponse(responseCode = "404", description = "Employé introuvable")
    })
    @GetMapping("/{id}")
    public Employe findById(
            @Parameter(description = "Identifiant unique de l'employé", required = true, example = "1")
            @PathVariable Long id) {
        Employe employe = employeService.getById(id);
        if (employe == null) {
            throw new ResourceNotFoundException("Employe", id);
        }
        return employe;
    }

    @Operation(summary = "Créer un employé", description = "Enregistre un nouvel employé")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Employé créé avec succès"),
            @ApiResponse(responseCode = "400", description = "Données fournies invalides")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employe create(@RequestBody Employe employe) {
        return employeService.addemp(employe);
    }

    @Operation(summary = "Modifier un employé", description = "Met à jour les informations d'un employé existant")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Employé mis à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "Employé introuvable"),
            @ApiResponse(responseCode = "400", description = "Données fournies invalides")
    })
    @PutMapping("/{id}")
    public Employe update(
            @Parameter(description = "Identifiant de l'employé à mettre à jour", required = true, example = "1")
            @PathVariable Long id,
            @RequestBody Employe employe) {
        Employe existing = employeService.getById(id);
        if (existing == null) {
            throw new ResourceNotFoundException("Employe", id);
        }
        employe.setIdEmploye(id);
        employeService.update(employe);
        return employe;
    }

    @Operation(summary = "Supprimer un employé", description = "Supprime un employé existant à partir de son identifiant")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Employé supprimé avec succès"),
            @ApiResponse(responseCode = "404", description = "Employé introuvable")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(
            @Parameter(description = "Identifiant de l'employé à supprimer", required = true, example = "1")
            @PathVariable Long id) {
        Employe existing = employeService.getById(id);
        if (existing == null) {
            throw new ResourceNotFoundException("Employe", id);
        }
        employeService.remove(existing);
    }
}

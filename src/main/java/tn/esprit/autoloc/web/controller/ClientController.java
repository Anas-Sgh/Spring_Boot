package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.exception.ResourceNotFoundException;
import tn.esprit.autoloc.service.IclientService;

import java.util.List;

@Tag(name = "Clients", description = "Gestion des clients")
@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final IclientService clientService;

    @Operation(summary = "Lister tous les clients", description = "Récupère la liste complète des clients enregistrés")
    @ApiResponse(responseCode = "200", description = "Liste des clients récupérée avec succès")
    @GetMapping
    public List<Client> findAll() {
        return clientService.getAll();
    }

    @Operation(summary = "Consulter un client", description = "Recherche et renvoie un client par son identifiant")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Client trouvé"),
            @ApiResponse(responseCode = "404", description = "Client introuvable")
    })
    @GetMapping("/{id}")
    public Client findById(
            @Parameter(description = "Identifiant unique du client", required = true, example = "1")
            @PathVariable Long id) {
        Client client = clientService.getById(id);
        if (client == null) {
            throw new ResourceNotFoundException("Client", id);
        }
        return client;
    }

    @Operation(summary = "Créer un client", description = "Enregistre un nouveau client")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Client créé avec succès"),
            @ApiResponse(responseCode = "400", description = "Données fournies invalides")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client create(@RequestBody Client client) {
        return clientService.addcli(client);
    }

    @Operation(summary = "Modifier un client", description = "Met à jour les informations d'un client existant")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Client mis à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "Client introuvable"),
            @ApiResponse(responseCode = "400", description = "Données fournies invalides")
    })
    @PutMapping("/{id}")
    public Client update(
            @Parameter(description = "Identifiant du client à mettre à jour", required = true, example = "1")
            @PathVariable Long id,
            @RequestBody Client client) {
        Client existing = clientService.getById(id);
        if (existing == null) {
            throw new ResourceNotFoundException("Client", id);
        }
        client.setIdCient(id);
        clientService.update(client);
        return client;
    }

    @Operation(summary = "Supprimer un client", description = "Supprime un client existant à partir de son identifiant")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Client supprimé avec succès"),
            @ApiResponse(responseCode = "404", description = "Client introuvable")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(
            @Parameter(description = "Identifiant du client à supprimer", required = true, example = "1")
            @PathVariable Long id) {
        Client existing = clientService.getById(id);
        if (existing == null) {
            throw new ResourceNotFoundException("Client", id);
        }
        clientService.remove(existing);
    }
}

package com.ev.pcs.fullstackfirstseance.controller;

import com.ev.pcs.fullstackfirstseance.model.Module;
import com.ev.pcs.fullstackfirstseance.service.ModuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST qui gère les requêtes HTTP pour les opérations sur les modules.
 * Il fournit des endpoints pour récupérer, ajouter, modifier et supprimer des modules.
 * Cette classe est annotée avec @RestController, indiquant qu'elle gère les requêtes REST.
 */
@RestController
public class ModuleController {

    private final ModuleService moduleService;
    public ModuleController(
            ModuleService moduleService
    ) {
        this.moduleService = moduleService;
    }

    // Injection du service ModuleService pour accéder aux données et aux opérations de gestion des modules.

    /**
     * Endpoint pour récupérer la liste complète des modules.
     *
     * @return La liste de tous les modules.
     */
    @RequestMapping("/modules")
    public List<Module> getModules() {
        return moduleService.getModules();
    }

    /**
     * Endpoint pour récupérer un module spécifique par son ID.
     *
     * @param id L'ID du module à récupérer.
     * @return Le module correspondant à l'ID fourni.
     */
    @RequestMapping("/modules/{id}")
    public Module getModule(@PathVariable Integer id) {
        return moduleService.getModule(id);
    }

    /**
     * Endpoint pour ajouter un nouveau module.
     * Cette méthode accepte une requête HTTP POST avec un corps JSON représentant un module.
     *
     * @param module Le module à ajouter (passé dans le corps de la requête).
     */
    @RequestMapping(method = RequestMethod.POST, value = "/modules")
    public void ajouterModule(@RequestBody Module module) {
        moduleService.ajouterModule(module);
    }

    /**
     * Endpoint pour modifier un module existant par son ID.
     * Cette méthode accepte une requête HTTP PUT avec un corps JSON représentant le module mis à jour.
     *
     * @param module Le module mis à jour (passé dans le corps de la requête).
     * @param id L'ID du module à modifier.
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/modules/{id}")
    public void modifierModule(@RequestBody Module module, @PathVariable Integer id) {
        moduleService.modifierModule(id, module);
    }

    /**
     * Endpoint pour supprimer un module par son ID.
     * Cette méthode accepte une requête HTTP DELETE et supprime le module correspondant à l'ID fourni.
     *
     * @param id L'ID du module à supprimer.
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/modules/{id}")
    public void supprimerModule(@PathVariable Integer id) {
        moduleService.supprimerModule(id);
    }
}

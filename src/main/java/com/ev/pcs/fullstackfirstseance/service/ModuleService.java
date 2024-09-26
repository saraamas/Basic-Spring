package com.ev.pcs.fullstackfirstseance.service;

import com.ev.pcs.fullstackfirstseance.model.Module;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Service qui gère les opérations CRUD (Create, Read, Update, Delete) pour les modules.
 * Cette classe est annotée avec @Service, indiquant que c'est un composant de service dans Spring.
 */
@Getter
@Service
public class ModuleService {

    /**
     * -- GETTER --
     *  Récupère la liste de tous les modules.
     */
    // Liste des modules initialisée avec deux modules par défaut.
    private List<Module> modules = new ArrayList<>(Arrays.asList(
            new Module(1, "La plateforme Java Standard Edition", "Description de la plateforme Java SE"),
            new Module(2, "La plateforme Java Enterprise Edition", "Description de la plateforme Java EE")
    ));

    /**
     * Récupère un module spécifique par son ID.
     *
     * @param id L'ID du module à récupérer.
     * @return Le module correspondant à l'ID ou null s'il n'est pas trouvé.
     */
    public Module getModule(Integer id) {
        // Parcourt la liste des modules et retourne celui qui correspond à l'ID donné.
        for (Module module : modules) {
            if (id.equals(module.getId())) {
                return module;
            }
        }
        // Retourne null si aucun module avec l'ID donné n'est trouvé.
        return null;
    }

    /**
     * Ajoute un nouveau module à la liste.
     *
     * @param module Le module à ajouter.
     */
    public void ajouterModule(Module module) {
        // Ajoute le nouveau module à la liste.
        modules.add(module);
    }

    /**
     * Modifie un module existant en fonction de son ID.
     *
     * @param id L'ID du module à modifier.
     * @param module Le module avec les nouvelles informations.
     */
    public void modifierModule(Integer id, Module module) {
        // Parcourt la liste pour trouver le module correspondant à l'ID.
        for (int i = 0; i < modules.size(); i++) {
            Module m = modules.get(i);
            // Si l'ID correspond, remplace l'ancien module par le nouveau.
            if (id.equals(m.getId())) {
                modules.set(i, module);
                return;
            }
        }
    }

    /**
     * Supprime un module de la liste en fonction de son ID.
     *
     * @param id L'ID du module à supprimer.
     */
    public void supprimerModule(Integer id) {
        // Utilise removeIf pour supprimer le module qui correspond à l'ID donné.
        modules.removeIf(m -> id.equals(m.getId()));
    }
}

package com.polytech.tp;

import java.util.ArrayList;
import java.util.List;

// On ajoute "implements Subject" pour que le Gestionnaire devienne un "sujet observé"
public class GestionnaireEmploiDuTemps implements Subject {
    private List<ICours> listeCours = new ArrayList<>();

    // Nouvelle liste pour stocker tous les observateurs (étudiants, responsables...)
    private List<Observer> observateurs = new ArrayList<>();

    // ========== MÉTHODES DE L'INTERFACE SUBJECT ==========

    @Override
    public void attach(Observer o) {
        // "Attacher" = ajouter un observateur à la liste
        observateurs.add(o);
        System.out.println("Nouvel observateur ajouté");
    }

    @Override
    public void detach(Observer o) {
        // "Détacher" = retirer un observateur de la liste
        observateurs.remove(o);
        System.out.println("Observateur retiré");
    }

    @Override
    public void notifyObservers(String message) {
        // Parcourir TOUS les observateurs et les notifier
        for (Observer observateur : observateurs) {
            observateur.update(message); // Appelle la méthode update() de chaque observateur
        }
    }

    // ========== MÉTHODES EXISTANTES (modifiées) ==========

    public void ajouterCours(ICours cours) {
        this.listeCours.add(cours);
        System.out.println("Nouveau cours ajouté : " + cours.getDescription());
        // On notifie les observateurs du nouveau cours
        notifyObservers("Nouveau cours ajouté : " + cours.getDescription());
    }

    public void modifierCours(ICours cours, String message) {
        // Logique de modification...
        System.out.println("Cours modifié : " + message);
        // On notifie les observateurs de la modification
        notifyObservers("Cours modifié : " + message);
    }

    // Nouvelle méthode pour signaler un changement général
    public void setChangement(String message) {
        // On notifie directement tous les observateurs
        notifyObservers(message);
    }
}

/*
 * EXPLICATION COMPLÈTE :
 *
 * 1. observateurs = la liste de tous ceux qui veulent être notifiés
 *
 * 2. attach(Observer o) = "abonner" quelqu'un aux notifications
 *    Exemple : gestionnaire.attach(etudiant1);
 *
 * 3. detach(Observer o) = "désabonner" quelqu'un
 *
 * 4. notifyObservers(String message) = envoyer un message à TOUS les abonnés
 *    Elle parcourt la liste et appelle update() sur chaque observateur
 *
 * 5. setChangement(String message) = méthode demandée par le test
 *    Elle sert juste à envoyer une notification
 *
 * UTILISATION COMPLÈTE :
 *
 * // 1. Créer le gestionnaire
 * GestionnaireEmploiDuTemps gestionnaire = new GestionnaireEmploiDuTemps();
 *
 * // 2. Créer des observateurs
 * Etudiant alice = new Etudiant("Alice");
 * Etudiant bob = new Etudiant("Bob");
 * Responsable chef = new Responsable("M. Dupont");
 *
 * // 3. Les abonner aux notifications
 * gestionnaire.attach(alice);
 * gestionnaire.attach(bob);
 * gestionnaire.attach(chef);
 *
 * // 4. Quand on fait un changement, tout le monde est notifié !
 * gestionnaire.setChangement("Changement de salle : C15-C16");
 *
 * // Résultat affiché :
 * // Notification pour l'étudiant Alice : Changement de salle : C15-C16
 * // Notification pour l'étudiant Bob : Changement de salle : C15-C16
 * // Notification pour le responsable M. Dupont : Changement de salle : C15-C16
 */
package com.polytech.tp;

// On ajoute "implements Observer" pour que Etudiant devienne un observateur
public class Etudiant implements Observer {
    private String nom;

    public Etudiant(String nom) {
        this.nom = nom;
    }

    // Cette méthode vient de l'interface Observer
    // Elle sera appelée automatiquement quand il y a une notification
    @Override
    public void update(String message) {
        System.out.println("Notification pour l'étudiant " + nom + " : " + message);
    }
}

/*
 * EXPLICATION :
 *
 * En implémentant Observer, la classe Etudiant DOIT avoir la méthode update()
 * Cette méthode sera appelée automatiquement par le Subject (Gestionnaire)
 *
 * Exemple :
 * Etudiant alice = new Etudiant("Alice");
 * alice.update("Cours annulé");
 * // Affiche : "Notification pour l'étudiant Alice : Cours annulé"
 */
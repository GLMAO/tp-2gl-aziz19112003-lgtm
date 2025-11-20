package com.polytech.tp;

public class CoursBuilder {
    // Étape 1 : Déclarer les MÊMES attributs que dans la classe Cours
    private String matiere;
    private String enseignant;
    private String salle;
    private String date;
    private String heureDebut;
    private boolean estOptionnel;
    private String niveau;
    private boolean necessiteProjecteur;

    // Étape 2 : Créer des méthodes "set" qui retournent "this"
    // "this" = l'objet lui-même, pour permettre l'enchaînement des méthodes

    public CoursBuilder setMatiere(String matiere) {
        this.matiere = matiere;
        return this; // Retourne l'objet builder pour enchaîner
    }

    public CoursBuilder setEnseignant(String enseignant) {
        this.enseignant = enseignant;
        return this;
    }

    public CoursBuilder setSalle(String salle) {
        this.salle = salle;
        return this;
    }

    public CoursBuilder setDate(String date) {
        this.date = date;
        return this;
    }

    public CoursBuilder setHeureDebut(String heureDebut) {
        this.heureDebut = heureDebut;
        return this;
    }

    public CoursBuilder setEstOptionnel(boolean estOptionnel) {
        this.estOptionnel = estOptionnel;
        return this;
    }

    public CoursBuilder setNiveau(String niveau) {
        this.niveau = niveau;
        return this;
    }

    public CoursBuilder setNecessiteProjecteur(boolean necessiteProjecteur) {
        this.necessiteProjecteur = necessiteProjecteur;
        return this;
    }

    // Étape 3 : La méthode build() crée finalement l'objet Cours
    public Cours build() {
        // On appelle le constructeur de Cours avec tous les attributs
        return new Cours(
                matiere,
                enseignant,
                salle,
                date,
                heureDebut,
                estOptionnel,
                niveau,
                necessiteProjecteur
        );
    }
}

/*
 * EXPLICATION DE L'UTILISATION :
 *
 * Sans Builder (difficile à lire) :
 * Cours cours = new Cours("Math", "Mr X", "A12", "Lundi", "8h", false, "2A", true);
 *
 * Avec Builder (facile à lire) :
 * Cours cours = new CoursBuilder()
 *     .setMatiere("Math")
 *     .setEnseignant("Mr X")
 *     .setSalle("A12")
 *     .build();
 */
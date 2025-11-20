package com.polytech.tp;

public class CoursEnLigne extends CoursDecorator {

    // Le constructeur appelle le constructeur parent (super)
    public CoursEnLigne(ICours cours) {
        super(cours); // "super" = appelle le constructeur de CoursDecorator
    }

    @Override
    public String getDescription() {
        // On prend la description du cours de base
        // ET on ajoute " - En ligne" à la fin
        return coursDecorated.getDescription() + " - En ligne";
    }

    @Override
    public double getDuree() {
        // Un cours en ligne dure 0.5h de plus (par exemple)
        return coursDecorated.getDuree() + 0.5;
    }
}

/*
 * EXPLICATION DE L'UTILISATION :
 *
 * // 1. On crée un cours de base
 * ICours coursNormal = new Cours("Math", "Mr X", "A12", ...);
 * System.out.println(coursNormal.getDescription());
 * // Affiche : "Cours de Math avec Mr X (A12)"
 *
 * // 2. On "décore" ce cours pour le mettre en ligne
 * ICours coursEnLigne = new CoursEnLigne(coursNormal);
 * System.out.println(coursEnLigne.getDescription());
 * // Affiche : "Cours de Math avec Mr X (A12) - En ligne"
 *
 * Le cours de base n'est PAS modifié ! On a juste ajouté une couche par-dessus.
 */
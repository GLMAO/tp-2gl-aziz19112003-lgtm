package com.polytech.tp;

public abstract class CoursDecorator implements ICours {
    // L'attribut qui contient le cours qu'on "décore"
    protected ICours coursDecorated;

    // Le constructeur reçoit le cours à décorer
    public CoursDecorator(ICours cours) {
        this.coursDecorated = cours;
    }

    // On FORCE les classes qui héritent à implémenter ces méthodes
    // C'est pour ça qu'on les déclare ici (abstract = obligatoire)
    @Override
    public abstract String getDescription();

    @Override
    public abstract double getDuree();
}

/*
 * EXPLICATION :
 *
 * Cette classe est ABSTRAITE = on ne peut pas créer d'objet CoursDecorator directement
 * Elle sert de BASE pour tous les décorateurs (CoursEnLigne, CoursAvecTP, etc.)
 *
 * coursDecorated = le cours qu'on "enveloppe" pour lui ajouter des fonctionnalités
 */
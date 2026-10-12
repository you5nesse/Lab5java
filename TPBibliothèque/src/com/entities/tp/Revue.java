package com.entities.tp;

public class Revue extends Document {
    private String mois;
    private int annee;

    public Revue(String titre, String mois, int annee) {
        super(titre);
        this.mois = mois;
        this.annee = annee;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Mois : " + mois
                + ", Année : " + annee;
    }
}

package com.entities.tp;

public class Bibliotheque {
    private int capacite;
    private Document[] documents;
    private int nombre;

    public Bibliotheque(int capacite) {
        if (capacite < 0) {
            throw new IllegalArgumentException(
                "Capacité invalide");
        }

        this.capacite = capacite;
        this.documents = new Document[capacite];
        this.nombre = 0;
    }

    public void afficherDocuments() {
        if (nombre == 0) {
            System.out.println("Bibliothèque vide.");
            return;
        }

        for (int i = 0; i < nombre; i++) {
            System.out.println(documents[i]);
        }
    }

    public boolean ajouter(Document doc) {
        if (doc == null || nombre >= capacite) {
            return false;
        }

        documents[nombre] = doc;
        nombre++;
        return true;
    }

    public boolean supprimer(Document doc) {
        for (int i = 0; i < nombre; i++) {
            if (documents[i] == doc) {
                for (int j = i; j < nombre - 1; j++) {
                    documents[j] = documents[j + 1];
                }

                documents[nombre - 1] = null;
                nombre--;
                return true;
            }
        }

        return false;
    }

    public Document document(int numEnreg) {
        for (int i = 0; i < nombre; i++) {
            if (documents[i].getNumEnreg() == numEnreg) {
                return documents[i];
            }
        }

        return null;
    }

    public void afficherAuteurs() {
        for (int i = 0; i < nombre; i++) {
            if (documents[i] instanceof Livre) {
                Livre livre = (Livre) documents[i];

                if (livre.getAuteur() != null
                        && !livre.getAuteur().isEmpty()) {
                    System.out.println(livre.getAuteur());
                }
            }
        }
    }
}

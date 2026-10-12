```java
package com.entities.tp;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Capacité de la bibliothèque : ");
        int n = lireEntier(sc);

        while (n <= 0) {
            System.out.print("La capacité doit être positive : ");
            n = lireEntier(sc);
        }

        Bibliotheque b = new Bibliotheque(n);

        // Initialiser avec deux documents si possible
        b.ajouter(new Roman(
                "L'Etranger", "Albert Camus", 150, 80.0));

        if (n > 1) {
            b.ajouter(new Revue(
                    "Science et Vie", "Octobre", 2026));
        }

        int choix;

        do {
            System.out.println("\n========== MENU ==========");
            System.out.println("1. Ajouter un document");
            System.out.println("2. Afficher les documents");
            System.out.println("3. Supprimer un document");
            System.out.println("4. Rechercher par numéro");
            System.out.println("5. Afficher les auteurs");
            System.out.println("0. Quitter");
            System.out.println("==========================");
            System.out.print("Votre choix : ");

            choix = lireEntier(sc);

            switch (choix) {

                case 1: {
                    System.out.println("\nType de document :");
                    System.out.println("1. Livre");
                    System.out.println("2. Revue");
                    System.out.println("3. Dictionnaire");
                    System.out.println("4. Roman");
                    System.out.println("5. Manuel");
                    System.out.print("Votre type : ");

                    int type = lireEntier(sc);

                    System.out.print("Titre : ");
                    String titre = sc.nextLine();

                    Document doc = null;

                    switch (type) {

                        case 1: {
                            System.out.print("Auteur : ");
                            String auteur = sc.nextLine();

                            System.out.print("Nombre de pages : ");
                            int pages = lireEntier(sc);

                            doc = new Livre(titre, auteur, pages);
                            break;
                        }

                        case 2: {
                            System.out.print("Mois : ");
                            String mois = sc.nextLine();

                            System.out.print("Année : ");
                            int annee = lireEntier(sc);

                            doc = new Revue(titre, mois, annee);
                            break;
                        }

                        case 3: {
                            System.out.print("Langue : ");
                            String langue = sc.nextLine();

                            doc = new Dictionnaire(titre, langue);
                            break;
                        }

                        case 4: {
                            System.out.print("Auteur : ");
                            String auteur = sc.nextLine();

                            System.out.print("Nombre de pages : ");
                            int pages = lireEntier(sc);

                            System.out.print("Prix : ");
                            double prix = lireDouble(sc);

                            doc = new Roman(
                                    titre, auteur, pages, prix);
                            break;
                        }

                        case 5: {
                            System.out.print("Auteur : ");
                            String auteur = sc.nextLine();

                            System.out.print("Nombre de pages : ");
                            int pages = lireEntier(sc);

                            System.out.print("Niveau : ");
                            String niveau = sc.nextLine();

                            doc = new Manuel(
                                    titre, auteur, pages, niveau);
                            break;
                        }

                        default:
                            System.out.println("Type invalide.");
                    }

                    if (doc != null) {
                        if (b.ajouter(doc)) {
                            System.out.println("Document ajouté avec succès.");
                        } else {
                            System.out.println(
                                    "Échec : bibliothèque pleine.");
                        }
                    }
                    break;
                }

                case 2:
                    b.afficherDocuments();
                    break;

                case 3: {
                    System.out.print("Numéro du document à supprimer : ");
                    int numSupp = lireEntier(sc);

                    Document docSupp = b.document(numSupp);

                    if (docSupp != null && b.supprimer(docSupp)) {
                        System.out.println("Document supprimé.");
                    } else {
                        System.out.println("Document introuvable.");
                    }
                    break;
                }

                case 4: {
                    System.out.print("Numéro recherché : ");
                    int num = lireEntier(sc);

                    Document trouve = b.document(num);

                    if (trouve != null) {
                        System.out.println("Document trouvé :");
                        System.out.println(trouve);
                    } else {
                        System.out.println("Document introuvable.");
                    }
                    break;
                }

                case 5:
                    b.afficherAuteurs();
                    break;

                case 0:
                    System.out.println("Au revoir !");
                    break;

                default:
                    System.out.println("Choix invalide.");
            }

        } while (choix != 0);

        sc.close();
    }

    // Lire un entier sans provoquer InputMismatchException
    private static int lireEntier(Scanner sc) {
        while (true) {
            String saisie = sc.nextLine().trim();

            try {
                return Integer.parseInt(saisie);
            } catch (NumberFormatException e) {
                System.out.print("Veuillez saisir un entier valide : ");
            }
        }
    }

    // Lire un nombre décimal (accepte 12.5 ou 12,5)
    private static double lireDouble(Scanner sc) {
        while (true) {
            String saisie = sc.nextLine().trim().replace(',', '.');

            try {
                return Double.parseDouble(saisie);
            } catch (NumberFormatException e) {
                System.out.print("Veuillez saisir un prix valide : ");
            }
        }
    }
}
```

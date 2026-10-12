package com.entities.tp;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Capacité de la bibliothèque : ");
        int n = sc.nextInt();
        sc.nextLine();

        Bibliotheque b = new Bibliotheque(n);

        // Initialiser avec deux documents si possible
        if (n > 0) {
            b.ajouter(new Roman(
                "L'Etranger", "Albert Camus", 150, 80.0));
        }

        if (n > 1) {
            b.ajouter(new Revue(
                "Science et Vie", "Octobre", 2026));
        }

        int choix;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Ajouter un document");
            System.out.println("2. Afficher les documents");
            System.out.println("3. Supprimer un document");
            System.out.println("4. Rechercher par numéro");
            System.out.println("5. Afficher les auteurs");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");

            choix = sc.nextInt();
            sc.nextLine();

            switch (choix) {
                case 1:
                    System.out.println("Type : 1-Livre, 2-Revue, "
                            + "3-Dictionnaire, 4-Roman, 5-Manuel");
                    int type = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Titre : ");
                    String titre = sc.nextLine();

                    Document doc = null;

                    switch (type) {
                        case 1:
                            System.out.print("Auteur : ");
                            String auteur = sc.nextLine();
                            System.out.print("Nombre de pages : ");
                            int pages = sc.nextInt();
                            sc.nextLine();
                            doc = new Livre(titre, auteur, pages);
                            break;

                        case 2:
                            System.out.print("Mois : ");
                            String mois = sc.nextLine();
                            System.out.print("Année : ");
                            int annee = sc.nextInt();
                            sc.nextLine();
                            doc = new Revue(titre, mois, annee);
                            break;

                        case 3:
                            System.out.print("Langue : ");
                            String langue = sc.nextLine();
                            doc = new Dictionnaire(titre, langue);
                            break;

                        case 4:
                            System.out.print("Auteur : ");
                            String auteurRoman = sc.nextLine();
                            System.out.print("Pages : ");
                            int pagesRoman = sc.nextInt();
                            System.out.print("Prix : ");
                            double prix = sc.nextDouble();
                            sc.nextLine();
                            doc = new Roman(titre, auteurRoman,
                                    pagesRoman, prix);
                            break;

                        case 5:
                            System.out.print("Auteur : ");
                            String auteurManuel = sc.nextLine();
                            System.out.print("Pages : ");
                            int pagesManuel = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Niveau : ");
                            String niveau = sc.nextLine();
                            doc = new Manuel(titre, auteurManuel,
                                    pagesManuel, niveau);
                            break;

                        default:
                            System.out.println("Type invalide.");
                    }

                    if (doc != null) {
                        System.out.println(b.ajouter(doc)
                                ? "Document ajouté."
                                : "Échec : bibliothèque pleine.");
                    }
                    break;

                case 2:
                    b.afficherDocuments();
                    break;

                case 3:
                    System.out.print("Numéro du document : ");
                    int numSupp = sc.nextInt();
                    sc.nextLine();

                    Document aSupprimer = b.document(numSupp);

                    if (aSupprimer != null
                            && b.supprimer(aSupprimer)) {
                        System.out.println("Document supprimé.");
                    } else {
                        System.out.println("Document introuvable.");
                    }
                    break;

                case 4:
                    System.out.print("Numéro recherché : ");
                    int num = sc.nextInt();
                    sc.nextLine();

                    Document trouve = b.document(num);
                    System.out.println(trouve != null
                            ? trouve : "Document introuvable.");
                    break;

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
}


package com.gestionCommercial;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        System.out.println("******************** GESTION COMMERCIAL******************");
        Commercial commercial=new Commercial();

            boolean shouldFinish=false;

            while (!shouldFinish){
                System.out.println("-------------------------------------------------");
                System.out.println("1) Ajouter un article");
                System.out.println("2) Supprimer un article");
                System.out.println("3) Ajouter un client");
                System.out.println("4) Supprimer un client");
                System.out.println("5) Passer une commande");
                System.out.println("6) Annuler une commande");
                System.out.println("7) Liste des articles");
                System.out.println("8) Liste des clients");
                System.out.println("9) Liste des commands");
                System.out.println("0) Quitter");

                System.out.println();

                System.out.print("Entrer un choix :");
                Scanner scanner=new Scanner(System.in);
                int choice=scanner.nextInt();

                switch (choice){
                    case 1:
                        System.out.println("Donner la reference de l'article :");
                        scanner=new Scanner(System.in);
                        int reference=scanner.nextInt();

                        System.out.println("Donner la designation de l'article :");
                        scanner=new Scanner(System.in);
                        String designation=scanner.nextLine();

                        System.out.println("Donner le prix unitaire de l'article :");
                        scanner=new Scanner(System.in);
                        double prixUnitaire=scanner.nextDouble();

                        System.out.println("Donner la quantité de l'article :");
                        scanner=new Scanner(System.in);
                        int quantite =scanner.nextInt();

                        if (designation.isEmpty()){
                            System.out.println("Designation required !");
                        }else
                        {
                            Article article=new Article(reference,designation,prixUnitaire,quantite);
                            commercial.AjouterArticle(article);
                        }
                        continue;
                    case 2:
                        System.out.println("Donner le reference de l'article :");
                        scanner=new Scanner(System.in);
                        int ref=scanner.nextInt();

                        commercial.SupprimerArticle(new Article(ref,"",0,0));
                        continue;
                    case 3:
                        System.out.println("Donner votre identifiant :");
                        scanner=new Scanner(System.in);
                        int id=scanner.nextInt();

                        System.out.println("Donner votre nom Social :");
                        scanner=new Scanner(System.in);
                        String nomSocial=scanner.nextLine();

                        System.out.println("Donner votre Adress :");
                        scanner=new Scanner(System.in);
                        String adress=scanner.nextLine();

                        System.out.println("Donner votre chiffre d'affaire :");
                        scanner=new Scanner(System.in);
                        double chiffreaffaire=scanner.nextDouble();

                        if (nomSocial.isEmpty() || adress.isEmpty()){
                            System.out.println("Veuillez remplire tout les champs !!");
                        }else{
                            commercial.AjouterClient(new Client(id,nomSocial,adress,chiffreaffaire));
                        }
                        continue;
                    case 4:
                        System.out.println("Donner l'identifiant :");
                        scanner=new Scanner(System.in);
                        id=scanner.nextInt();

                        commercial.SupprimerClient(new Client(id,"","",0));
                        continue;
                    case 5:
                        System.out.println("Donner votre identifiant :");
                        scanner=new Scanner(System.in);
                        id=scanner.nextInt();

                        System.out.println("Donner votre nom Social :");
                        scanner=new Scanner(System.in);
                        nomSocial=scanner.nextLine();

                        System.out.println("Donner votre Adress :");
                        scanner=new Scanner(System.in);
                        adress=scanner.nextLine();

                        System.out.println("Donner votre chiffre d'affaire :");
                        scanner=new Scanner(System.in);
                        chiffreaffaire=scanner.nextDouble();

                        System.out.println("Donner votre numero de commande :");
                        scanner=new Scanner(System.in);
                        int commandnum=scanner.nextInt();

                        java.util.Date date = new java.util.Date();

                        if (nomSocial.isEmpty() || adress.isEmpty()){
                            System.out.println("Veuillez remplire tout les champs !!");
                        }else{
                            commercial.PasserCommande(new Commande(commandnum,date,new Client(id,nomSocial,adress,chiffreaffaire)));
                        }
                        continue;
                    case 6:
                        System.out.println("Donner votre identifiant :");
                        scanner=new Scanner(System.in);
                        id=scanner.nextInt();

                        System.out.println("Donner la numero de la commande :");
                        scanner=new Scanner(System.in);
                        int numC=scanner.nextInt();
                        java.util.Date dateC = new java.util.Date();

                        commercial.AnnulerCommande(new Commande(numC,dateC,new Client(id,"","",0)));
                        continue;
                    case 7:
                        System.out.println("*** Liste des Articles ***");
                        commercial.AfficherArticles();
                        continue;
                    case 8:
                        System.out.println("*** Liste des Clients ***");
                        commercial.AfficherClients();
                        continue;
                    case 9:
                        System.out.println("*** Liste des Commands ***");
                        commercial.AfficherCommands();
                        continue;
                    default:
                        System.out.println("Vous avez quitter l'application");
                        shouldFinish=true;
                        break;

                }
            }

        }
    }

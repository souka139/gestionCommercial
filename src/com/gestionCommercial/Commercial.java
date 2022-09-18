package com.gestionCommercial;

import java.util.*;

public class Commercial {
    private Vector<Client> clients = new Vector<Client>();
    private Vector<Article> articles = new Vector<Article>();
    private Vector<Commande> commandes = new Vector<Commande>();
    private Vector<Ligne> lignes = new Vector<Ligne>();

    public void PasserCommande(Commande c) {
        if (articles.size()==0){
            System.out.println("la liste des articles est vide !! vous ne pouvez pas commander ");
        }else{
            //Add order
            commandes.add(c);

            System.out.println("Choisie une article :");

            System.out.println();
            AfficherArticles();
            System.out.println();

            System.out.println("Donner la reference de l'article que vous voulez commander :");
            Scanner scanner = new Scanner(System.in);
            int ref = scanner.nextInt();

            System.out.println("Donner la quantité :");
            scanner = new Scanner(System.in);
            int qt = scanner.nextInt();


            Boolean found = false;
            for (int i = 0; i < articles.size(); i++) {
                if (articles.get(i).getReference() == ref) {
                    if (articles.get(i).getQuantiteStock()==0){
                        System.out.println("Stock épuisé");
                    }else{
                        if (qt > articles.get(i).getQuantiteStock()) {
                            System.out.println("la quantité commandé est plus grand que le stock !! ");
                        } else {
                            Article article=new Article(articles.get(i).getReference(),articles.get(i).getDesignation(),articles.get(i).getPrixUnitaire(),articles.get(i).getQuantiteStock());
                            Ligne ligne=new Ligne(c,article,qt);

                            if (clients.size()!=0){
                                boolean fnd=false;
                                for (int j=0;j<clients.size();j++){
                                    if (clients.get(j).getIdent() == c.getClient().getIdent()){
                                        fnd=true;
                                    }
                                }
                                if (fnd==false){
                                    clients.add(c.getClient());
                                }
                            }else{
                                clients.add(c.getClient());
                            }

                            lignes.add(ligne);
                            System.out.println("Merci pour votre commande !");

                            // update quantite stock
                            int qtstockUpdated = articles.get(i).getQuantiteStock() - qt;
                            articles.get(i).setQuantiteStock(qtstockUpdated);
                        }
                    }
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Article introuvable !!");
            }

        }

    }

        public void AnnulerCommande(Commande c){
            System.out.println("******** Annulation d'une commande ***********");
            System.out.println("Démarrage de l'annulation :");
            boolean found = false;
            for (int i = 0; i < lignes.size(); i++) {
                if (lignes.get(i).getCommande().getNumcomm() == c.getNumcomm() && lignes.get(i).getCommande().getClient().getIdent()==c.getClient().getIdent()) {
                    //update la quantité de stock aprés l"annulation
                    for (int j=0;j<articles.size();j++){
                        if (lignes.get(i).getArticle().getReference()==articles.get(j).getReference()){
                            int q=articles.get(j).getQuantiteStock() + lignes.get(i).getQuantitecomm();
                            articles.get(j).setQuantiteStock(q);
                        }

                    }
                    //supprimer la commade
                    lignes.remove(i);
                    commandes.remove(i);
                    found = true;
                }
            }

            if (found) {
                System.out.println("Commande '" + c.getNumcomm() + "' a été annulée");
            } else {
                System.out.println("Commande introuvable");
            }
        }

        public void AjouterArticle(Article a){
            articles.add(a);
            System.out.println();
            System.out.println("Article bien ajouté !");
            System.out.println();
        }

        public void SupprimerArticle(Article a){
        System.out.println("******** Suppression d'un article ***********");
            System.out.println("Démarrage de la suppression :");
            boolean found = false;
            for (int i = 0; i < articles.size(); i++) {
                if (articles.get(i).getReference() == a.getReference()) {
                    articles.remove(i);
                    found = true;
                }
            }

            if (found) {
                System.out.println("Article '" + a.getReference() + "' a été supprimer");
            } else {
                System.out.println("Article introuvable !!");
            }

        }

        public void AjouterClient(Client c){
            clients.add(c);
            System.out.println();
            System.out.println("Client bien Ajouté");
            System.out.println();
        }

        public void AfficherClients() {
            Enumeration<Client> enumeration = clients.elements();
            while (enumeration.hasMoreElements()) {
                System.out.println(enumeration.nextElement());
            }
            if (clients.isEmpty()) {
                System.out.println("La Liste est vide");
            }
            System.out.println("Taille :" + clients.size());
        }

        public void AfficherArticles() {
            Enumeration<Article> enumeration = articles.elements();
            while (enumeration.hasMoreElements()) {
                System.out.println(enumeration.nextElement());
            }
            if (articles.isEmpty()) {
                System.out.println("La Liste est vide");
            }
            System.out.println("Taille :" + articles.size());
        }

        public void AfficherCommands() {
            Enumeration<Ligne> enumeration = lignes.elements();
            while (enumeration.hasMoreElements()) {
                System.out.println(enumeration.nextElement());
            }
            if (lignes.isEmpty()) {
                System.out.println("La liste est vide");
            }
            System.out.println("Taille :" + lignes.size());
        }

        public void SupprimerClient (Client c){
            System.out.println("******** Suppression d'un client ***********");
            System.out.println("Démarrage de la suppression :");
            boolean found = false;
            for (int i = 0; i < clients.size(); i++) {
                if (clients.get(i).getIdent() == c.getIdent()) {
                    clients.remove(i);
                    found = true;
                }
            }
            if (found) {
                System.out.println("Client '" + c.getIdent() + "' a été supprimer");
            } else {
                System.out.println("Client introuvable !!");
            }
        }


}


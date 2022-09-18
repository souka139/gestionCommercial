package com.gestionCommercial;

public class Article {
    private int reference;
    private String designation;
    private double prixUnitaire;
    private int quantiteStock;

    public Article(int reference, String designation, double prixUnitaire, int quantiteStock) {
        this.reference = reference;
        this.designation = designation;
        this.prixUnitaire = prixUnitaire;
        this.quantiteStock = quantiteStock;
    }
    public Article(Article a){
        reference=a.reference;
        designation=a.designation;
        prixUnitaire=a.prixUnitaire;
        quantiteStock=a.quantiteStock;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public int getQuantiteStock() {
        return quantiteStock;
    }

    public void setQuantiteStock(int quantiteStock) {
        this.quantiteStock = quantiteStock;
    }

    @Override
    public String toString() {
        return reference +" | Designation: "+ designation+" | prix: "+prixUnitaire+" dh | Quantite Stock : "+quantiteStock;
    }
    public void Afficher(){
        System.out.println("Article :"+toString());
    }
}

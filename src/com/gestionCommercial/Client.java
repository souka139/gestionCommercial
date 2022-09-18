package com.gestionCommercial;

public class Client extends Personne{
    private double chiffreaffaire;

    public Client(int ident, String nomSocial, String adress,double chiffreaffaire) {
        super(ident, nomSocial, adress);
        this.chiffreaffaire=chiffreaffaire;
    }

    public double getChiffreaffaire() {
        return chiffreaffaire;
    }

    public void setChiffreaffaire(double chiffreaffaire) {
        this.chiffreaffaire = chiffreaffaire;
    }

    @Override
    public String toString() {
        return "Client :"+super.toString()+" | chiffre d'affaire: "+ this.getChiffreaffaire()+"\n";
    }

    @Override
    public void Afficher() {
        System.out.println(toString());
    }
}

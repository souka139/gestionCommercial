package com.gestionCommercial;

public class Fournisseur extends Personne{

    private String specialite;
    private Personne personne;

    public Fournisseur(int ident, String nomSocial, String adress,String specialite) {
        super(ident, nomSocial, adress);
        this.specialite=specialite;
    }

    public Fournisseur(Personne p,String specialite) {
        super(p);
        this.specialite=specialite;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    @Override
    public String toString() {
        return personne+" | specialité :"+specialite;
    }

    @Override
    public void Afficher() {
        super.Afficher();
    }
}

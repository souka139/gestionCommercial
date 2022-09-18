package com.gestionCommercial;

public abstract class Personne {
    protected int ident;
    protected String nomSocial;
    protected String adress;

    protected Personne(int ident, String nomSocial, String adress) {
        this.ident = ident;
        this.nomSocial = nomSocial;
        this.adress = adress;
    }

    public Personne(Personne p) {

    }

    protected int getIdent() {
        return ident;
    }

    protected void setIdent(int ident) {
        this.ident = ident;
    }

    protected String getNomSocial() {
        return nomSocial;
    }

    protected void setNomSocial(String nomSocial) {
        this.nomSocial = nomSocial;
    }

    protected String getAdress() {
        return adress;
    }

    protected void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return  this.ident+" | nom social : "+this.nomSocial+" | Adress : "+this.adress;
    }

    public void Afficher(){
        System.out.println(toString());
    }
}

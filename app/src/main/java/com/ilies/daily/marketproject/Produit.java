package com.ilies.daily.marketproject;

public class Produit {
    public String id,marque,nom,poids,volume,id_producteur,prix;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPoids() {
        return poids;
    }

    public void setPoids(String poids) {
        this.poids = poids;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getId_producteur() {
        return id_producteur;
    }

    public void setId_producteur(String id_producteur) {
        this.id_producteur = id_producteur;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public Produit(String id, String marque, String nom, String poids, String volume, String id_producteur, String prix) {
        this.id = id;
        this.marque = marque;
        this.nom = nom;
        this.poids = poids;
        this.volume = volume;
        this.id_producteur = id_producteur;
        this.prix = prix;
    }
}

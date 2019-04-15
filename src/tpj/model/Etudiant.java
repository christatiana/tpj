/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tpj.model;

/**
 *
 * @author TATIANA
 */
public class Etudiant {
     private String matricule;
    private String nom;
    private String filiere;
    private int niveau;
   
    public Etudiant(){
    
}

    public Etudiant(String matricule, String nom, String filiere, int niveau) {
        this.matricule = matricule;
        this.nom = nom;
        this.filiere = filiere;
        this.setNiveau(niveau);
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }
    
    
}

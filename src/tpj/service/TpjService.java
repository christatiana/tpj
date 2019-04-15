/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tpj.service;
import java.sql.*;


import tpj.model.Etudiant;
/**
 *
 * @author TATIANA
 */
public class TpjService {
    String url = "jdbc:mysql://localhost:3306/gestion";
    String username = "root";
    String password = "";
    
    Connection conn = null;
    
    public TpjService(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Chargement du Pilote ok");
            
            conn = DriverManager.getConnection(url,username,password);
        }catch(Exception e){
            e.printStackTrace();
        }
    
    }
    
    //enregistrer un nouvel etudiant;
    public boolean addEtudiant(Etudiant etu){
        try{
            Statement req = conn.createStatement();
            String reqSQL = "INSERT INTO etudiant values(null'" + etu.getMatricule() +"','"+ etu.getNom() +"','"+ etu.getFiliere() +"','"+ etu.getNiveau()+")";
            int res = req.executeUpdate(reqSQL);
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }  
   
    
    //afficher la liste de tous les etudiants;
     public void afficherListeEtudiant(){
        try{
            Statement req = conn.createStatement();
            String reqSQL = "SELECT * FROM etudiant";
            ResultSet res = req.executeQuery(reqSQL);
            while(res.next()){
                System.out.println(res.getString("matricule") + ":" + res.getString("nom") + ":" + res.getString("filiere") + ":" + res.getInt("niveau"));
                
            }
        }catch(Exception e){
            e.printStackTrace(); 
        }
    }
    //afficher la liste de tous les etudiant par filiere;
     public void afficherListeEtudiantfil(String filiere){
        try{
            Statement req = conn.createStatement();
            String reqSQL = "SELECT * FROM etudiant"+ "WHERE filiere='"+filiere+"'";
            ResultSet res = req.executeQuery(reqSQL);
            while(res.next()){
             
             System.out.println(res.getString("matricule") + ":" + res.getString("nom") + ":" + res.getInt("niveau"));
                
            }
        }catch(SQLException e){
            e.printStackTrace();
           
        }
    }
      //rechercher un etudiant;
           public void rechercherEtudiantmat(String matricule){
            try{
               Statement req=conn.createStatement();
             String reqSQL="SELECT FROM etudiant" +"WHERE matricule='"+matricule+"'";
              ResultSet res=req.executeQuery(reqSQL);
              while(res.next()){
                  
                
               System.out.println(res.getString("matricule")+":"+res.getString("nom") + ":" + res.getString("filiere") + ":" + res.getInt("niveau"));
             }
            }catch(Exception e){
                e.printStackTrace();
            }
           }           
             
     
     
    //supprimer un etudiant a partir de son matricule
    public void deleteMatricule(String matricule){
        try{
            Statement req = conn.createStatement();
            String sql = "DELETE FROM etudiant WHERE matricule= '"+matricule+"'";
            int res = req.executeUpdate(sql);
                System.out.println("La suppression du matricule a bien été effectuée. ");
                
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void modifyNiveauEtudiant(String matricule,int niveau){
        try{
            Statement req= conn.createStatement();
             String sql = "UPDATE etudiant SET niveau = "+niveau+"WHERE matricule= '"+matricule+"'";
             int res=req.executeUpdate(sql);
             
             System.out.println("****************************");
             System.out.println("apres modification : ");
             
           System.out.println("le niveau est bien modifier");
        }catch(Exception e){
            e.printStackTrace();
        } 
             
    
}
}
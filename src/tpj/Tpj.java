/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tpj;
import tpj.model.Etudiant;
 import tpj.service.TpjService;
 import java.util.Scanner;
 import java.util.*;


/**
 *
 * @author TATIANA
 */
public class Tpj {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        Scanner sc=new Scanner (System.in);
         Etudiant etude1,etude2,etude3;
         Etudiant etude;
        String mat;
        String f;
        String nom;
        int niv;
        
       TpjService   service;
        service =new TpjService();
    
       // menu
      
      int choix;
     
      do{
        System.out.println("----------------menu-------------------------");
        System.out.println("1. Enregistrer un nouvel etudiant");
        System.out.println("2. liste de tous les etudiants");
        System.out.println("3. liste de tous les etudiants d'une filiere donnée");
        System.out.println("4. Recherche et affiche les informations d un etudiant par son matricule");
        System.out.println("5. Suppression d'un etudiant a partir de son matricule"); 
        System.out.println("6. modification du niveau d'un etudiant donné");
        System.out.println("Veuillez entrer votre choix(1-6): ");
         choix=sc.nextInt();          
          
      switch(choix)
      { 
          //methode d'enregistrement d'un nouvel etudiant
          case 1:
         System.out.print("Entrer le matricule: ");
         mat= sc.next();
         System.out.print("Entrer le nom : ");
         nom= sc.next();
         System.out.print("Entrer la filiere : ");
         f=sc.next();
         System.out.print("Entrer le niveau : ");
         niv= sc.nextInt(); 
         etude = new Etudiant(mat,nom,f,niv);
         service.addEtudiant(etude);
         System.out.println(" l'Enregistrement a été effectue");
                   
              break;
              //methode d'affichage de tous les etudiant
              case 2: 
                  service.afficherListeEtudiant(); 
           
              break;
                  //methode d'affichage des etudiant par filiere
                   case 3: 
                  System.out.print("Entrer la filiere: "); 
           f=sc.next();
           service.afficherListeEtudiantfil(f);
           
              break;
                  case 4:
                      //methode de recherche d'un etudiant par filiere
                      System.out.print("Entrer le matricule de l etudiant à rechercher : ");
                mat= sc.next();
                System.out.print("l'etudiant rechercher est: ");
                service.rechercherEtudiantmat(mat);
           
              break;
                //methode de suppression
                 case 5:
                     System.out.print("Entrer le matricule de l'etudiant à supprimer : ");
                mat= sc.next();
                service.deleteMatricule(mat);
                service.afficherListeEtudiant();
                System.out.println("suppression reussie");
            
              break;
             //methode de modification du niveau d'un etudiant
                  case 6:
                System.out.print("Entrer le matricule  de l'etudiant : ");
                mat= sc.next();
                System.out.print("Modifier le niveau de l'etudiant : ");
                niv= sc.nextInt();
                service.modifyNiveauEtudiant(mat,niv);
                service.afficherListeEtudiant();
                System.out.println("Mise à jour effectuée"); 
                      break;
                 // default:System.out.println("veuillez entré le choix existant");
    } 
      }while(choix!=6);
        
    }
    
}

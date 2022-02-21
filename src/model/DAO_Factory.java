package model;
import java.sql.Connection;

import metiers.Medicament;
import metiers.Praticien;
import metiers.Rapport;
import metiers.Visiteur;

public class DAO_Factory {

    protected static final Connection conn = BDDConnexion.getInstance();

    /**
     * Retourne un objet Classe interagissant avec la BDD
     * @return DAO
     */
    public static DAO<Visiteur> getDAOVisiteur(){
        return new DAO_Visiteur(conn);
    }

    public static DAO<Medicament> getDAOMedicament(){
        return new DAO_Medicament(conn);
    }

    public static DAO getDAOFamille(){
        return new DAO_Famille(conn);
    }

    public static DAO<Praticien> getDAOPraticien(){
        return new DAO_Praticien(conn);
    }

    public static DAO<Rapport> getDAORapport(){
        return new DAO_Rapport(conn);
    }
}
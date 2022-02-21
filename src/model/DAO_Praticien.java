package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import metiers.Praticien;


public class DAO_Praticien extends DAO<Praticien> {

    public DAO_Praticien(Connection conn) {
        super(conn);
    }

    /** R�cup�re le nom, le pr�nom et l'ID du praticien (Pour selectionner le praticien � la cr�ation d'un C.R.)**/
    public static String[] findname() throws SQLException {
        ArrayList<String> toReturn = new ArrayList<String>();
        Statement st=connect.createStatement();
        String sql ="SELECT PRA_NUM, PRA_NOM, PRA_PRENOM FROM praticien";
        ResultSet rs=st.executeQuery(sql);
        while(rs.next()){
            toReturn.add(rs.getString("PRA_NUM") + ' ' +rs.getString("PRA_NOM") + ' ' + rs.getString("PRA_PRENOM"));
        }
        String[] toReturnFormatted = new String[toReturn.size()];
        toReturnFormatted = toReturn.toArray(toReturnFormatted);

        return toReturnFormatted;
    }

    /** R�cup�re tous les praticiens dont une lettre est compris dedans (Vue recherche de praticien) **/
    @Override
    public ArrayList<Praticien> findP(String name) throws SQLException {
        ArrayList<Praticien>listeTable=new ArrayList<Praticien>();
        ResultSet result=null;
        String req = "SELECT * FROM praticien WHERE PRA_NOM LIKE'" +name+"%' ORDER BY PRA_NOM";
        Statement stmt = connect.createStatement();
        result = stmt.executeQuery(req);

        while(result.next()){
            listeTable.add(new Praticien(result.getString(1),result.getString(2),result.getString(3),result.getString(4), result.getString(5),
                    result.getString(6),result.getString(7),result.getString(8)));
        }
        return listeTable;
    }

    /** Recup�re toutes les informations d'un praticien par son ID (Vue Fiche Praticien) **/
    public ArrayList<Praticien> praticien(String id) throws SQLException {
        ArrayList<Praticien>listeTable=new ArrayList<Praticien>();
        ResultSet result=null;
        String req = "SELECT * FROM praticien WHERE PRA_NUM = '"+id+"'";
        Statement stmt = connect.createStatement();
        result = stmt.executeQuery(req);

        while(result.next()){
            listeTable.add(new Praticien(result.getString(1),result.getString(2),result.getString(3),result.getString(4), result.getString(5),
                    result.getString(6),result.getString(7),result.getString(8)));
        }
        return listeTable;
    }

    /** R�cup�re la liste de tous les praticiens, avec toutes leurs infos (Vue Fiche Praticien - Bouton suivant/Pr�c�dent) **/
    public ArrayList<Praticien> fichePraticien() throws SQLException {
        ArrayList<Praticien>listeTable=new ArrayList<Praticien>();
        ResultSet result=null;
        String req = "SELECT * FROM praticien";
        Statement stmt = connect.createStatement();
        result = stmt.executeQuery(req);

        while(result.next()){
            listeTable.add(new Praticien(result.getString(1),result.getString(2),result.getString(3),result.getString(4), result.getString(5),
                    result.getString(6),result.getString(7),result.getString(8)));
        }
        return listeTable;
    }

    /** R�cup�re Nom et pr�nom d'un praticien par son ID (Vue consultation rapport - Affichage du praticien) **/
    public static String nomPraticien(String id_praticien) throws SQLException {

        String praticien_name = new String();
        ResultSet result = null;
        String req = "SELECT PRA_NOM, PRA_PRENOM from praticien WHERE PRA_NUM = '" + id_praticien + "'";
        Statement stmt =  connect.createStatement();
        result = stmt.executeQuery(req);

        if(result.next()){


            praticien_name = result.getString(1) +' ' + result.getString(2);

        }
        System.out.println(praticien_name);

        return praticien_name;

    }





}

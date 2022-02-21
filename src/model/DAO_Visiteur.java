package model;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import metiers.Visiteur;

public class DAO_Visiteur extends DAO<Visiteur> {

    // Variable global de l'user connecter
    public static String logUser;
    public static String logUserName;

    public DAO_Visiteur(Connection conn) {
        super(conn);
    }


    /** Fonction pour l'authentification des visiteurs (combinaison NOM/Date d'embauche) **/
    public Visiteur check(String pnom, String ppass) throws SQLException {
        Visiteur toReturn=null;
        Statement st=connect.createStatement();
        String sql ="SELECT * FROM visiteurs WHERE VIS_NOM='" +pnom+"' AND VIS_DATEEMBAUCHE='"+ppass+"'";
        ResultSet rs=st.executeQuery(sql);
        if(rs.next()){
            toReturn= new Visiteur (rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5),
                    rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));

            // R�cup�ration de l'user actuel
            logUser = rs.getString(1);
            logUserName = rs.getString(2);
        }
        return toReturn;
    }

    /** R�cup�re tous les visiteurs qui contiennent une certaine lettre (Vue recherche visiteur) **/
    @Override
    public ArrayList<Visiteur> findV(String name) throws SQLException {
        ArrayList<Visiteur>listeTable=new ArrayList<Visiteur>();
        ResultSet result=null;
        String req = "SELECT * FROM visiteurs WHERE VIS_NOM LIKE '" +name+"%' ORDER BY VIS_NOM";
        Statement stmt = connect.createStatement();
        result = stmt.executeQuery(req);

        while(result.next()){
            listeTable.add(new Visiteur(result.getString(1),result.getString(2),result.getString(3),result.getString(4), result.getString(5),
                    result.getString(6),result.getString(7),result.getString(8),result.getString(9)));
        }
        return listeTable;
    }

    /** R�cup�re toutes les infos sur un visiteur par son ID (vue fiche visiteur) **/
    public ArrayList<Visiteur> visiteur(String id) throws SQLException {
        ArrayList<Visiteur>listeTable=new ArrayList<Visiteur>();
        ResultSet result=null;
        String req = "SELECT * FROM visiteurs WHERE VIS_MATRICULE = '"+id+"'";
        Statement stmt = connect.createStatement();
        result = stmt.executeQuery(req);

        while(result.next()){
            listeTable.add(new Visiteur(result.getString(1),result.getString(2),result.getString(3),result.getString(4), result.getString(5),
                    result.getString(6),result.getString(7),result.getString(8),result.getString(9)));
        }
        return listeTable;
    }

    /** R�cup�re toutes les infos de tous les visiteurs (Vue fiche visiteur, btn pr�c�dent/ suivant) **/
    public ArrayList<Visiteur> ficheVisiteur() throws SQLException {
        ArrayList<Visiteur>listeTable=new ArrayList<Visiteur>();
        ResultSet result=null;
        String req = "SELECT * FROM visiteurs";
        Statement stmt = connect.createStatement();
        result = stmt.executeQuery(req);

        while(result.next()){
            listeTable.add(new Visiteur(result.getString(1),result.getString(2),result.getString(3),result.getString(4), result.getString(5),
                    result.getString(6),result.getString(7),result.getString(8),result.getString(9)));
        }
        return listeTable;
    }


}

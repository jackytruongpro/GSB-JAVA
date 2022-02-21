package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;
import java.util.Vector;


import metiers.Rapport;

public class DAO_Rapport extends DAO<Rapport> {

    public static int indice=0;

    public DAO_Rapport(Connection conn) {
        super(conn);
    }

    /**
     *  Fonction qui permet d'inserer dans la bdd le rapport
     * @param id C'est l'id du visiteur pour lequel on insert le rapport
     * @return
     */
    public static void creerRapport(String id, String pNum, String date, String bilan, String motif ) throws SQLException{
        Statement st = connect.createStatement();
        String req = "INSERT into rapport_visite VALUES ('"+id+"',null,'"+pNum+"','"+date+"','"+bilan+"', '"+motif+"')";
        st.execute(req);


    }

    /**
     *  Fonction qui permet d'inserer dans la bdd les echantillions
     * @param id C'est le mat du visiteur pour lequel on insert le rapport
     * @return
     */
    public static void offrir(String id,String nameMedic, String qte) throws SQLException{
        // On r�cup�re le dernier element ins�rer dans les rapports et on l'utilise
        Statement st = connect.createStatement();
        ResultSet result = st.executeQuery("SELECT LAST_INSERT_ID() FROM rapport_visite");
        String lastid = null;
        while(result.next()){
            lastid = result.getString(1);
        }


        Statement st2 = connect.createStatement();
        String req = "INSERT INTO offrir VALUES ('"+id+"','"+lastid+"','"+nameMedic+"','"+qte+"')";
        st.execute(req);

    }

    /** Fonction qui permet de r�cup�rer tous les rapport (Vue Consultation Rapport) **/
    public static Vector<String[]> getAllReport() {

        try {
            Hashtable table =((DAO_Famille)(DAO_Factory.getDAOFamille())).getAllFamille();
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        Vector<String[]> toReturn=new Vector<String[]>();

        try {
            Statement st=connect.createStatement();
            String rapport_visite ="SELECT RAP_NUM, PRA_NUM, RAP_DATE, RAP_BILAN, RAP_MOTIF FROM rapport_visite";
            ResultSet rs=st.executeQuery(rapport_visite);
            while(rs.next()){

                toReturn.addElement(new String []{rs.getString("RAP_NUM"), rs.getString("PRA_NUM") ,(String)(rs.getString("RAP_DATE")) ,rs.getString("RAP_BILAN") ,rs.getString("RAP_MOTIF")});


            }
        }
        catch(SQLException e) {

            e.printStackTrace();

        }



        return toReturn;
    }

    /** Compl�mentaire � getAllReport, permet de r�cup�r� tous les m�dicaments offerts **/
    public static Vector<String[]> getAllOffer(){

        try {
            Hashtable table =((DAO_Famille)(DAO_Factory.getDAOFamille())).getAllFamille();
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        Vector<String[]> toReturn=new Vector<String[]>();

        try {
            Statement st=connect.createStatement();
            String rapport_visite ="SELECT RAP_NUM, MED_DEPOTLEGAL, OFF_QTE FROM offrir";
            ResultSet rs=st.executeQuery(rapport_visite);
            while(rs.next()){

                toReturn.addElement(new String []{rs.getString("RAP_NUM"), rs.getString("MED_DEPOTLEGAL") ,(String)(rs.getString("OFF_QTE")) });


            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }



        return toReturn;
    }

    /** Permet de r�cup�rer les offre d'echantillons par rapport **/
    public static Vector<String[]> getAllMedicament(String id){
        Vector<String[]> toReturn=new Vector<String[]>();
        try {
            Statement st=connect.createStatement();
            String sql ="SELECT * FROM offrir WHERE offrir.RAP_NUM = '"+id+"'";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){

                toReturn.addElement(new String []{rs.getString("MED_DEPOTLEGAL"), rs.getString("OFF_QTE")});

            }

        }catch(SQLException e) {
            e.printStackTrace();
        }


        return toReturn;
    }


}

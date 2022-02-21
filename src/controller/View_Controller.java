package controller;

import view.*;
import view.includes.V_Footer;
import view.includes.V_Header;

public class View_Controller {
    /** Permet de controler l'affichage des fenêtres de notre application*/

    static String  toDraw=null;
    static V_Frame FA = new V_Frame();
    public static String id;
    public static int row;

    public static void main(String[] args) {
        try{
            drawNewView();

        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    /** Methodes pour rafraichir la fenêtre **/
    public static void setAnDrawNewView(String pToDraw){
        setToDraw(pToDraw);
        drawNewView();

    }
    public static void setToDraw(String pToDraw){
        toDraw = pToDraw;
    }
    public static void drawNewView(){
        if (toDraw==null){
            AuthentificationView();
        }else{
            switch (toDraw) {
                case "Menu":
                    MenuView();
                    break;
                case "Creer-Compte-rendus":
                    CompteR();
                    break;
                case "Voir-Compte-rendus":
                    VoirRapport();
                    break;
                case "Gestion des visiteurs":
                    SearchVisiteurView();
                    break;
                case "Gestion des praticiens":
                    SearchPraticienView();
                    break;
                case "Gestion des medicaments":
                    SearchMedicamentsView();
                    break;

                case "Fiche visiteur":
                    VisiteurFiche(id);
                    break;

                case "Fiche praticien":
                    PraticienFiche(id);
                    break;

            }

        }


    }

    /** Methodes permettant le passage à une nouvelle vue **/
    private static void AuthentificationView(){
        FA.setHeader(new V_Header("Veuillez vous authentifier"));
        FA.header_content();

        //New footer
        FA.setFooter(new V_Footer());
        FA.footer_content();

        //New corps
        FA.setCorps(new V_Authentification(FA));
        FA.corps();

        //Parametre de notre fenetre
        FA.setTitle("GSB - Galaxy Swiss Bourdin");
        FA.setVisible(true);
    }
    private static void MenuView(){
        V_Menu menu = new V_Menu(FA);
        V_Header menu_header = new V_Header("Menu Principal");
        FA.remove(FA.getCorps());
        FA.remove(FA.getHeader());
        FA.setCorps(menu);
        FA.setHeader(menu_header);
        FA.remake();
    }
    private static void CompteR(){
        V_CreerRapport reporting = new V_CreerRapport(FA);
        FA.remove(FA.getCorps());
        FA.remove(FA.getHeader());
        FA.setCorps(reporting);
        FA.setHeader(new V_Header("Créer un compte-rendu"));
        FA.remake();
    }
    private static void VoirRapport(){
        V_ConsultationRapport reporting = new V_ConsultationRapport(FA);
        FA.remove(FA.getCorps());
        FA.remove(FA.getHeader());
        FA.setCorps(reporting);
        FA.setHeader(new V_Header("Consulter les comptes-rendus"));
        FA.remake();
    }
    private static void SearchVisiteurView(){
        V_RechercheVisiteur visiteurs = new V_RechercheVisiteur(FA);
        FA.remove(FA.getCorps());
        FA.remove(FA.getHeader());
        FA.setCorps(visiteurs);
        FA.setHeader(new V_Header("Gestion des visiteurs"));
        FA.remake();
    }
    private static void SearchPraticienView(){
        V_RecherchePraticien practiciens = new V_RecherchePraticien(FA);
        FA.remove(FA.getCorps());
        FA.remove(FA.getHeader());
        FA.setCorps(practiciens);
        FA.setHeader(new V_Header("Gestion des praticiens"));
        FA.remake();
    }
    private static void SearchMedicamentsView(){
        V_FicheMedicament medicaments = new V_FicheMedicament(FA);
        FA.remove(FA.getCorps());
        FA.remove(FA.getHeader());
        FA.setCorps(medicaments);
        FA.setHeader(new V_Header("Gestion des medicaments"));
        FA.remake();
    }
    private static void VisiteurFiche(String id){
        V_FicheVisiteur visiteurFiche = new V_FicheVisiteur(FA,id);
        FA.remove(FA.getCorps());
        FA.remove(FA.getHeader());
        FA.setCorps(visiteurFiche);
        FA.setHeader(new V_Header("Fiche du visiteur n°"+id));
        FA.remake();
    }
    private static void PraticienFiche(String id){
        V_FichePraticien praticienFiche = new V_FichePraticien(FA,id);
        FA.remove(FA.getCorps());
        FA.remove(FA.getHeader());
        FA.setCorps(praticienFiche);
        FA.setHeader(new V_Header("Fiche du praticien n°"+id));
        FA.remake();
    }

}

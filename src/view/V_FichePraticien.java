package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controller.View_Controller;
import model.DAO_Factory;
import model.DAO_Praticien;
import metiers.Praticien;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

public class V_FichePraticien extends JPanel {
    private static final long serialVersionUID = -7343515360325589254L;

    /** Panel l�gende et informations praticien **/
    private JPanel panel_gauche = new JPanel();
    private JPanel panel_droite = new JPanel();

    /** Init. des zones contenant les infos des diff�rentes fiches praticien **/
    private JTextField nom_field;
    private JTextField prenom_field;
    private JTextField adresse_field;
    private JTextField cp_field;
    private JTextField ville_field;
    private JTextField coef_field;
    private JTextField code_field;
    private JTextField pranum_field;


    /** Constructeur de la classe - Initialise l'interface de visualisation de la fiche des visiteurs **/
    public V_FichePraticien(V_Frame menu, String id)   {

        setBounds(100,100,720,423);
        setLayout(null);

        DAO_Praticien praticien = (DAO_Praticien) DAO_Factory.getDAOPraticien();

        try {

            ArrayList<Praticien> result  = praticien.praticien(id);
            ArrayList<Praticien> fiche = praticien.fichePraticien();

            panel_zone();
            ville_zone(result);
            adresse_zone(result);
            nom_zone(result);
            pranum_zone(result);
            coeff_zone(result);
            code_zone(result);
            cp_zone(result);
            prenom_zone(result);
            action_zone(fiche);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /** Initialisation des panels **/
    public void panel_zone(){

        panel_droite = new JPanel();
        panel_droite.setBackground(new Color(255, 255, 255));
        panel_droite.setLayout(null);
        add(panel_droite, BorderLayout.CENTER);
        panel_droite.setSize( 2000, 1000 );


        /** Bande bleu gauche **/
        panel_gauche = new JPanel();
        panel_gauche.setBounds(0, 0, 93, 303);
        panel_gauche.setBackground(new Color(47, 146, 159));
        panel_gauche.setLayout(null);
        panel_droite.add(panel_gauche);
        panel_gauche.setSize( 110, 1000 );

    }

    /** Zone d'affichage de la ville du praticien **/
    public void ville_zone(ArrayList<Praticien> result){

        JLabel lblVille = new JLabel("Ville :");
        lblVille.setBounds(13, 145, 46, 14);
        panel_gauche.add(lblVille);
        lblVille.setForeground(Color.BLACK);

        ville_field = new JTextField(result.get(0).getVille());
        ville_field.setBounds(191, 143, 134, 20);
        panel_droite.add(ville_field);
        ville_field.setEditable(false);
        ville_field.setColumns(10);

    }

    /** Zone d'affichage de l'adresse du praticien **/
    public void adresse_zone(ArrayList<Praticien> result){

        JLabel lblAdresse = new JLabel("Adresse : ");
        lblAdresse.setBounds(13, 101, 64, 14);
        panel_gauche.add(lblAdresse);
        lblAdresse.setForeground(Color.BLACK);

        adresse_field = new JTextField(result.get(0).getAddrs());
        adresse_field.setBounds(126, 100, 199, 20);
        panel_droite.add(adresse_field);
        adresse_field.setEditable(false);
        adresse_field.setColumns(10);
    }

    /** Zone d'affichage du nom du praticien **/
    public void nom_zone(ArrayList<Praticien> result){

        JLabel lblNom = new JLabel("Nom :");
        lblNom.setBounds(13, 60, 46, 14);
        panel_gauche.add(lblNom);
        lblNom.setForeground(Color.BLACK);

        nom_field = new JTextField(result.get(0).getNom());
        nom_field.setBounds(126, 58, 111, 20);
        nom_field.setEditable(false);
        nom_field.setColumns(10);
        panel_droite.add(nom_field);

    }

    /** Zone d'affichage de l'ID du praticien (cl� primaire) **/
    public void pranum_zone(ArrayList<Praticien> result){

        JLabel lblNum = new JLabel("Pra num : ");
        lblNum.setBounds(13, 23, 64, 14);
        panel_gauche.add(lblNum);
        lblNum.setForeground(Color.BLACK);

        pranum_field = new JTextField(result.get(0).getNum());
        pranum_field.setEditable(false);
        pranum_field.setColumns(10);
        pranum_field.setBounds(126, 20, 40, 20);
        panel_droite.add(pranum_field);

    }

    /** Zone d'affichage du coeff de notoriete du praticien **/
    public void coeff_zone(ArrayList<Praticien> result){

        JLabel lblCoefNotoriet = new JLabel("Coef :");
        lblCoefNotoriet.setForeground(Color.BLACK);
        lblCoefNotoriet.setBounds(13, 181, 70, 14);
        panel_gauche.add(lblCoefNotoriet);

        coef_field = new JTextField(result.get(0).getLabCode());
        coef_field.setBounds(126, 178, 46, 20);
        coef_field.setEditable(false);
        coef_field.setColumns(10);
        panel_droite.add(coef_field);

    }

    /** Zone d'affichage du type code du praticien **/
    public void code_zone(ArrayList<Praticien> result){

        JLabel lblCode = new JLabel("Type code :");
        lblCode.setForeground(Color.BLACK);
        lblCode.setBounds(13, 210, 64, 14);
        panel_gauche.add(lblCode);

        code_field = new JTextField(result.get(0).getSecCode());
        code_field.setBounds(126, 209, 46, 20);
        panel_droite.add(code_field);
        code_field.setEditable(false);
        code_field.setColumns(10);

    }

    /** Zone d'affichage du CP du praticien **/
    public void cp_zone(ArrayList<Praticien> result){

        cp_field = new JTextField(result.get(0).getCP());
        cp_field.setBounds(126, 143, 53, 20);
        panel_droite.add(cp_field);
        cp_field.setEditable(false);
        cp_field.setColumns(10);

    }

    /** Zone d'affichage du prenom du praticien **/
    public void prenom_zone(ArrayList<Praticien> result) {

        JLabel prenom_lbl = new JLabel("Pr\u00E9nom :");
        prenom_lbl.setBounds(261, 61, 64, 14);
        panel_droite.add(prenom_lbl);

        prenom_field = new JTextField(result.get(0).getPrenom());
        prenom_field.setBounds(335, 58, 111, 20);
        panel_droite.add(prenom_field);
        prenom_field.setEditable(false);
        prenom_field.setColumns(10);


    }

    /** Zone de param. des diff�rents boutons de la vue **/
    public void action_zone(ArrayList<Praticien> fiche) {

        /** Retour Recherche Praticien **/
        JButton btnQuitter = new JButton(" Retour ");
        btnQuitter.setForeground(Color.BLACK);
        btnQuitter.setBorder(new LineBorder(new Color(0,0,0)));
        btnQuitter.setBackground(new Color(255, 150, 100));
        btnQuitter.setBounds(523, 262, 97, 25);
        panel_droite.add(btnQuitter);
        btnQuitter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                View_Controller.setAnDrawNewView("Gestion des praticiens");
            }
        });

        /** Voir la fiche du praticien pr�cedent **/
        JButton btnPrcdent = new JButton("Pr\u00E9c\u00E9dent");
        btnPrcdent.setForeground(Color.BLACK);
        btnPrcdent.setBorder(new LineBorder(new Color(0,0,0)));
        btnPrcdent.setBackground(new Color(255, 150, 100));
        btnPrcdent.setBounds(241, 262, 97, 25);
        panel_droite.add(btnPrcdent);


        btnPrcdent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent p) {
                if(View_Controller.row-1 > 0){
                    View_Controller.row --;
                    View_Controller.id = fiche.get(View_Controller.row-1).getNum();
                    View_Controller.setAnDrawNewView("Fiche praticien");

                }else{
                    btnPrcdent.setEnabled(false);
                    JOptionPane.showMessageDialog(panel_droite,"Aucun autre r�sultat. ");
                }
            }
        });

        /** Voir la fiche du praticien suivant **/
        JButton btnSuivant = new JButton("Suivant");
        btnSuivant.setForeground(Color.BLACK);
        btnSuivant.setBorder(new LineBorder(new Color(0,0,0)));
        btnSuivant.setBackground(new Color(255, 150, 100));
        btnSuivant.setBounds(367, 262, 97, 25);
        panel_droite.add(btnSuivant);
        btnSuivant.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent s) {
                if(View_Controller.row < fiche.size()){
                    View_Controller.id = fiche.get(View_Controller.row).getNum();
                    View_Controller.setAnDrawNewView("Fiche praticien");
                    View_Controller.row ++;

                }else{
                    btnSuivant.setEnabled(false);
                    JOptionPane.showMessageDialog(panel_droite,"Aucun autre r�sultat. ");
                }
            }
        });

    }

}

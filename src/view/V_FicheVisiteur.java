package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controller.View_Controller;
import model.DAO_Factory;
import model.DAO_Visiteur;
import metiers.Visiteur;

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


public class V_FicheVisiteur extends JPanel {
    private static final long serialVersionUID = -7343515360325589254L;

    /** Panel l�gende et informations praticien **/
    private JPanel panel_gauche = new JPanel();
    private JPanel panel_droite = new JPanel();

    /** Init. des zones contenant les infos des diff�rentes fiches visiteurs **/
    private JTextField nom_field;
    private JTextField prenom_field;
    private JTextField adresse_field;
    private JTextField cp_field;
    private JTextField ville_field;
    private JTextField secteur_field;
    private JTextField labo_field;
    private JTextField matricule_field;

    /** Constructeur de la classe - Initialise l'interface de visualisation de la fiche des visiteurs **/
    public V_FicheVisiteur(V_Frame menu, String id) {

        setBounds(100,100,720,423);
        setLayout(null);

        DAO_Visiteur visiteur = (DAO_Visiteur) DAO_Factory.getDAOVisiteur();

        try {
            ArrayList<Visiteur> result = visiteur.visiteur(id);
            ArrayList<Visiteur> fiche = visiteur.ficheVisiteur();

            panel_zone();
            ville_zone(result);
            adresse_zone(result);
            nom_zone(result);
            matricule_zone(result);
            secteur_zone(result);
            labo_zone(result);
            cp_zone(result);
            prenom_zone(result);
            action_zone(fiche);

        } catch (SQLException e1) {
            e1.printStackTrace();
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

    /** Zone d'affichage de la ville du visiteur **/
    public void ville_zone(ArrayList<Visiteur> result){

        JLabel lblVille = new JLabel("Ville :");
        lblVille.setBounds(13, 145, 46, 14);
        lblVille.setForeground(Color.BLACK);
        panel_gauche.add(lblVille);

        ville_field = new JTextField(result.get(0).getVille());
        ville_field.setBounds(191, 143, 134, 20);
        ville_field.setEditable(false);
        ville_field.setColumns(10);
        panel_droite.add(ville_field);
        

    }

    /** Zone d'affichage de l'adresse du visiteur **/
    public void adresse_zone(ArrayList<Visiteur> result){

        JLabel lblAdresse = new JLabel("Adresse : ");
        lblAdresse.setBounds(13, 101, 64, 14);
        lblAdresse.setForeground(Color.BLACK);
        panel_gauche.add(lblAdresse);

        adresse_field = new JTextField(result.get(0).getAddrs());
        adresse_field.setBounds(126, 100, 199, 20);
        adresse_field.setEditable(false);
        adresse_field.setColumns(10);
        panel_droite.add(adresse_field);

    }

    /** Zone d'affichage du nom du visiteur **/
    public void nom_zone(ArrayList<Visiteur> result){

        JLabel lblNom = new JLabel("Nom :");
        lblNom.setBounds(13, 60, 46, 14);
        lblNom.setForeground(Color.BLACK);
        panel_gauche.add(lblNom);

        nom_field = new JTextField(result.get(0).getNom());
        nom_field.setBounds(126, 58, 111, 20);
        panel_droite.add(nom_field);
        nom_field.setEditable(false);
        nom_field.setColumns(10);

    }

    /** Zone d'affichage du matricule du visiteur **/
    public void matricule_zone(ArrayList<Visiteur> result){

        JLabel lblNum = new JLabel("Matricule : ");
        lblNum.setBounds(13, 23, 64, 14);
        panel_gauche.add(lblNum);
        lblNum.setForeground(Color.BLACK);

        matricule_field = new JTextField(result.get(0).getMat());
        matricule_field.setEditable(false);
        matricule_field.setColumns(10);
        matricule_field.setBounds(126, 20, 40, 20);
        panel_droite.add(matricule_field);

    }

    /** Zone d'affichage du secteur de travail du visiteur **/
    public void secteur_zone(ArrayList<Visiteur> result){

        JLabel lblSecteur = new JLabel("Sec code :");
        lblSecteur.setForeground(Color.BLACK);
        lblSecteur.setBounds(13, 181, 70, 14);
        panel_gauche.add(lblSecteur);

        secteur_field = new JTextField(result.get(0).getLabCode());
        secteur_field.setBounds(126, 178, 46, 20);
        panel_droite.add(secteur_field);
        secteur_field.setEditable(false);
        secteur_field.setColumns(10);
    }

    /** Zone d'affichage du laboratoire du visiteur **/
    public void labo_zone(ArrayList<Visiteur> result){

        JLabel lblLabo = new JLabel("Lab code :");
        lblLabo.setForeground(Color.BLACK);
        lblLabo.setBounds(13, 210, 64, 14);
        panel_gauche.add(lblLabo);

        labo_field = new JTextField(result.get(0).getSecCode());
        labo_field.setBounds(126, 209, 46, 20);
        panel_droite.add(labo_field);
        labo_field.setEditable(false);
        labo_field.setColumns(10);
    }

    /** Zone d'affichage du code postal du visiteur **/
    public void cp_zone(ArrayList<Visiteur> result){

        cp_field = new JTextField(result.get(0).getCP());
        cp_field.setBounds(126, 143, 53, 20);
        panel_droite.add(cp_field);
        cp_field.setEditable(false);
        cp_field.setColumns(10);

    }

    /** Zone d'affichage du prenom du visiteur **/
    public void prenom_zone(ArrayList<Visiteur> result){

        JLabel lblPrenom = new JLabel("Pr\u00E9nom :");
        lblPrenom.setBounds(261, 61, 64, 14);
        panel_droite.add(lblPrenom);

        prenom_field = new JTextField(result.get(0).getPrenom());
        prenom_field.setBounds(335, 58, 111, 20);
        panel_droite.add(prenom_field);
        prenom_field.setEditable(false);
        prenom_field.setColumns(10);

    }

    /** Zone de param. des diff�rents boutons de la vue **/
    public void action_zone(ArrayList<Visiteur> fiche){

        /** Retour Recherche Visiteur **/
        JButton btnQuitter = new JButton(" Retour ");
        btnQuitter.setForeground(Color.BLACK);
        btnQuitter.setBorder(new LineBorder(new Color(0,0,0)));
        btnQuitter.setBackground(new Color(255, 150, 100));
        btnQuitter.setBounds(521, 263, 97, 25);
        panel_droite.add(btnQuitter);
        btnQuitter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                View_Controller.setAnDrawNewView("Gestion des visiteurs");
            }
        });

        /** Voir la fiche du visiteur suivant **/
        JButton btnSuivant = new JButton(" Suivant ");
        btnSuivant.setForeground(Color.BLACK);
        btnSuivant.setBorder(new LineBorder(new Color(0,0,0)));
        btnSuivant.setBackground(new Color(255, 150, 100));
        btnSuivant.setBounds(368, 263, 97, 25);
        panel_droite.add(btnSuivant);

        btnSuivant.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent s) {
                if(View_Controller.row+1 < fiche.size()){
                    View_Controller.id = fiche.get(View_Controller.row+1).getMat();
                    View_Controller.setAnDrawNewView("Fiche visiteur");
                    View_Controller.row ++;
                }else{
                    btnSuivant.setEnabled(false);
                    JOptionPane.showMessageDialog(panel_droite,"Aucun autre r�sultat. ");
                }
            }
        });

        /** Voir la fiche du visiteur pr�cedent **/
        JButton btnPrcdent = new JButton("Pr\u00E9c\u00E9dent");
        btnPrcdent.setForeground(Color.BLACK);
        btnPrcdent.setBorder(new LineBorder(new Color(0,0,0)));
        btnPrcdent.setBackground(new Color(255, 150, 100));
        btnPrcdent.setBounds(243, 263, 97, 25);
        panel_droite.add(btnPrcdent);


        btnPrcdent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent p) {
                if(View_Controller.row > 0){
                    View_Controller.id = fiche.get(View_Controller.row-1).getMat();
                    View_Controller.setAnDrawNewView("Fiche visiteur");
                    View_Controller.row --;

                }else{
                    btnPrcdent.setEnabled(false);
                    JOptionPane.showMessageDialog(panel_droite,"Aucun autre r�sultat. ");
                }
            }
        });
    }

}



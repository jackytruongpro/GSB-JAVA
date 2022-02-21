package view;


import javax.swing.JPanel;

import controller.View_Controller;


import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class V_Menu extends JPanel{

    private static final long serialVersionUID = 1L;
    private String purl;

    /** Liste des différents noms de boutons du menu == use case (obviously) **/
    String[] listName = {"Compte-rendus","Visiteurs","Praticiens","Médicaments","Quitter"};
    
    

    /**Constructeur du menu - Affiche les différents boutons menant vers les différentes fonctionnalités **/
    public V_Menu(V_Frame PFA){

        setLayout(null);
        panel_zone();
        label_zone();
        CR_zone();
        Visiteur_zone();
        Praticien_zone();
        Medicament_zone();
        Quitter_zone();
    }
    

    /** Init. du Jpanel + Logo GSB **/
    public void panel_zone() {

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 150, 440);
        panel.setBackground(new Color(47, 146, 159));
        add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel();
        lblNewLabel.setIcon(new ImageIcon(V_Menu.class.getResource("/view/img/logo-gsb.png")));
        lblNewLabel.setBounds(30, 179, 106, 83);
        panel.add(lblNewLabel);
    }

    /** Création dynamique des labels des differents boutons (boucle) **/
    public void label_zone() {

        int pos = 15;
        for(int i = 0; i < 5; i++){
            String s = listName[i];
            JLabel t = new JLabel(s);
            t.setBounds(290, pos, 160, 75);
            t.setFont(new Font("Thoma", Font.BOLD, 18));
            pos += 85;
            add(t);
        }

    }

    /** Bouton Menu Principal -> Compte - Rendus **/
    public void CR_zone() {

        JButton compteRendusBtn = new JButton(image("compte-rendu.png"));
        compteRendusBtn.setBorderPainted(false);
        compteRendusBtn.setContentAreaFilled(false);
        compteRendusBtn.setFocusPainted(false);
        compteRendusBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent Clic) {
                View_Controller.setAnDrawNewView("Creer-Compte-rendus");
            }
        });
        compteRendusBtn.setBounds(200, 15, 70, 70);
        add(compteRendusBtn);
        compteRendusBtn.setFocusPainted(false);

    }

    /** Bouton Menu Principal -> Recherche Visiteur **/
    public void Visiteur_zone(){

        JButton visiteursBtn = new JButton(image("visiteurs.png"));
        visiteursBtn.setBorderPainted(false);
        visiteursBtn.setContentAreaFilled(false);
        visiteursBtn.setFocusPainted(false);
        visiteursBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                View_Controller.setAnDrawNewView("Gestion des visiteurs");
            }
        });
        visiteursBtn.setBounds(200, 100, 70, 70);
        add(visiteursBtn);
        visiteursBtn.setFocusPainted(false);

    }

    /** Bouton Menu Principal -> Recherche Praticien **/
    public void Praticien_zone(){

        JButton practiciensBtn = new JButton(image("practiciens.png"));
        practiciensBtn.setBorderPainted(false);
        practiciensBtn.setContentAreaFilled(false);
        practiciensBtn.setFocusPainted(false);
        practiciensBtn.setBounds(200, 185, 70, 70);
        add(practiciensBtn);
        practiciensBtn.setFocusPainted(false);
        practiciensBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                View_Controller.setAnDrawNewView("Gestion des praticiens");
            }
        });

    }

    /** Bouton Menu Principal -> Consultation médicament **/
    public void Medicament_zone(){

        JButton medicamentsBtn = new JButton(image("medicaments.png"));
        medicamentsBtn.setBorderPainted(false);
        medicamentsBtn.setContentAreaFilled(false);
        medicamentsBtn.setFocusPainted(false);
        medicamentsBtn.setBounds(200, 270, 70, 70);
        add(medicamentsBtn);
        medicamentsBtn.setFocusPainted(false);

        medicamentsBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                View_Controller.setAnDrawNewView("Gestion des medicaments");
            }
        });

    }

    /** Bouton Menu Principal -> Authentification (Deconnexion) **/
    public void Quitter_zone(){

        JButton btnQuitter = new JButton(image("deco.png"));
        btnQuitter.setBorderPainted(false);
        btnQuitter.setContentAreaFilled(false);
        btnQuitter.setFocusPainted(false);
        btnQuitter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent quitter) {
                System.exit(0);
            }
        });
        btnQuitter.setBounds(200, 355, 70, 70);
        add(btnQuitter);
        btnQuitter.setFocusPainted(false);

    }

    /** Création dynamique des PATH des différentes images associés aux boutons **/
    private ImageIcon image(String img){
        purl = "/view/img/icons/";
        ImageIcon image = new ImageIcon(this.getClass().getResource(purl+img));
        return image;
    }
}

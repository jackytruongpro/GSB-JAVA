package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import model.DAO_Factory;
import model.DAO_Visiteur;
import metiers.Visiteur;
import controller.View_Controller;
import javax.swing.border.LineBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class V_Authentification extends JPanel {

    private static final long serialVersionUID = -7305664800426191162L;
    private JTextField ndc_entry;
    private JPasswordField mdp_entry;
    private V_Frame FA;
    private JPanel auth_panel = new JPanel();

    /** Constructeur de la classe - Initialise l'interface de connexion **/
    public V_Authentification(V_Frame PFA){
        FA = PFA;
        panel_init();
        ndc_zone();
        mdp_zone();
        logo_zone();
        btn_zone();
    }

    /** Initialise les diff�rents panels de la vue **/
    public void panel_init(){

        JPanel connect = this;
        connect.setBounds(100,100,720,468);
        connect.setBackground(Color.WHITE);
        setLayout(new BorderLayout(0, 0));

        JPanel auth_container = new JPanel();
        auth_container.setBackground(new Color(47, 146, 159));
        auth_container.setLayout(null);
        add(auth_container, BorderLayout.CENTER);

        auth_panel = new JPanel();
        auth_panel.setBorder(new LineBorder(new Color(0, 0, 0)));
        auth_panel.setBackground(new Color(231,231,231));
        auth_panel.setBounds(161, 89, 414, 257);
        auth_panel.setLayout(null);
        auth_container.add(auth_panel);


    }

    /** Initialise le label et l'entry pour le nom de compte **/
    public void ndc_zone(){

        JLabel ndc_label = new JLabel("Nom :");
        ndc_label.setForeground(Color.BLACK);
        ndc_label.setBounds(58, 28, 160, 32);
        ndc_label.setIcon(new ImageIcon(V_Authentification.class.getResource("/view/img/icons/auth/user.png")));
        ndc_label.setFont(new Font("Arial", Font.PLAIN, 17));
        auth_panel.add(ndc_label);


        ndc_entry = new JTextField("Villechalane");
        ndc_entry.setBounds(97, 59, 232, 20);
        ndc_entry.setColumns(20);
        auth_panel.add(ndc_entry);


    }

    /** Initialise le label et l'entry pour le mot de passe **/
    public void mdp_zone(){

        JLabel mdp_label = new JLabel(" Mot de passe :");
        mdp_label.setForeground(Color.BLACK);
        mdp_label.setBounds(58, 96, 286, 32);
        mdp_label.setIcon(new ImageIcon(V_Authentification.class.getResource("/view/img/icons/auth/password.png")));
        mdp_label.setFont(new Font("Arial", Font.PLAIN, 17));
        auth_panel.add(mdp_label);


        mdp_entry = new JPasswordField("1992-12-11");
        mdp_entry.setBounds(98, 139, 231, 20);
        auth_panel.add(mdp_entry);

        mdp_entry.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                    logged();
                }
            }
        });

    }

    /** Initialise le logo GSB **/
    public void logo_zone(){


        JLabel logo_gsb = new JLabel();
        logo_gsb.setBounds(320, -12, 100, 85);
        logo_gsb.setFont(new Font("Tahoma", Font.PLAIN, 5));
        logo_gsb.setBackground(Color.DARK_GRAY);
        logo_gsb.setIcon(new ImageIcon(V_Authentification.class.getResource("/view/img/logo-gsb.png")));
        auth_panel.add(logo_gsb);

    }


    /** Initialise le bouton de connexion **/
    public void btn_zone(){


        JButton connect_btn = new JButton("Connexion");
        connect_btn.setForeground(Color.BLACK);
        connect_btn.setBorder(new LineBorder(new Color(0,0,0)));
        connect_btn.setBackground(new Color(255, 150, 100));
        connect_btn.setBounds(98, 208, 231, 23);
        auth_panel.add(connect_btn);

        connect_btn.addActionListener(new EcouteurBoutonConnection());
    }

    /** ActionListener du bouton de connexion **/
    public class EcouteurBoutonConnection implements ActionListener{
        public void actionPerformed(ActionEvent clic){
            logged();
        }
    }

    /** V�rifie si il existe une correspondance au duo ndc/mdp dans la BDD via la methode check de la classe DAO_Visiteur **/
    private void logged(){
        Visiteur toReturn = null;
        DAO_Visiteur tVisiteur = (DAO_Visiteur) DAO_Factory.getDAOVisiteur();
        try {
            toReturn = tVisiteur.check(ndc_entry.getText(), String.valueOf(mdp_entry.getPassword()));
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        if (toReturn!=null){
            View_Controller.setAnDrawNewView("Menu");

        }else{
            JOptionPane.showMessageDialog(FA,"Nom ou mot de passe incorrect, veuillez réessayez");
        }
    }
}

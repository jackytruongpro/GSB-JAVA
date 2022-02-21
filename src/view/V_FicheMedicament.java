package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import controller.View_Controller;
import java.awt.Color;
import model.DAO_Factory;
import model.DAO_Medicament;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class V_FicheMedicament extends JPanel {

    private static final long serialVersionUID = 1L;
    private Vector<String[]> medicament;
    private int indice=0;

    /** Init. des zones contenant les infos des diff�rents m�dicaments **/
    private JTextArea code_field = new JTextArea();
    private JTextArea name_field = new JTextArea();
    private JTextArea composition_field = new JTextArea();
    private JTextArea family_field = new JTextArea();
    private JTextArea effect_field = new JTextArea();
    private JTextArea indication_field = new JTextArea();
    private JTextArea price_field = new JTextArea();

    /** Init. du changement de m�dicament **/
    private JButton btn_Suivant;
    private JButton btn_Precedent;
    

    /** Constructeur de la classe - Initialise l'interface de visualisation des m�dicaments **/
    public V_FicheMedicament(V_Frame menu){

        setBounds(100,100,720,423);
        setLayout(null);
        setBackground (new Color(47, 146, 159));

        DAO_Medicament temp = (DAO_Medicament) (DAO_Factory.getDAOMedicament());
        try {
            medicament= temp.getAllMedicaments();
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        code_zone();
        nom_zone();
        composition_zone();
        famille_zone();
        effet_zone();
        Ci_zone();
        prix_zone();
        action_zone();

    }

    /** Zone d'affichage du code du m�dicament **/
    public void code_zone(){

        code_field = new JTextArea();
        code_field.setLineWrap(true);
        code_field.setWrapStyleWord(true);
        code_field.setText(medicament.elementAt(indice)[0]);
        code_field.setBounds(175, 10, 100, 22);
        code_field.setEditable(false);
        add(code_field);

        JLabel lbl_Code = new JLabel("Code :");
        lbl_Code.setBounds(40, 10, 56, 16);
        add(lbl_Code);

    }

    /** Zone d'affichage du nom du m�dicament **/
    public void nom_zone(){

        JLabel lbl_name = new JLabel("Nom commercial :");
        lbl_name.setBounds(40, 40, 121, 16);
        add(lbl_name);

        name_field = new JTextArea();
        name_field.setLineWrap(true);
        name_field.setWrapStyleWord(true);
        name_field.setText(medicament.elementAt(indice)[1]);
        name_field.setBounds(175, 40, 150, 22);
        name_field.setEditable(false);
        add(name_field);

    }

    /** Zone d'affichage de la composition du m�dicament **/
    public void composition_zone(){

        composition_field = new JTextArea();
        composition_field.setWrapStyleWord(true);
        composition_field.setLineWrap(true);
        composition_field.setText(medicament.elementAt(indice)[3]);
        composition_field.setBounds(175, 120, 500, 22);
        composition_field.setEditable(false);
        add(composition_field);

        JLabel lbl_Composition = new JLabel("Composition :");
        lbl_Composition.setBounds(40, 120, 121, 16);
        add(lbl_Composition);

    }

    /** Zone d'affichage de la famille du m�dicament **/
    public void famille_zone(){

        JLabel lbl_Famille = new JLabel("Famille :");
        lbl_Famille.setBounds(40, 80, 121, 16);
        add(lbl_Famille);

        family_field = new JTextArea();
        family_field.setBounds(175, 80, 350, 22);
        family_field.setText(medicament.elementAt(indice)[2]);
        family_field.setEditable(false);
        add(family_field);

    }

    /** Zone d'affichage des effets du m�dicament **/
    public void effet_zone(){

        effect_field = new JTextArea();
        effect_field.setEditable(false);
        effect_field.setLineWrap(true);
        effect_field.setWrapStyleWord(true);
        effect_field.setText(medicament.elementAt(indice)[4]);
        effect_field.setBounds(175, 160, 500, 75);
        effect_field.setEditable(false);
        add(effect_field);


        JScrollPane effect_scroll = new JScrollPane(effect_field);
        effect_scroll.setBounds(175, 160, 500, 75);
        add(effect_scroll);

        JLabel lbl_EffetsIndsirables = new JLabel("Effets ind\u00E9sirables :");
        lbl_EffetsIndsirables.setBounds(40, 160, 121, 16);
        add(lbl_EffetsIndsirables);

    }

    /** Zone d'affichage des contre indications du m�dicament **/
    public void Ci_zone(){

        JLabel lbl_ContreIndications = new JLabel("Contre Indications :");
        lbl_ContreIndications.setBounds(40, 250, 121, 16);
        add(lbl_ContreIndications);

        indication_field = new JTextArea();
        indication_field.setEditable(false);
        indication_field.setWrapStyleWord(true);
        indication_field.setLineWrap(true);
        indication_field.setText(medicament.elementAt(indice)[5]);
        indication_field.setBounds(175, 250, 500, 75);
        indication_field.setEditable(false);
        add(indication_field);


        JScrollPane indication_scroll = new JScrollPane(indication_field );
        indication_scroll.setBounds(175, 250, 500, 75);
        add(indication_scroll);

    }

    /** Zone d'affichage du prix du m�dicament **/
    public void prix_zone(){

        JLabel lbl_PrixEchantillon = new JLabel("Prix Echantillon :");
        lbl_PrixEchantillon.setBounds(40, 340, 121, 16);
        add(lbl_PrixEchantillon);

        price_field = new JTextArea();
        price_field.setText("15$");
        price_field.setLineWrap(true);
        price_field.setWrapStyleWord(true);
        price_field.setBounds(175, 340, 100, 22);
        price_field.setEditable(false);
        add(price_field);

    }

    /** Zone de gestion des boutons de la vue **/
    public void action_zone(){

        /** Retourner au menu principal **/
        JButton btn_Quitter = new JButton("Fermer");
        btn_Quitter.setForeground(Color.BLACK);
        btn_Quitter.setBorder(new LineBorder(new Color(0,0,0)));
        btn_Quitter.setBackground(new Color(255, 150, 100));
        btn_Quitter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                View_Controller.setAnDrawNewView("Menu");
            }
        });
        btn_Quitter.setBounds(600, 360, 97, 25);
        add(btn_Quitter);

        /** Revoir le m�dicament pr�c�dent **/
        btn_Precedent = new JButton("Pr\u00E9c\u00E9dent");
        btn_Precedent.setForeground(Color.BLACK);
        btn_Precedent.setBorder(new LineBorder(new Color(0,0,0)));
        btn_Precedent.setBackground(new Color(255, 150, 100));
        btn_Precedent.setEnabled(false);
        btn_Precedent.setBounds(300, 360, 97, 25);
        add(btn_Precedent);

        btn_Precedent.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (indice>0){
                    indice-=1;
                    code_field.setText(medicament.elementAt(indice)[0]);
                    name_field.setText(medicament.elementAt(indice)[1]);
                    composition_field.setText(medicament.elementAt(indice)[3]);
                    family_field.setText(medicament.elementAt(indice)[2]);
                    indication_field.setText(medicament.elementAt(indice)[5]);
                    effect_field.setText(medicament.elementAt(indice)[4]);
                    btn_Precedent.setEnabled(true);
                    btn_Suivant.setEnabled(true);

                }
                if (indice==0){
                    btn_Precedent.setEnabled(false);
                }
            }

        });

        /** Voir le m�dicament suivant **/
        btn_Suivant = new JButton("Suivant");
        btn_Suivant.setForeground(Color.BLACK);
        btn_Suivant.setBorder(new LineBorder(new Color(0,0,0)));
        btn_Suivant.setBackground(new Color(255, 150, 100));
        btn_Suivant.setBounds(405, 360, 97, 25);
        add(btn_Suivant);

        btn_Suivant.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (indice<medicament.size()){
                    indice+=1;
                    code_field.setText(medicament.elementAt(indice)[0]);
                    name_field.setText(medicament.elementAt(indice)[1]);
                    composition_field.setText(medicament.elementAt(indice)[3]);
                    family_field.setText(medicament.elementAt(indice)[2]);
                    indication_field.setText(medicament.elementAt(indice)[5]);
                    effect_field.setText(medicament.elementAt(indice)[4]);
                    btn_Suivant.setEnabled(true);
                    btn_Precedent.setEnabled(true);
                }
                if (indice==medicament.size()-1){
                    btn_Suivant.setEnabled(false);
                }
            }


        });



    }
}

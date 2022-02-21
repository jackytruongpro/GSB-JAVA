package view;

import javax.swing.JPanel;


import java.awt.Color;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.awt.event.ActionEvent;


import controller.View_Controller;


import model.DAO_Praticien;
import model.DAO_Rapport;


import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

public class V_ConsultationRapport extends JPanel {

    private static final long serialVersionUID = 1L;

    JTextField num_content = new JTextField();
    JTextField motif_content = new JTextField();
    JTextArea bilan_content = new JTextArea();
    JTable result_table = null;
    JComboBox<String> combo = null;
    String date;
    Vector<String[]> rapport_visite =  DAO_Rapport.getAllReport();

    int max_rapport = rapport_visite.size();
    Vector<String[]> offre_visite =  DAO_Rapport.getAllOffer();
    Vector<String[]> medicaments =  DAO_Rapport.getAllMedicament(rapport_visite.elementAt(DAO_Rapport.indice)[0]);
    int sizeVector = medicaments.size();

    /** Constructeur de la classe - Initialise l'interface de visionnage des rapports **/
    public V_ConsultationRapport(V_Frame menu) {

        setBackground(new Color(47, 146, 159));
        setBounds(100,100,720,423);
        setLayout(null);

        report_number_zone();
        praticien_zone();
        date_zone();
        bilan_zone();
        motif_zone();
        echantillon_zone();
        action_zone();
    }

    /** Zone contenant le numero du rapport **/
    public void report_number_zone(){

        JLabel lbl_num = new JLabel("Num\u00E9ro du Rapport :");
        lbl_num.setBounds(40, 10, 129, 16);
        add(lbl_num);

        num_content = new JTextField();
        num_content.setHorizontalAlignment(SwingConstants.RIGHT);
        num_content.setEditable(false);
        num_content.setBounds(200, 7, 116, 22);
        num_content.setColumns(10);
        num_content.setText(rapport_visite.elementAt(DAO_Rapport.indice)[0]);
        add(num_content);




    }

    /** Zone contenant le nom du praticien **/
    public void praticien_zone(){

        JLabel lbl_Praticien = new JLabel("Praticien :");
        lbl_Praticien.setBounds(40, 50, 119, 16);
        add(lbl_Praticien);



        JTextField praticien = new JTextField();
        praticien.setBounds(200, 50, 200, 22);
        praticien.setEditable(false);
        try {
            praticien.setText((DAO_Praticien.nomPraticien(rapport_visite.elementAt(DAO_Rapport.indice)[1])));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        add(praticien);

    }

    /** Zone contenant la date du rapport **/
    public void date_zone() {

        JLabel lbl_date = new JLabel("Date du Rapport :");
        lbl_date.setBounds(40, 90, 119, 16);
        add(lbl_date);
        String date = rapport_visite.elementAt(DAO_Rapport.indice)[2];
        Date date_n = null;


        // *** note that it's "yyyy-MM-dd hh:mm:ss" not "yyyy-mm-dd hh:mm:ss"
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        try {
            date_n = dt.parse(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // *** same for the format String below
        SimpleDateFormat dt1 = new SimpleDateFormat("dd-MM-yyyy");

        JTextField date_rapport = new JTextField();
        date_rapport.setBounds(200, 90, 125, 22);
        date_rapport.setText(dt1.format(date_n));
        date_rapport.setEditable(false);
        add(date_rapport);




    }

    /** Zone contenant le motif du rapport **/
    public void motif_zone(){

        JLabel lbl_Motif = new JLabel("Motif du Rapport :");
        lbl_Motif.setBounds(40, 130, 119, 16);
        add(lbl_Motif);

        motif_content = new JTextField();
        motif_content.setBounds(200, 130, 200, 22);
        motif_content.setText(rapport_visite.elementAt(DAO_Rapport.indice)[4]);
        motif_content.setEditable(false);
        add(motif_content);



    }

    /** Zone contenant le bilan de la visite **/
    public void bilan_zone() {

        JLabel lbl_Bilan = new JLabel("BILAN :");
        lbl_Bilan.setBounds(40, 170, 119, 16);
        add(lbl_Bilan);

        bilan_content = new JTextArea();
        bilan_content.setBounds(100, 170, 200, 150);
        bilan_content.setText(rapport_visite.elementAt(DAO_Rapport.indice)[3]);
        bilan_content.setLineWrap(true);
        bilan_content.setWrapStyleWord(true);
        bilan_content.setEditable(false);
        add(bilan_content);


    }

    /** Zone contenant les echantillons offerts lors de la visite **/
    public void echantillon_zone(){

        JLabel lbl_Echantillon = new JLabel("Offre d'\u00E9chantillons :");
        lbl_Echantillon.setBounds(340, 170, 119, 16);
        add(lbl_Echantillon);

        // MODEL
        final DefaultTableModel model = new DefaultTableModel();
        final DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        Object[][] o = new Object[sizeVector][2];
        for(int i = 0; i < sizeVector; i++){
            o[i][0] = medicaments.get(i)[0];
            o[i][1] = medicaments.get(i)[1];
        }
        // TABLE DATA
        model.setDataVector(o, new Object[]{"M\u00E9dicament","Qt\u00E9"});


        // TABLE
        result_table = new JTable(model);
        result_table.setBounds(475, 170, 200, 150);
        result_table.getColumnModel().getColumn(1).setMaxWidth(40);
        result_table.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
        result_table.setEnabled(false);
        add(result_table);


        // SCROLLPANE
        JScrollPane apne= new JScrollPane(result_table);
        apne.setBounds(475, 170, 200, 150);
        add(apne);


    }

    /** Zone contenant les actions des diff�rents boutons de la vue **/
    public void action_zone(){


        JButton btnRapportPrecedent = new JButton("Pr\u00E9c\u00E9dent");
        btnRapportPrecedent.setForeground(Color.BLACK);
        btnRapportPrecedent.setBorder(new LineBorder(new Color(0,0,0)));
        btnRapportPrecedent.setBackground(new Color(255, 150, 100));
        btnRapportPrecedent.setBounds(100, 360, 97, 25);
        btnRapportPrecedent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(DAO_Rapport.indice >= 1){
                    View_Controller.setAnDrawNewView("Voir-Compte-rendus");
                    DAO_Rapport.indice -= 1;
                    System.out.println(DAO_Rapport.indice);
                }else{
                    JOptionPane.showMessageDialog(null,"Aucun autre r�sultat. ");
                }
                View_Controller.setAnDrawNewView("Voir-Compte-rendus");
            }
        });
        add(btnRapportPrecedent);

        JButton btnSuivant = new JButton("Suivant");
        btnSuivant.setForeground(Color.BLACK);
        btnSuivant.setBorder(new LineBorder(new Color(0,0,0)));
        btnSuivant.setBackground(new Color(255, 150, 100));
        btnSuivant.setBounds(204, 360, 97, 25);
        btnSuivant.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(DAO_Rapport.indice);
                if(DAO_Rapport.indice < max_rapport-1){
                    DAO_Rapport.indice += 1;
                    View_Controller.setAnDrawNewView("Voir-Compte-rendus");
                }else{
                    JOptionPane.showMessageDialog(null,"Aucun autre r�sultat. ");
                }

            }
        });
        add(btnSuivant);

        JButton btnClose = new JButton("Fermer");
        btnClose.setForeground(Color.BLACK);
        btnClose.setBorder(new LineBorder(new Color(0,0,0)));
        btnClose.setBackground(new Color(255, 150, 100));
        btnClose.setBounds(517,360,117,25);
        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                View_Controller.setAnDrawNewView("Menu");
            }
        });
        add(btnClose);

    }
}


package view;

import com.toedter.calendar.JDateChooser;
import controller.View_Controller;
import model.DAO_Medicament;
import model.DAO_Praticien;
import model.DAO_Rapport;
import model.DAO_Visiteur;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.border.LineBorder;


public class V_CreerRapport extends JPanel {

    private static final long serialVersionUID = 1L;

    JTextField num_content = new JTextField();
    JDateChooser date_content = new JDateChooser();
    JTextField motif_content = new JTextField();
    JTextArea bilan_content = new JTextArea();
    JTable result_table = null;
    JComboBox<String> combo = null;
    JComboBox<String> comboBox = null;
    String date;

    /** Constructeur de la classe - Initialise l'interface de cr�ation de rapport **/
    public V_CreerRapport(V_Frame menu) {

        setBackground(new Color(47, 146, 159));
        setBounds(100,100,720,423);
        setLayout(null);

        praticien_zone();
        date_zone();
        bilan_zone();
        motif_zone();
        echantillon_zone();
        action_zone();
    }

    /** Zone de selection du praticien visit� **/
    public void praticien_zone(){


        JLabel lbl_Praticien = new JLabel("Praticien :");
        lbl_Praticien.setBounds(40, 50, 119, 16);
        add(lbl_Praticien);


        // COMBO Box DATA Praticien
        String[] position = null;
        try {
            position = DAO_Praticien.findname();
        }catch (SQLException e1) {
            e1.printStackTrace();
        }

        comboBox = new JComboBox<String>(position);
        comboBox.setSelectedIndex(-1);
        comboBox.setBounds(200, 50, 200, 22);
        add(comboBox);

    }

    /** Zone de selection de la date de visite **/
    public void date_zone(){

        JLabel lbl_date = new JLabel("Date du Rapport :");
        lbl_date.setBounds(40, 90, 119, 16);
        add(lbl_date);

        JDateChooser date_content = new JDateChooser();
        date_content.setBounds(200, 90, 125, 22);
        add(date_content);
        date_content.addPropertyChangeListener("date",new PropertyChangeListener() {

            public void propertyChange(PropertyChangeEvent e){
                JDateChooser chooser=(JDateChooser)e.getSource();
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                date=sdf.format(chooser.getDate());
            }

        });


    }

    /** Zone d'ecriture du motif de la visite **/
    public void motif_zone(){

        JLabel lbl_Motif = new JLabel("Motif du Rapport :");
        lbl_Motif.setBounds(40, 130, 119, 16);
        add(lbl_Motif);

        motif_content = new JTextField();
        motif_content.setBounds(200, 130, 200, 22);
        add(motif_content);



    }

    /** Zone d'�criture du bilan de la visite **/
    public void bilan_zone() {

        JLabel lbl_Bilan = new JLabel("BILAN :");
        lbl_Bilan.setBounds(40, 170, 119, 16);
        add(lbl_Bilan);

        bilan_content = new JTextArea();
        bilan_content.setBounds(100, 170, 200, 150);
        bilan_content.setLineWrap(true);
        bilan_content.setWrapStyleWord(true);
        add(bilan_content);


    }

    /** Zone de saisie des diff�rents m�dicaments offerts (JTable + Boutons d'ajout de lignes) **/
    public void echantillon_zone(){

        JLabel lbl_Echantillon = new JLabel("Offre d'\u00E9chantillons :");
        lbl_Echantillon.setBounds(340, 170, 119, 16);
        add(lbl_Echantillon);

        // MODEL
        final DefaultTableModel model = new DefaultTableModel();
        final DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);

        // TABLE DATA
        model.setDataVector(new Object[][] {null} ,new Object[]{"M\u00E9dicament","Qt\u00E9"});


        // TABLE
        result_table = new JTable(model);
        result_table.setBounds(475, 170, 200, 150);
        result_table.getColumnModel().getColumn(1).setMaxWidth(40);
        result_table.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
        add(result_table);



        // COMBO Box DATA Medicament
        String[] positions = null;
        try {
            positions = DAO_Medicament.findname();
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        combo = new JComboBox<String>(positions);

        // COMBO COLUMN
        TableColumn col = result_table.getColumnModel().getColumn(0);
        col.setCellEditor(new DefaultCellEditor(combo));

        // SCROLLPANE
        JScrollPane apne= new JScrollPane(result_table);
        apne.setBounds(475, 170, 200, 150);
        add(apne);


        JButton AddRow = new JButton("Ajouter");
        AddRow.setForeground(Color.WHITE);
        AddRow.setBorder(new LineBorder(new Color(255,255,255)));
        AddRow.setBackground(new Color(227, 9, 9));
        AddRow.setFont(new Font("Tahoma", Font.BOLD, 11));
        AddRow.setBounds(475, 140, 88, 25);
        add(AddRow);

        AddRow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.addRow(new Object[] {});

            }
        });

        JButton delRow = new JButton("Supprimer");
        delRow.setForeground(Color.WHITE);
        delRow.setBorder(new LineBorder(new Color(255,255,255)));
        delRow.setBackground(new Color(227, 9, 9));
        delRow.setFont(new Font("Tahoma", Font.BOLD, 11));
        delRow.setBounds(587, 140, 88, 25);
        add(delRow);

        delRow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row = result_table.getSelectedRow();
                if(row >= 0){
                    model.removeRow(row);
                    result_table.selectAll();
                    result_table.clearSelection();
                }
            }
        });

    }

    /** /** Zone contenant les actions des diff�rents boutons de la vue (Hors Echantillons) **/
    public void action_zone(){

        JButton btnliste = new JButton("Voir la liste des rapports");
        btnliste.setForeground(Color.BLACK);
        btnliste.setBorder(new LineBorder(new Color(0,0,0)));
        btnliste.setBackground(new Color(255, 150, 100));
        btnliste.setBounds(100, 360, 200, 26);
        btnliste.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                View_Controller.setAnDrawNewView("Voir-Compte-rendus");
            }
        });
        add(btnliste);

        JButton btnClose = new JButton("Fermer");
        btnClose.setForeground(Color.BLACK);
        btnClose.setBorder(new LineBorder(new Color(0,0,0)));
        btnClose.setBackground(new Color(255, 150, 100));
        btnClose.setBounds(575,360,97,25);
        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                View_Controller.setAnDrawNewView("Menu");
            }
        });
        add(btnClose);


        // Boutton sauvegarde et on save toutes les infos du formulaire
        JButton btnSave = new JButton("Sauvegarder");
        btnSave.setForeground(Color.BLACK);
        btnSave.setBorder(new LineBorder(new Color(0,0,0)));
        btnSave.setBackground(new Color(255, 150, 100));
        btnSave.setBounds(450, 360, 117, 25);
        btnSave.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                // Count pour savoir combien de fois la boucle for va inserer de medicament
                int count = result_table.getRowCount();
                //R�cup�ration de l'id de la session actuelle
                String visiteurId = DAO_Visiteur.logUser;

                // On r�cup�re le reste
                String motif = motif_content.getText();
                String bilan = bilan_content.getText();


                if(!bilan.equals("") && !motif.equals("") && comboBox.getSelectedIndex() != -1){
                    String pNum = comboBox.getSelectedItem().toString().substring(0, 2);

                    // On lance l'execution de la requette sql qui insert le rapport
                    try {
                        DAO_Rapport.creerRapport(visiteurId, pNum, date, bilan, motif);

                        // On lance l'execution de la requette sql qui insert les echantilions avec une boucle
                        for(int i=0; i< count; i++){
                            String medic = (String) result_table.getValueAt(i, 0);
                            String qte = (String) result_table.getValueAt(i, 1);
                            // Requette
                            DAO_Rapport.offrir(visiteurId, medic, qte);
                        }

                        JOptionPane.showMessageDialog(btnSave,"Le rapport a �t� ajouter avec succ�s");
                        View_Controller.setAnDrawNewView("Creer-Compte-rendus");
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                        JOptionPane.showMessageDialog(btnSave,"Erreur lors de l'insertion du rapport");
                    }

                    // On lance la requette sql qui insert les echantillions

                    // Boucle qui r�cup�re tout les medicaments ajout� et les qqt

                }else{
                    JOptionPane.showMessageDialog(btnSave,"Veuillez remplir correctement le formulaire.");
                }

            }
        });
        add(btnSave);
    }
}


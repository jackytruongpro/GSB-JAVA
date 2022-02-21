package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controller.View_Controller;
import model.DAO_Factory;
import model.DAO_Visiteur;
import metiers.Visiteur;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class V_RechercheVisiteur extends JPanel {

    private static final long serialVersionUID = 1749437508520797514L;
    String columnName[] = {"Matricule","Nom","Prenom","Adresse","CP","Ville","Secteur","Laboratoire"};
    String[][] data = {};




    public V_RechercheVisiteur(V_Frame menu) {
        setBounds(100,100,720,423);
        this.setLayout(new BorderLayout(0, 0));

        JPanel search_zone = new JPanel();
        search_zone.setLayout(new FlowLayout(FlowLayout.LEADING, 30, 30));
        search_zone.setBackground(new Color(47, 146, 159));
        add(search_zone, BorderLayout.NORTH);

        JTextField search_field = new JTextField();
        search_field.setHorizontalAlignment(SwingConstants.LEFT);
        search_field.setColumns(20);
        search_zone.add(search_field);

        // Configuration du tableau et desactiver le double click editable
        @SuppressWarnings("serial")
        DefaultTableModel model = new DefaultTableModel(data,columnName){
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        };
        JTable table = new JTable(model);

        // Zone de recherche d'utilisateur (Upper)
        JScrollPane result_zone = new JScrollPane();
        result_zone.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        result_zone.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        add(result_zone, BorderLayout.CENTER);
        result_zone.setViewportView(table);

        JButton search_button = new JButton(" Rechercher ");
        search_button.setForeground(Color.BLACK);
        search_button.setBorder(new LineBorder(new Color(0,0,0)));
        search_button.setBackground(new Color(255, 150, 100));
        search_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                DAO_Visiteur tVisiteur = (DAO_Visiteur) DAO_Factory.getDAOVisiteur();

                try {
                    // On recupère nos objet trouvé dans la bdd à l'aide d'un tableau*/
                    ArrayList<Visiteur> result = tVisiteur.findV(search_field.getText());
                    // Si il y a un resultat on l'affiche, sinon on affiche un message d'alert
                    if(result.isEmpty()){
                        JOptionPane.showMessageDialog(search_zone,"Aucun resultat pour cette recherche. ");
                    }else{
                        // Suppresion des ancienne lignes
                        model.setRowCount(0);
                        // Ajout des nouvelles ligne dans le tableau avec un boucle qui r�cup�r l'objet visiteur
                        for(int i = 0; i < result.size(); i++){
                            // On creer un objet[] et on lui met en parametre l'incrémentation pour pouvoir les mettre l'une
                            // Apres l'autre, puis on récupére les différents champs
                            model.insertRow(i,new Object[]{result.get(i).getMat(),result.get(i).getNom(),result.get(i).getPrenom(),
                                    result.get(i).getAddrs(),result.get(i).getCP(),result.get(i).getVille(),
                                    result.get(i).getLabCode(),result.get(i).getSecCode()});
                        }
                        //Afficher les nouvelle ligne dans notre tableau courant
                        result_zone.setViewportView(table);

                    }

                    table.addMouseListener(new MouseAdapter() {
                        public void mousePressed(MouseEvent me) {
                            JTable table =(JTable) me.getSource();
                            Point p = me.getPoint();
                            int row = table.rowAtPoint(p);
                            if (me.getClickCount() == 2) {
                                View_Controller.id = result.get(row).getMat();
                                View_Controller.row = row;
                                View_Controller.setAnDrawNewView("Fiche visiteur");
                            }
                        }
                    });

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });
        search_zone.add(search_button);

        // Marge Gauche

        JPanel left_border_zone = new JPanel();
        FlowLayout fl_left_border_zone = (FlowLayout) left_border_zone.getLayout();
        fl_left_border_zone.setHgap(15);
        left_border_zone.setBackground(new Color(47, 146, 159));
        add(left_border_zone, BorderLayout.WEST);

        // Marge Droite

        JPanel right_border_zone = new JPanel();
        FlowLayout fl_right_border_zone = (FlowLayout) right_border_zone.getLayout();
        fl_right_border_zone.setHgap(15);
        right_border_zone.setBackground(new Color(47, 146, 159));
        add(right_border_zone, BorderLayout.EAST);

        // Zone d'actions sur les visiteurs

        JPanel actions_zone = new JPanel();
        actions_zone.setLayout(new FlowLayout(FlowLayout.TRAILING, 30, 15));
        actions_zone.setBackground(new Color(47, 146, 159));
        add(actions_zone, BorderLayout.SOUTH);


        JButton exit_button = new JButton(" Fermer ");
        exit_button.setForeground(Color.BLACK);
        exit_button.setBorder(new LineBorder(new Color(0,0,0)));
        exit_button.setBackground(new Color(255, 150, 100));
        exit_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                View_Controller.setAnDrawNewView("Menu");
            }
        });
        actions_zone.add(exit_button);
    }

}

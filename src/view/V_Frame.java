package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Toolkit;

public class V_Frame extends JFrame{
    private static final long serialVersionUID = -70427993833584366L;
    private JPanel header;
    private JPanel footer;
    private JPanel corps;

    /**Constructeur de la Frame (La couche la plus basse de la vue, elle contient les panels et widgets) **/
    public V_Frame(){

        initialize();
    }

    /** Param�trage de la frame **/
    private void initialize() {
        try{
            this.setIconImage(Toolkit.getDefaultToolkit().getImage(V_Frame.class.getResource("/view/img/logo-gsb.png")));
            this.setBounds(100, 100, 720, 520);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new BorderLayout(0, 0));
            this.setResizable(false);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** Permet l'inclusion dynamique du haut de page dans les diff�rentes vues **/
    public void header_content(){
        this.getContentPane().add(header,BorderLayout.NORTH);
    }
    public JPanel getHeader(){
        return header;
    }
    public void setHeader(JPanel header){
        this.header = header;
    }

    /** Permet l'inclusion dynamique du corps dans les diff�rentes vues **/
    public void corps(){
        this.getContentPane().add(corps,BorderLayout.CENTER);


    }
    public JPanel getCorps(){
        return corps;

    }
    public void setCorps(JPanel c){

        this.corps = c;

    }

    /** Permet l'inclusion dynamique du bas de page dans les diff�rentes vues **/
    public void footer_content(){
        this.getContentPane().add(footer,BorderLayout.SOUTH);
    }
    public void setFooter(JPanel footer){
        this.footer = footer;
    }

    /** Permet de repeindre les fen�tres a fin de permettre l'enchainement des vues **/
    public void remake(){
        corps();
        header_content();
        revalidate();
        repaint();
    }
}

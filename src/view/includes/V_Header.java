package view.includes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class V_Header extends JPanel {
    private static final long serialVersionUID = 3276945795047102496L;
    /**
     * Constructeur de l'ent�te.
     * @param header_footer_font
     * @param ptitre
     */

    private String titre;

    public V_Header(String ptitre){
        setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));

        this.titre=ptitre;

        init();
    }

    private void init(){

        JPanel header = this;
        header.setBackground( new Color(255, 150, 100));
        setLayout(new BorderLayout(0, 0));

        //----------/ Texte de l'entete
        JLabel lbl_auth = new JLabel(titre);
        lbl_auth.setVerticalAlignment(SwingConstants.TOP);
        lbl_auth.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_auth.setFont(new Font("Tahoma", Font.BOLD, 17));
        lbl_auth.setBorder(new EmptyBorder(10,10,10,10));
        lbl_auth.setForeground(Color.BLACK);
        lbl_auth.setBounds(249, 0, 185, 30);
        header.add(lbl_auth);

    }
}

package view.includes;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class V_Footer extends JPanel {
    private static final long serialVersionUID = -3970006906907270831L;

    public V_Footer( ){
        setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
        init();
    }

    private void init(){
        //----------/ Zone du bas de page
        JPanel footer = this;
        footer.setBackground(new Color(255, 150, 100));
        setLayout(new BorderLayout(0, 0));

        //----------/ Texte Droit du bas de page
        JLabel lbl_date = new JLabel("GSB 2019/2020");
        lbl_date.setHorizontalAlignment(SwingConstants.RIGHT);
        lbl_date.setForeground(Color.BLACK);
        lbl_date.setFont(new Font("Tahoma", Font.BOLD, 11));
        lbl_date.setBounds(307, 0, 87, 14);
        footer.add(lbl_date);

        //----------/ Texte Gauche du bas de page
        JLabel lbl_team = new JLabel("BOUSBAINE Rabah / MOITY Anthony / TRUONG Jacky");
        lbl_team.setFont(new Font("Tahoma", Font.BOLD, 11));
        lbl_team.setHorizontalAlignment(SwingConstants.LEFT);
        lbl_team.setForeground(Color.BLACK);
        lbl_team.setBounds(0, 0, 169, 14);
        footer.add(lbl_team, BorderLayout.WEST);
    }

}

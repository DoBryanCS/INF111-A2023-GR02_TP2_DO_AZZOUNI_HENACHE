package vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2023-11-01
 */
public class PanneauChat extends JPanel {
    protected JTextArea zoneChat;
    protected JTextField champDeSaisie;

    public PanneauChat() {
        this.setLayout(new BorderLayout());

        champDeSaisie = new JTextField();

        zoneChat = new JTextArea();
        zoneChat.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(zoneChat);

        this.add(champDeSaisie, BorderLayout.SOUTH);
        this.add(scrollPane, BorderLayout.CENTER);
    }

    public void ajouter(String msg) {
        zoneChat.append("\n"+msg);
    }
    public void setEcouteur(ActionListener ecouteur) {
        champDeSaisie.addActionListener(ecouteur);
    }

    public void vider() {
        if(this.zoneChat != null)
            this.zoneChat.setText("");
    }

    public void viderChampDeTexte() {
        if(this.champDeSaisie != null)
            this.champDeSaisie.setText("");
    }
}
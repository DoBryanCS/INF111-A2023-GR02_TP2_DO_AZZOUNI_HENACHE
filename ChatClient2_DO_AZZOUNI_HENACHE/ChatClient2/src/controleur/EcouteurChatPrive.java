package controleur;

import com.chat.client.ClientChat;
import vue.PanneauChat;
import vue.PanneauChatPrive;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2023-11-01
 */
public class EcouteurChatPrive extends EcouteurChatPublic {
    private String alias;
    public EcouteurChatPrive(String alias, ClientChat clientChat, PanneauChat panneauChat) {
        super(clientChat, panneauChat);
        this.alias = alias;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        Object source = evt.getSource();
        String action;
        String texte;

        if (source instanceof JButton) {
            action = evt.getActionCommand();
            if ("ACCEPTER".equals(action)) {
                clientChat.envoyer("CHESS " + alias);
            } else if ("REFUSER".equals(action)) {
                clientChat.envoyer("DECLINE_CHESS " + alias);
            }
        } else {
            texte = ((JTextField)source).getText();
            if (texte != null) {
                if (texte.equals("QUIT")) {
                    clientChat.envoyer("QUIT " + alias);
                } else if (texte.equals("ABANDON")) {
                    clientChat.envoyer("ABANDON " + alias);
                } else {
                    clientChat.envoyer("PRV " + alias + " " + texte);
                    panneauChat.ajouter("MOI>>"+texte);
                    panneauChat.viderChampDeTexte();
                }
            }
        }




    }

}
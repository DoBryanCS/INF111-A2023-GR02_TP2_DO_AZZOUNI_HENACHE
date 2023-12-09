package controleur;

import com.chat.client.ClientChat;
import com.chat.commun.net.Connexion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurJeuEchecs implements ActionListener {
    private ClientChat clientChat;
    private String positionDepart;

    public EcouteurJeuEchecs(ClientChat clientChat) {
        this.clientChat = clientChat;
        this.positionDepart = null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (positionDepart == null) {
            positionDepart = e.getActionCommand();
        } else {
            String positionFin = e.getActionCommand();
            // Convertir en format de déplacement du serveur (ex: e2e4)
            String deplacement = positionDepart + positionFin;
            clientChat.envoyer("MOVE " + deplacement);
            positionDepart = null; // Réinitialiser pour le prochain déplacement
        }
    }
}
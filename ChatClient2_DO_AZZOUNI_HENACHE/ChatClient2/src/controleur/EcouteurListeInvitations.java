package controleur;

import com.chat.client.ClientChat;
import vue.PanneauInvitations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EcouteurListeInvitations implements ActionListener {
    private ClientChat clientChat;
    private PanneauInvitations panneauInvitations;
    public EcouteurListeInvitations(ClientChat clientChat, PanneauInvitations panneauInvitations) {
        this.clientChat = clientChat;
        this.panneauInvitations = panneauInvitations;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        List<String> invitationsSelectionnees = panneauInvitations.getElementsSelectionnes();
        String action = e.getActionCommand();

        for (String alias : invitationsSelectionnees) {
            if ("ACCEPTER".equals(action)) {
                clientChat.envoyer("JOIN " + alias);
            } else if ("REFUSER".equals(action)) {
                clientChat.envoyer("DECLINE " + alias);
            }
            panneauInvitations.retirerInvitationRecue(alias);
        }
    }
}

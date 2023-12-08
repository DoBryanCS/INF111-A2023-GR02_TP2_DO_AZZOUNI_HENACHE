package vue;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2023-11-01
 */
public class PanneauConfigServeur extends JPanel {
    private JTextField txtAdrServeur, txtNumPort;

    public PanneauConfigServeur(String adr, int port) {
        // GridLayout pour aligner les labels et les champs de texte
        this.setLayout(new GridLayout(2, 2));

        // Créer les labels
        JLabel lblAdrServeur = new JLabel("Adresse IP : ");
        JLabel lblNumPort = new JLabel("Port : ");

        lblAdrServeur.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNumPort.setHorizontalAlignment(SwingConstants.RIGHT);

        // Initialiser les champs de texte avec les valeurs reçues
        txtAdrServeur = new JTextField(adr);
        txtNumPort = new JTextField(String.valueOf(port));

        // Ajouter les composants au panneau
        this.add(lblAdrServeur);
        this.add(txtAdrServeur);
        this.add(lblNumPort);
        this.add(txtNumPort);
    }
    public String getAdresseServeur() {
        return txtAdrServeur.getText();
    }
    public String getPortServeur() {
        return txtNumPort.getText();
    }
}

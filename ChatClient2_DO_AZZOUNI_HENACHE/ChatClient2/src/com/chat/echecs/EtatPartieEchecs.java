package com.chat.echecs;

import observer.Observable;

/**
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2023-10-01
 */
public class EtatPartieEchecs extends Observable {
    private char[][] etatEchiquier = new char[8][8];
    public EtatPartieEchecs() {
        //Les pions :
        for (int j=0;j<8;j++) {
            etatEchiquier[1][j] = 'p';
            etatEchiquier[6][j] = 'P';
        }
        //Cases vide :
        for (int j=0;j<8;j++)
          for (int i=2;i<6;i++) {
            etatEchiquier[i][j] = ' ';
        }

        //Tours :
        etatEchiquier[0][0] = 't';
        etatEchiquier[0][7] = 't';
        etatEchiquier[7][0] = 'T';
        etatEchiquier[7][7] = 'T';

        //Cavaliers :
        etatEchiquier[0][1] = 'c';
        etatEchiquier[0][6] = 'c';
        etatEchiquier[7][1] = 'C';
        etatEchiquier[7][6] = 'C';

        //Fous :
        etatEchiquier[0][2] = 'f';
        etatEchiquier[0][5] = 'f';
        etatEchiquier[7][2] = 'F';
        etatEchiquier[7][5] = 'F';

        //Dames :
        etatEchiquier[0][3] = 'd';
        etatEchiquier[7][3] = 'D';

        //Rois :
        etatEchiquier[0][4] = 'r';
        etatEchiquier[7][4] = 'R';
    }
    public boolean move(String deplacement) {
        boolean res = false;

        if (deplacement == null || deplacement.length() < 4) {
            return res;
        }

        String positionInitiale = deplacement.substring(0, 2);
        String positionFinale = deplacement.substring(deplacement.length() - 2);

        int colonne1 = positionInitiale.charAt(0) - 'a';
        int ligne1 = 8 - Integer.parseInt(String.valueOf(positionInitiale.charAt(1)));
        int colonne2 = positionFinale.charAt(0) - 'a';
        int ligne2 = 8 - Integer.parseInt(String.valueOf(positionFinale.charAt(1)));

        char piece = etatEchiquier[ligne1][colonne1];

        if (piece == ' ') {
            return res;
        }

        etatEchiquier[ligne1][colonne1] = ' ';
        etatEchiquier[ligne2][colonne2] = piece;

        if (ligne2 == 8 && piece == 'P') {
            etatEchiquier[ligne2][colonne2] = 'D';
        }

        if (ligne2 == 1 && piece == 'p') {
            etatEchiquier[ligne2][colonne2] = 'd';
        }

        this.notifierObservateurs();

        res = true;

        return res;
    }

    @Override
    public String toString() {
        String s = "";
        for (byte i=0;i<8;i++) {
            s+=(byte)(8-i)+" ";
            for (int j=0;j<8;j++)
                s+=((etatEchiquier[i][j]==' ')?".":etatEchiquier[i][j])+" ";
            s+="\n";
        }
        s+="  ";
        for (char j='a';j<='h';j++)
            s+=j+" ";
        return s;
    }

    public char[][] getEtatEchiquier() {
        return etatEchiquier;
    }

    public void setEtatEchiquier(char[][] etatEchiquier) {
        this.etatEchiquier = etatEchiquier;
    }
}

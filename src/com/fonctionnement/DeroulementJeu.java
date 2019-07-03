package com.fonctionnement;

public interface DeroulementJeu {
    /**methode pour demander le nombre qu'il faut trouver*/
    public String nbMystere();
    /** methode pour demander les proposition*/
    public String proposition();
    /** methode qui permet de jouer au jeu en totalite par niveau*/
   public boolean jeu();

}


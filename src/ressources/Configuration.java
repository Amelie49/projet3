package ressources;


import java.util.ResourceBundle;

public class Configuration {

    private ResourceBundle bundle = ResourceBundle.getBundle("ressources.config");

    public int getNbEssais() {
        String nbEssais = bundle.getString("nbEssais");
        return Integer.parseInt(nbEssais);
    }/* nb d'essais*/


    public int getLongueurNb () {
        String longueurNb = bundle.getString("longueurNb");
        return Integer.parseInt(longueurNb);
    }/*nb de chiffres que doit contenir le nombre*/


    public boolean getModeDeveloppeur () {
        String modeDeveloppeur = bundle.getString("modeDeveloppeur");
        return Boolean.parseBoolean(modeDeveloppeur);
    }/*mode developpeur active ou non */

}
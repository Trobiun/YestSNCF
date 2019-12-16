package sncf_keywords;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.Collection;

import static keywords.GlobalKeywords.*;
import static java.util.Arrays.asList;

@RunWith(Parameterized.class)
public class aller_retour_12_25ans_multi_12_25ans {

    private final int age_voyageur;
    private final String carte_reduction;
    private final String date_depart;
    private final String date_retour;
    private final String gare_arrivee;
    private final String gare_depart;
    private final String heure_depart;
    private final String heure_retour;
    private final String plage_age_voyageur;

    public aller_retour_12_25ans_multi_12_25ans(final int age_voyageur, final String carte_reduction, final String date_depart, final String date_retour, final String gare_arrivee, final String gare_depart, final String heure_depart, final String heure_retour, final String plage_age_voyageur) {
        this.age_voyageur = age_voyageur;
        this.carte_reduction = carte_reduction;
        this.date_depart = date_depart;
        this.date_retour = date_retour;
        this.gare_arrivee = gare_arrivee;
        this.gare_depart = gare_depart;
        this.heure_depart = heure_depart;
        this.heure_retour = heure_retour;
        this.plage_age_voyageur = plage_age_voyageur;
    }

    @Parameters(name = "{0}-{1}-{2}-{3}-{4}-{5}-{6}-{7}-{8}")
    public static Collection<Object[]> dataSets() {
        return asList(new Object[][]{
            {12, "Sans carte de réduction", "29/11/2019", "12/12/2019", "Paris (toutes gares intramuros)", "Besançon Viotte (centre-ville) (Bourgogne-Franche-Comté)", "14h", "12h", "12 - 25ans"}
        });
    }

    @Before
    public void setUp() {
        initialization("https://www.oui.sncf/billet-train");
    }

    @After
    public void tearDown() {
        finalization();
    }

    @Test
    public void execute() {
        choisirGareDepart(gare_depart);
        choisirGareArrivee(gare_arrivee);
        choisirDateAller(date_depart);
        choisirHeureAller(heure_depart);
        validerAller();
        choisirDateRetour(date_retour);
        choisirHeureRetour(heure_retour);
        validerRetour();
        choisirPlageAge("1", plage_age_voyageur);
        saisirAgeExact("1", String.valueOf(age_voyageur));
        choisirCarteReduction("1", carte_reduction);
        ajouterVoyageur();
        ajouterVoyageur();
        choisirPlageAge("2", plage_age_voyageur);
        saisirAgeExact("2", String.valueOf(age_voyageur));
        choisirCarteReduction("2", carte_reduction);
    }
}

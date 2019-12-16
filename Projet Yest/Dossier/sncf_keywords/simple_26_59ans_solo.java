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
public class simple_26_59ans_solo {

    private final String carte_reduction;
    private final String date_depart;
    private final String gare_arrivee;
    private final String gare_depart;
    private final String heure_depart;
    private final String plage_age_voyageur;

    public simple_26_59ans_solo(final String carte_reduction, final String date_depart, final String gare_arrivee, final String gare_depart, final String heure_depart, final String plage_age_voyageur) {
        this.carte_reduction = carte_reduction;
        this.date_depart = date_depart;
        this.gare_arrivee = gare_arrivee;
        this.gare_depart = gare_depart;
        this.heure_depart = heure_depart;
        this.plage_age_voyageur = plage_age_voyageur;
    }

    @Parameters(name = "{0}-{1}-{2}-{3}-{4}-{5}")
    public static Collection<Object[]> dataSets() {
        return asList(new Object[][]{
            {"Abo Fréquence 1e classe", "29/11/2019", "Paris (toutes gares intramuros)", "Besançon Viotte (centre-ville) (Bourgogne-Franche-Comté)", "14h", "26 - 59ans"}
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
        choisirPlageAge("1", plage_age_voyageur);
        choisirCarteReduction("1", carte_reduction);
    }
}

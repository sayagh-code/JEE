package presentation;

import dao.DaoNSQL;
import metier.MetierImpl;

public class Presentation {
    public static void main(String[] args) {
        MetierImpl metier = new MetierImpl();
        DaoNSQL sql = new DaoNSQL();

        metier.setDao(sql);

        double resultat = metier.calcul();

        System.out.println("Resultat est:" + resultat);
    }
}

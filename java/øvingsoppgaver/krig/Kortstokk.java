import java.util.ArrayList;
import java.util.Random;

public class Kortstokk {
    private ArrayList<Kort> kortstokk;
    private Random trekker;

    public Kortstokk() {
        this.kortstokk = new ArrayList<>();
        this.trekker = new Random();
        Kort.opprettKort(this.kortstokk);
    }

    public void skrivUt() {
        for ( Kort k : kortstokk) {
            System.out.println(k);
        }
    }

    public Kort trekkKort() {
        if (!erTom()) {
            int indeks = trekker.nextInt(kortstokk.size());
            /* HVORDAN RANDOM????*/
            return k;
        }
    }

    public boolean erTom() {
        if (this.kortstokk.isEmpty()) {
            return true;
        }
        return false;
    }

    /*
    private void leggTilKort() {
        String[] farger = {"H", "K", "S", "R"};

        for (int i = 0; i < farger.length; i++) {
            for (int j = 1; j <= 13; j++) {
                this.kortstokk.add(new Kort(farger[i], j));
            }
        }
    }*/
}

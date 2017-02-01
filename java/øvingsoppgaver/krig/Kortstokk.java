import java.util.ArrayList;
import java.util.Random;

public class Kortstokk {
    private ArrayList<Kort> kortstokk;
    private Random trekker;

    public Kortstokk() {
        this.kortstokk = new ArrayList<>();
        this.trekker = new Random();
    }

    private void leggTilKort() {
        String[] farger = {"H", "K", "S", "R"};

        for (int i = 0; i < farger.length; i++) {
            for (int j = 1; j <= 13; j++) {
                this.kortstokk.add(new Kort(farger[i], j));
    }
}

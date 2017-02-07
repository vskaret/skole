import java.util.ArrayList;

public class Kort {
    private String farge;
    private int tall;

    // konstruktor
    public Kort(String farge, int tall) {
        this.farge = farge;
        this.tall = tall;
    }

    // returnerer farge
    public String getFarge() {
        return this.farge;
    }

    // returnerer tall
    public int getTall() {
        return this.tall;
    }

    // returnerer farge og tell
    public String toString() {
        return this.farge + " " + this.tall;
    }

    // oppretter kort
    public static void opprettKort(ArrayList<Kort> kortstokk) {
        String[] farger = {"H", "K", "S", "R"};

        for (int i = 0; i < farger.length; i++) {
            for (int j = 1; j <= 13; j++) {
                kortstokk.add(new Kort(farger[i], j));
            }
        }
    }
}

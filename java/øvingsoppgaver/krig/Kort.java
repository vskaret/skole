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
}

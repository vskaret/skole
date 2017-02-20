public class Bil {
    private String regnr;
    private int seter;

    public Bil(String regnr, int seter) {
        this.regnr = regnr;
        this.seter = seter;
    }

    public String regnr() {
        return regnr;
    }

    public int seter() {
        return seter;
    }

    @Override
    public String toString() {
        return String.format("Regnr %s", regnr);
    }
}

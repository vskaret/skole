public class Motorsykkel {
    private String regnr;
    private int motorstorrelse;

    public Motorsykkel(String regnr, int motorstorrelse) {
        this.regnr = regnr;
        this.motorstorrelse = motorstorrelse;
    }

    public String regnr() {
        return regnr;
    }

    public int motorstorrelse() {
        return motorstorrelse;
    }

    @Override
    public String toString() {
        return String.format("Regnr %s", regnr);
    }
}

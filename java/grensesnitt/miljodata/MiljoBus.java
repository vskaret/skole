public class MiljoBus extends Kjoretoy implements Miljokjoretoy {
    private static final int forbruk = 18000;
    private int maxPas;

    public MiljoBus(int maxPas) {
        super(forbruk);
        this.maxPas = maxPas;
    }

    public double utslippPerPers() {
        return super.mengdeCO2() / maxPas;
    }
}

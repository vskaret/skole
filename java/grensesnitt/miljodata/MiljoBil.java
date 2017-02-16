public class MiljoBil extends Kjoretoy implements Miljokjoretoy {
    private static final int forbruk = 9000;
    private int seter;

    public MiljoBil(int seter) {
        super(forbruk);
        this.seter = seter;
    }

    public double utslippPerPers() {
        return super.mengdeCO2() / seter;
    }

}

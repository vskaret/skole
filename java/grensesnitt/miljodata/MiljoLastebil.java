public class MiljoLastebil extends Kjoretoy implements Miljokjoretoy {
    private static final int forbruk = 12000;
    private int nyttevekt;

    public MiljoLastebil(int nyttevekt) {
        super(forbruk);
        this.nyttevekt = nyttevekt;
    }

    public double utslippPerPers() {
        return super.mengdeCO2();
    }
}

public abstract class Kjoretoy {
    protected int forbruk;
    protected static final double utslipp = 2.32;

    public Kjoretoy(int forbruk) {
        this.forbruk = forbruk;
    }

    public double mengdeCO2() {
        return forbruk * utslipp;
    }
}

    

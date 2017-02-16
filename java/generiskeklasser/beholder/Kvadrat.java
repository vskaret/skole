public class Kvadrat {
    private double sidelengde;

    public Kvadrat(double sidelengde) {
        this.sidelengde = sidelengde;
    }

    public double omkrets() {
        return sidelengde * 4;
    }

    public double areal() {
        return sidelengde * sidelengde;
    }
}

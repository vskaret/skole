public class Sirkel {
    private double radius;

    public Sirkel(double radius) {
        this.radius = radius;
    }

    public double omkrets() {
        return 2 * 3.14 * radius;
    }

    public double areal() {
        return 3.14 * radius * radius;
    }
}

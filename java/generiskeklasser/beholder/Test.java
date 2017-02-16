public class Test {
    public static void main(String[] args) {
        Beholder<Kvadrat> b = new Beholder();

        b.settInn(new Kvadrat(3));
        System.out.printf("Omkrets: %.2f. Areal: %.2f.\n",
                b.taUt().omkrets(), b.taUt().areal());

    }
}

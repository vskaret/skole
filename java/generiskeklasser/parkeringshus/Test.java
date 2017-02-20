public class Test {
    public static void main(String[] args) {
        Parkeringshus phus = new Parkeringshus();

        phus.parkerKjoretoy(1, 0, new Motorsykkel("MC123", 200));
        phus.parkerKjoretoy(0, 5, new Motorsykkel("MC124", 300));
        phus.parkerKjoretoy(0, 3, new Motorsykkel("MC111", 400));

        phus.parkerKjoretoy(0, 0, new Bil("BIL11", 5));
        phus.parkerKjoretoy(1, 1, new Bil("BIL12", 5));
        phus.parkerKjoretoy(1, 9, new Bil("BIL13", 4));

        for (Parkeringsplass[] e : phus.getEtasjer()) {
            for (int i = 0; i < 10; i++) {
                // System.out.printf("%d>\n", i);
                if (e[i].seKjoretoy() instanceof Motorsykkel) {
                    System.out.printf("%d> %s har forlatt parkeringsplassen\n",
                            i, e[i].kjorUt());
                }
            }
        }
    }
}

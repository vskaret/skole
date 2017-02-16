public class Test {
    public static void main(String[] args) {
        Parkeringsplass<Motorsykkel> m = new Parkeringsplass();
        Parkeringsplass<Bil> b = new Parkeringsplass();

        int p1 = m.parker(new Motorsykkel("123abc", 50));
        int p2 = m.parker(new Motorsykkel("239abc", 60));
        int p3 = b.parker(new Bil("32afsoij", 3));
        int p4 = b.parker(new Bil("awef223", 5));

        for (int i = 0; i < 100; i++) {
            Bil bil = new Bil("abc" + i, 4);
            b.parker(bil);
        }

        System.out.printf("Henter %s\n", b.kjorUt(p4));
        System.out.printf("P-plass full? %b\n", b.erFull());
        System.out.printf("Ant parkert: %d\n", b.teller());
    }
}

public class Test {
    public static void main(String[] args) {
        Postkontor pk = new Postkontor();
        Kunde[] kunder = new Kunde[10];
        Postmann borre = new Postmann(pk);
        Thread t1 = new Thread(borre);
        //borre.start();
        //public Kunde(Monitor m, String navn, Postkontor pk)
        kunder[0] = new Kunde("Arne", pk);
        kunder[1] = new Kunde("Helge", pk);
        kunder[2] = new Kunde("Lise", pk);
        kunder[3] = new Kunde("Birger", pk);
        kunder[4] = new Kunde("Ole", pk);
        kunder[5] = new Kunde("Kim Jung", pk);
        kunder[6] = new Kunde("Bernt", pk);
        kunder[7] = new Kunde("Iselin", pk);
        kunder[8] = new Kunde("Kristine", pk);
        kunder[9] = new Kunde("Jens", pk);
        pk.setKunder(kunder);
        t1.start();

        for (int i = 0; i < kunder.length; i++) {
            new Thread(kunder[i]).start();
        }
    }
}

public class Postmann implements Runnable {
    private final Postkontor pk;

    public Postmann(Postkontor pk) {
        this.pk = pk;
    }

    @Override
    public void run() {
        Kunde[] kunder = pk.getKunder();

        // maa endres slik at mottager gir navn
        // public Post(String beskrivelse, String mottager) {
        int tall = 0;
        while (true) {
            for (int i = tall; i < (tall+100); i++) {
                Post p = new Post("post med pakkenr " + i + " til " + kunder[i % 10].toString(), kunder[i % 10].toString());
                pk.leverPost(p);
                System.out.println("Levert brev med pakkenr " + i + "!");
            }
            tall += 100;
        }
    }
}

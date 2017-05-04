public class Kunde implements Runnable {
    private final String navn;
    private final Postkontor pk;

    public Kunde(String navn, Postkontor pk) {
        this.navn = navn;
        this.pk = pk;
    }

    @Override
    public void run() {
        while (true) {
            Post p = pk.hentPost(navn);
            System.out.println(navn + " hentet " + p);
        }
    }

    public String toString() {
        return navn;
    }
}

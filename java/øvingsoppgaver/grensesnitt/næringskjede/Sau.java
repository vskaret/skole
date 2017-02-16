public class Sau implements Planteeter {

    public Sau() {
    }

    public boolean selvbeskyttelse(Rovdyr angriper) {
        if (angriper instanceof Rovdyr) {
            return true;
        }
        return false;
    }
}

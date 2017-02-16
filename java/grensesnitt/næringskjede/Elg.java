public class Elg implements Planteeter {

    public Elg() {
    }

    public boolean selvbeskyttelse(Rovdyr angriper) {
        if (angriper instanceof Bjorn) {
            return true;
        }
        return false;
    }
}

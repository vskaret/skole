public class KvadratStabel {
    private Node forst;

    private class Node {
        Node neste;
        Kvadrat data;
        public Node(Kvadrat data) {
            this.data = data;
        }
    }

    public void leggPaa(Kvadrat k) {
        Node temp = forst;
        forst = new Node(k);
        forst.neste = temp;
    }

    public Kvadrat taAv() {
        Node temp = forst;
        forst = forst.neste;
        return temp.data;
    }

    public boolean erTom() {
        if (forst == null) {
            return true;
        }
        return false;
    }
}

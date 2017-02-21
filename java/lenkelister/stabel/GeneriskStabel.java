public class GeneriskStabel<E> {
    private Node forst;

    private class Node {
        Node neste;
        E data;
        public Node(E data) {
            this.data = data;
        }
    }

    public void leggPaa(E e) {
        Node temp = forst;
        forst = new Node(e);
        forst.neste = temp;
    }

    public E taAv() {
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

public class FIFO<E> implements SimpleQueue<E> {
    private Node forerst;
    private Node bakerst;

    private class Node {
        E data;
        Node neste;

        public Node(E data) {
            this.data = data;
        }
    }

    public FIFO() {

    }

    public boolean add(E e) {
        Node n = new Node(e);
        if (forerst == null) {
            forerst = n;
            return true;
        } else if (bakerst == null) {
            bakerst = n;
            forerst.neste = n;
            return true;
        } else {
            bakerst.neste = n;
            bakerst = n;
            return true;
        }
    }

    public E poll() {
        Node temp = forerst;
        forerst = forerst.neste;
        return (E) temp.data;
    }
}

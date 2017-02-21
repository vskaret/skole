public class LIFO<E> implements SimpleQueue<E> {
    private Node forerst;

    private class Node {
        Node neste;
        E data;
        public Node(E data) {
            this.data = data;
        }
    }

    public boolean add(E e) {
        Node n = new Node(e);
        if (forerst == null) {
            forerst = n;
            return true;
        } else {
            n.neste = forerst;
            forerst = n;
            return true;
        }
    }

    public E poll() {
        Node temp = forerst;
        forerst = temp.neste;
        return (E) temp.data;
    }

}

public class MinMaksBeholder<E extends Comparable<E>> {
    private E[] beholder;
    //private Object[] beholder;
    final private int minstPos;
    final private int storstPos;

    public MinMaksBeholder() {
        beholder = (E[]) new Object[2];           // runtime exception
        //beholder = new Object[2];
        minstPos = 0;
        storstPos = 1;

    }

    public void leggTil(E e) {
        if (beholder[0] == null) {
            beholder[0] = e;
            beholder[1] = e;
        }

        if (e.compareTo(hentUtMinst()) < 0) {
            beholder[minstPos] = e;
        } else if (e.compareTo(hentUtStorst()) > 0) {
            beholder[storstPos] = e;
        }
    }

    public E hentUtMinst() {
        //return (E) beholder[minstPos];
        return (E) beholder[minstPos];
    }

    public E hentUtStorst() {
        //return (E) beholder[storstPos];
        return (E) beholder[storstPos];
    }
}

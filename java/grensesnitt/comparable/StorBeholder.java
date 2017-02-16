public class StorBeholder<T> {
    private T[] alle = (T[]) new Object[100];
    private int antall = 0;

    public void settInn(T det) {
        alle[antall] = det;
        antall++;
    }

    public T taUt() {
        antall--;
        return alle[antall];
    }
}

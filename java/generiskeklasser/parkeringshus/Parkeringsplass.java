public class Parkeringsplass<E> {
    E parkert;

    public Parkeringsplass() {
        parkert = null;
    }

    public boolean parker(E e) {
        if (ledig()) {
            parkert = e;
            return true;
        }
        return false;
    }

    public E kjorUt() {
        E temp = parkert;
        parkert = null;
        return temp;
    }

    public E seKjoretoy() {
        return parkert;
    }

    public boolean ledig() {
        if (parkert == null) {
            return true;
        }
        return false;
    }
}

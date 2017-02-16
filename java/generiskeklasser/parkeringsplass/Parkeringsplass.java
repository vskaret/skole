public class Parkeringsplass<E> {
    private Object[] parkert = new Object[100];
    private int teller;

    public Parkeringsplass() {
        teller = 0;
    }
    
    public int parker(E e) {
        if (!erFull()) {
            for (int i = 0; i < parkert.length; i++) {
                if (parkert[i] == null) {
                    parkert[i] = e;
                    teller++;
                    return i;
                }
            }
        }
        return -1;
    }

    public E kjorUt(int plassnr) {
        Object temp = parkert[plassnr];
        parkert[plassnr] = null;
        return (E) temp;
    }

    public boolean erFull() {
        if (teller == 100) {
            return true;
        }
        return false;
    }

    public int teller() {
        return teller;
    }
}

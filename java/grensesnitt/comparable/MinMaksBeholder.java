// se https://coderanch.com/t/496341/java/Generics-Comparable
// svaret til istvan kovascs
// 
// (Comparable[]) new Object[maxSize]; is an illegal cast, as new Object[] 
// results in creating an instance of Object[], not Comparable[]. Replace 
// this with
//  
//  list = (T[]) new Comparable[maxSize];  
// 
public class MinMaksBeholder<E extends Comparable<E>> {
    //private E[] beholder;                     // 1. funker ikke
    //private Object[] beholder;                // 2. funker ogsaa
    private E[] beholder;
    final private int minstPos;
    final private int storstPos;

    public MinMaksBeholder() {
        //beholder = (E[]) new Object[2];           // 1. runtime exception
        //beholder = new Object[2];                 // 2. funker ogsaa
        beholder = (E[]) new Comparable[2];         // 3. beste loesning
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
        //return (E) beholder[minstPos];       // 1. funker ikke
        //return (E) beholder[minstPos];       // 2. funker ogsaa
        return beholder[minstPos];
    }

    public E hentUtStorst() {
        //return (E) beholder[storstPos];      // 1. funker ikke
        //return (E) beholder[storstPos];      // 2. funker ogsaa
        return beholder[storstPos];
    }
}

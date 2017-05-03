import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class Ntetall {
    public static void main(String[] args) {
        /* Oppgave B
        Runnable job = new OppgaveB(100, 0, 1001);
        Thread t1 = new Thread(job);
        t1.start(); */

        // Oppgave C
        Thread[] traader = new Thread[10];
        for (int i = 0; i < traader.length; i++) {
            traader[i] = new Thread(new OppgaveD(10, i, 20, new Monitor()));
        }

        for (int i = 0; i < traader.length; i++) {
            traader[i].start();
        }
    }
}

class Monitor {
    private Lock laas = new ReentrantLock();
    private Condition kanFortsette = laas.newCondition();
    private int nesteTall = 0;

    public void skrivTall(int tall) {

        try {
            while (tall != nesteTall) {
                // monitor.await();    // condition som styrer await
                kanFortsette.await();
            }
            System.out.println(tall);
            nesteTall++;
            kanFortsette.signalAll();       // alle traader vaakner
        } catch (InterruptedException e) {
        } finally {
            laas.unlock();
        }
    }
}

class OppgaveD implements Runnable {
    private final int n, start, maks;
    private final Monitor monitor;

    public OppgaveD(int n, int start, int maks, Monitor monitor) {
        this.n = n;
        this.start = start;
        this.maks = maks;
        this.monitor = monitor;
    }

    public void run() {
        for (int i = start; i < maks; i += n) {
            monitor.skrivTall(i);
        }
    }
}

class OppgaveB implements Runnable {
    private final int n, start, maks;

    public OppgaveB(int n, int start, int maks) {
        this.n = n;
        this.start = start;
        this.maks = maks;
    }

    public void run() {
        for (int i = start; i < maks; i += n) {
            System.out.println(i);
        }
    }
}

class OppgaveA implements Runnable {
    public void run() {
        for (int i = 5; i < 1000; i += 10) {
            System.out.println(i);
        }
    }
}

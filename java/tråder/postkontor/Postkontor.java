import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class Postkontor {
    private Post[] posthylle = new Post[10];
    private int antall = 0;
    private Lock laas = new ReentrantLock();
    private Condition kanLevere = laas.newCondition();
    private Condition kanHente = laas.newCondition();
    private Kunde[] kunder;


    public void setKunder(Kunde[] kunder) {
        this.kunder = kunder;
    }

    public void leverPost(Post p) {
        laas.lock();
        try {
            while (antall >= 10) {
                kanLevere.await();
            }
            posthylle[antall++] = p;
            kanLevere.signalAll();
            kanHente.signalAll();       // maa si i fra at det er brev aa hente
        } catch (InterruptedException e) {
        } finally {
            laas.unlock();
        }
    }

    public Post hentPost(String mottager) {
        Post returpost = null;
        laas.lock();
        try {
            while (antall < 1 || (antall > 0 && posthylle[antall-1].getMottager() != mottager)) {
                kanHente.await();
            }
            returpost = posthylle[--antall];
            kanHente.signalAll();

            if (antall == 0) {
                kanLevere.signalAll();      // maa si i fra at postkontoret trenger flere brev
            }
        } catch (InterruptedException e) {
        } finally {
            laas.unlock();
        }
        return returpost;
    }

    public Kunde[] getKunder() {
        return kunder;
    }
}

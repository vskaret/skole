// bruk av array med arrayer

public class Parkeringshus<E> {
    private Parkeringsplass[][] etasjer;
    private Parkeringsplass[] etasje1, etasje2;
    int teller1, teller2;

    public Parkeringshus() {
        etasjer = new Parkeringsplass[2][];
        etasjer[0] = new Parkeringsplass[10];
        etasjer[1] = new Parkeringsplass[10];
        teller1 = 0;
        teller2 = 0;

        for (int i = 0; i < 10; i++) {
            opprettPplass(etasjer[0], i);
            //System.out.printf("%s\n", etasjer[0][i]);
            opprettPplass(etasjer[1], i);
            //System.out.printf("%s\n", etasjer[1][i]);

        }
    }

    public Parkeringsplass[][] getEtasjer() {
        return etasjer;
    }

    public Parkeringsplass[] getEtasje(int etasje) {
        if (etasje == 1) {
            return etasje1;
        }
        return etasje2;
    }

    public void opprettPplass(Parkeringsplass[] etasje, int teller) {
        etasje[teller] = new Parkeringsplass();
    }

    // plass 0-9
    /*
    public void parkerKjoretoy(int etasje, int plass, E kjoretoy) {
       if (etasje == 1) {
          if (etasje1[plass].ledig()) {
              etasje1[plass].parker(kjoretoy);
              teller1++;
              return;
          } else {
              System.out.printf("Plass ikke ledig\n");
          }
       } else if (etasje == 2) {
           if (etasje2[plass].ledig()) {
               etasje2[plass].parker(kjoretoy);
               teller2++;
               return;
           } else {
               System.out.printf("Plass ikke ledig\n");
           }
       }
    }
    */

    // etasje 0-1 plass 0-9
    public void parkerKjoretoy(int etasje, int plass, E kjoretoy) {
        if ((etasje < 0) || (etasje > 1)) {
            System.out.printf("Etasje finnes ikke!\n");
            return;
        }

        if (etasjer[etasje][plass].ledig()) {
            etasjer[etasje][plass].parker(kjoretoy);
            return;
        } else {
            System.out.printf("Opptatt!\n");
        }
    }
}

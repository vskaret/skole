public class TestKvadratStabel {
    public static void main(String[] args) {
        KvadratStabel stabel = new KvadratStabel();
        stabel.leggPaa(new Kvadrat(1));
        stabel.leggPaa(new Kvadrat(2));
        stabel.leggPaa(new Kvadrat(3));
        stabel.leggPaa(new Kvadrat(4));
        stabel.leggPaa(new Kvadrat(5));
        stabel.leggPaa(new Kvadrat(6));
        double sum = 0, siste = 0;

        while (!stabel.erTom()) {
            Kvadrat k = stabel.taAv();
            sum += k.areal();
            siste = k.areal();
        }
        System.out.printf("Summen av kvadratenes areal er %.2f\n", sum);
        System.out.printf("Det siste kvadratet i stabelen har areal: %.2f\n",
                siste);
        }
} 

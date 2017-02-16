public class Oppg {
    public static void main(String[] args) {

        Rovdyr[] rov = new Rovdyr[2];
        Planteeter[] pl = new Planteeter[2];

        rov[0] = new Ulv();
        rov[1] = new Bjorn();

        pl[0] = new Sau();
        pl[1] = new Elg();


        for (Rovdyr r : rov) {
            for (Planteeter p : pl) {
                if (r.jakt(p)) {
                    System.out.printf("%s var vellykket i jakten paa %s.\n", 
                            r, p);
                } else {
                    System.out.printf("%s var ikke vellykket i jakten paa %s.\n"
                            , r, p);
                }
            }
        }
    }
}

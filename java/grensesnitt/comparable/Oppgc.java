public class Oppgc {
    public static void main(String[] args) {
        Person[] parray = new Person[5];
        parray[0] = new Person(25, "Birger");
        parray[1] = new Person(35, "Kristen");
        parray[2] = new Person(45, "Stein");
        parray[3] = new Person(55, "Ole-Johan");
        parray[4] = new Person(15, "Sazz");

        Person lStorstNavn = parray[0];
        Person lMinstNavn = parray[0];

        for (Person p : parray) {
            if (lStorstNavn.navn().compareTo(p.navn()) < 0) {
                lStorstNavn = p;
            } else if (lMinstNavn.navn().compareTo(p.navn()) > 0) {
                lMinstNavn = p;
            }
        }
        System.out.printf("%s har det minste navnet\n", lMinstNavn);
        System.out.printf("%s har det storste navnet\n", lStorstNavn);
    }
}

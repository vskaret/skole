public class Oppgb {
    public static void main(String[] args) {
        Person[] parray = new Person[5];
        parray[0] = new Person(25, "Birger");
        parray[1] = new Person(35, "Kristen");
        parray[2] = new Person(45, "Stein");
        parray[3] = new Person(55, "Ole-Johan");
        parray[4] = new Person(15, "Knut");

        Person eldst = parray[0];

        for (Person p : parray) {
            if (eldst.compareTo(p) < 0) {
                eldst = p;
            }
        }
        System.out.printf("%s er eldst\n", eldst);
    }
}

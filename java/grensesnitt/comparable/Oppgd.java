public class Oppgd {
    public static void main(String[] args) {
        MinMaksBeholder<Person> beholder = new MinMaksBeholder<Person>();

        beholder.leggTil(new Person(25, "Birger"));
        beholder.leggTil(new Person(35, "Kristen"));
        beholder.leggTil(new Person(45, "Stein"));
        beholder.leggTil(new Person(55, "Ole-Johan"));
        beholder.leggTil(new Person(15, "Knut"));

        System.out.printf("%s er yngst\n", beholder.hentUtMinst());
        System.out.printf("%s er eldst\n", beholder.hentUtStorst());
    }
}

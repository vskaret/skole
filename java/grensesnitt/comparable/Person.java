public class Person implements Comparable<Person> {
    private int alder;
    private String navn;

    public Person(int alder, String navn) {
        this.alder = alder;
        this.navn = navn;
    }

    public int alder() {
        return alder;
    }

    public int compareTo(Person p) {
        if (this.alder() > p.alder()) {
            return 1;
        } else if (this.alder() < p.alder()) {
            return -1;
        }
        return 0;
    }
}

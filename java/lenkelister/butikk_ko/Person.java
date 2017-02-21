public class Person {
    private String navn;
    private String gjenstand;
    private Person neste;

    public Person(String navn, String gjenstand) {
        this.navn = navn;
        this.gjenstand = gjenstand;
    }

    public Person neste() {
        return neste;
    }

    public void setNeste(Person p) {
        neste = p;
    }

    @Override
    public String toString() {
        return String.format("Navn: %s kjoper %s\n", navn, gjenstand);
    }
}

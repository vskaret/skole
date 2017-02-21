public class Butikk {
    private Person forst;

    public void entreButikk(Person p) {
        Person n = forst;
        if (n == null) {
            forst = p;
        } else {
            while (n.neste() != null) {
                n = n.neste();
            }
            n.setNeste(p);
        }
    }

    public void kassa() {
        Person n = forst;
        while (n != null) {
            System.out.printf(n.toString());
            System.out.println("Snakkes!");
            n = n.neste();
        }
    }
}

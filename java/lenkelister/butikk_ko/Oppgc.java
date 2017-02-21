public class Oppgc {
    public static void main(String[] args) {
        Butikk b = new Butikk();
        b.entreButikk(new Person("Arne", "Bok"));
        b.entreButikk(new Person("Kjell", "Blyant"));
        b.entreButikk(new Person("Birger", "Burger"));
        b.entreButikk(new Person("Fiola", "Cola"));
        b.entreButikk(new Person("Siv", "Is"));

        b.kassa();
    }
}

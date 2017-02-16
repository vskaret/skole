public class Ulv implements Rovdyr {
    public Ulv(){
    }

    public boolean jakt(Planteeter bytte) {
        return bytte.selvbeskyttelse(this);
    }

    @Override
    public String toString() {
        return "Ulv";
    }
}

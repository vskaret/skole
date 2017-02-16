public class Bjorn implements Rovdyr {
    public Bjorn(){
    }

    public boolean jakt(Planteeter bytte) {
       return bytte.selvbeskyttelse(this);
    }
}

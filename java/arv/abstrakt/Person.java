abstract class Person {
    protected int alder;
    protected String navn;

    Person(int alder, String navn) {
        this.alder = alder;
        this.navn = navn;
    }

    public static void main(String[] args) {
    }
}

class Student extends Person {
    protected String kurs;
    protected String laerested;

    Student(int alder, String navn, String kurs, String laerested) {
        super(alder, navn);
        this.kurs = kurs;
        this.laerested = laerested;
    }
}

class Bachelorstudent extends Student {
    protected boolean bTilgang;

    Bachelorstudent(int alder, String navn, String kurs, String laerested) {
        super(alder, navn, kurs, laerested); 
        this.bTilgang = true;
    }
}

class Masterstudent extends Student {
    protected boolean mTilgang;

    Masterstudent(int alder, String navn, String kurs, String laerested) {
        super(alder, navn, kurs, laerested);
        this.mTilgang = true;
    }
}

abstract class Ansatt extends Person {
    protected double timelonn;

    Ansatt(int alder, String navn, double timelonn) {
        super(alder, navn);
        this.timelonn = timelonn;
    }
}

class Forsker extends Ansatt {
    protected String fagomraade;

    Forsker(int alder, String navn, double timelonn, String fag) {
        super(alder, navn, timelonn);
        this.fagomraade = fag;
    }
}

class Professor extends Forsker {
    protected String undervisningsfag;

    Professor(int alder, String navn, double timelonn, String fag, String ufag) {
        super(alder, navn, timelonn, fag);
        this.undervisningsfag = ufag;
    }
}

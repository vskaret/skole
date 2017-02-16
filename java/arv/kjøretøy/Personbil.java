public class Personbil extends Bil {
    protected int antPlasser;

    public Personbil(String regNr, String fMerke, String eNavn, int antPlasser) {
        super(regNr, fMerke, eNavn);
        this.antPlasser = antPlasser;
    }

    public int getAarsavgift() {
        return 3000;
    }
}

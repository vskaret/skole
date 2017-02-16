public class Bus extends Kjoretoy {
    protected int antPlasser;

    public Bus(String regNr, String fMerke, String eNavn, int antPlasser) {
        super(regNr, fMerke, eNavn);
        this.antPlasser = antPlasser;
    }
}

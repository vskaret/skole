public class Varebil extends Bil {
    protected int maxLast;

    public Varebil(String regNr, String fMerke, String eNavn, int maxLast) {
        super(regNr, fMerke, eNavn);
        this.maxLast = maxLast;
    }

    public int getAarsavgift() {
        return 4 * maxLast;
    }
}

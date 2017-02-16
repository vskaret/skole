public abstract class Kjoretoy {
    protected String regNr;
    protected String fMerke;
    protected String eNavn;

    public Kjoretoy(String regNr, String fMerke, String eNavn) {
        this.regNr = regNr;
        this.fMerke = fMerke;
        this.eNavn = eNavn;
    }

    public String getRegNr() {
        return regNr;
    }

    public String getFMerke() {
        return fMerke;
    }

    public String getENavn() {
        return eNavn;
    }

    public void setRegNr(String regNr) {
        this.regNr = regNr;
    }

    public void setFMerke(String fMerke) {
        this.fMerke = fMerke;
    }

    public void setENavn(String eNavn) {
        this.eNavn = eNavn;
    }
}

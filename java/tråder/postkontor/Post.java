public class Post {
    private String beskrivelse;
    private String mottager;

    public Post(String beskrivelse, String mottager) {
        this.beskrivelse = beskrivelse;
        this.mottager = mottager;
    }

    public String toString() {
        return beskrivelse;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public String getMottager() {
        return mottager;
    }
}

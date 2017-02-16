public class Oppgb {
    public static void main(String[] args) {
        Miljokjoretoy[] m = new Miljokjoretoy[6];
        double utslipp = 0;

        m[0] = new MiljoBil(5);
        m[1] = new MiljoBil(4);
        m[2] = new MiljoBus(30);
        m[3] = new MiljoBus(40);
        m[4] = new MiljoLastebil(2000);
        m[5] = new MiljoLastebil(2500);

        for (Miljokjoretoy mk : m) {
            utslipp += mk.mengdeCO2();
        }
        System.out.printf("Utslippet i aar: %.2f kg CO2\n", utslipp);

        System.out.printf("Utslipp per person:\n");
        double utslippBil = 0;
        double utslippBus = 0;
        for (Miljokjoretoy mk : m) {
            if (mk instanceof MiljoBil) {
                utslippBil += mk.utslippPerPers();
            } else if (mk instanceof MiljoBus) {
                utslippBus += mk.utslippPerPers();
            }
        }
        System.out.printf("Bilene har %.2f kg CO2 utslipp per person\n",
                utslippBil);
        System.out.printf("Bussene har %.2f kg CO2 utslipp per person\n",
                utslippBus);
    }
}

public class Palindrom {
    public static void main(String[] args) {
        GeneriskStabel<String> stabel = new GeneriskStabel<>();

        for (int i = 0; i < args.length; i++) {
            stabel.leggPaa(args[i]);
        }

        if (palindrom(args, stabel))
            System.out.printf("Palindrom!\n");
        else
            System.out.printf("Ikke palindrom!\n");
    }

    static boolean palindrom(String[] args, GeneriskStabel<String> s) {
        for (int i = 0; i < args.length; i++) {
                                // reverserer strengen
            String fraStabel = new StringBuilder(s.taAv()).reverse().toString();
            for (int j = 0; j < args[i].length(); j++)
                if (args[i].charAt(j) != fraStabel.charAt(j))
                    return false;
        }

        return true;
    }
}

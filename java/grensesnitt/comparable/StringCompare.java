public class StringCompare {
    public static void main(String[] args) {
        String[] a = new String[5];
        a[0] = new String("eeee");
        a[1] = new String("eeef");
        a[2] = "eeec";
        a[3] = "aaaaaa";
        a[4] = "z";

        String storst = a[0];
        String minst = a[0];

        for (String s : a) {
            if (s.compareTo(storst) > 0) {
                System.out.printf("%s storre enn %s\n", s, storst);
                storst = s;
            }
            if (s.compareTo(minst) < 0) {
                System.out.printf("%s mindre enn %s\n", s, minst);
                minst = s;
            }
        }

        System.out.printf("%s er storst\n", storst);
        System.out.printf("%s er minst\n", minst);
    }

    /*
    public int compareTo(String s) {
        if (this.length > s.length()) {
            return 1;
        } else if (this.length < s.length()) {
            return -1;
        }
        return 0;
    }
    */

}



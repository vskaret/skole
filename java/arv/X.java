public class X {
    public static void main(String[] args) {
        // lovlig
        Y y5 = new Y();         // bortover
        Y y6 = new Z();         // nedover
        // ikke lovlig (oppover)
        // Y y3 = new X();          // compile error
        // Y y3 = (Y) new X();      // runtime error (X cannot be cast to Y)

        X x1 = (X) new Y();
        Y y1 = new Y();
        //Y y2 = new X();
        Y y3 = new Z();
        Z z1 = new Z();
        //Z z2 = (Z) new X();


        Y q = new Y();
        Q b = new Q();
        B s = new Q();
        B g = new B();

        /* compile error: incompatible types: Y cannot be converted to B
        if (q instanceof B) {
            System.out.println("1");
        }*/
        if (q instanceof Y) {
            System.out.println("2");
        }
        if (b instanceof B) {
            System.out.println("3");
        }
        if (b instanceof X) {
            System.out.println("4");
        }
        if (s instanceof B) {
            System.out.println("5");
        }
        if (g instanceof Q) {
            System.out.println("6");
        }
        if (g instanceof X) {
            System.out.println("7");
        }

    }
}

class Y extends X {
}

class Z extends Y {
}

class B extends X {
}

class Q extends B {
}

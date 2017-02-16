class F {
    public void foo() {
        System.out.println("A");
    }
}

class K extends F {
    /*public void foo() {
        System.out.println("B");
    }*/
}

class Test {
    public static void main(String[] args) {
        K b = new K();
        F a = b;

        a.foo();
        b.foo();
    }
}

class Bygning {
    public static void main(String[] args) {
        Skyskraper s = new Skyskraper();
    }
    Bygning() {
        System.out.println("Bygning!");
    }
}

class Skyskraper extends Bygning {
    Skyskraper() {
        //super();
        System.out.println("Skyskraper!");
    }
}

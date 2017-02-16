class StudentRegister {
    public static void main(String [] args) {
        Person pers, pers2;
        Student stud, stud2;
        BachelorStudent bachelor, bachelor2;

        pers = new Person();
        stud = new Student();
        bachelor = new BachelorStudent();

        pers2 = stud;                                 // (A)
        //bachelor2 = (BachelorStudent) stud;           // (B)
        //stud2 = (BachelorStudent) stud;               // (C)
        //stud2 = (Person) stud;                        // (D)
        //stud2 = (Student) bachelor; bachelor = stud2; // (E)
    }
}
class Person {   }
class Student extends Person {   }
class BachelorStudent extends Student {   }

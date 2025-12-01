package advancedConcepts.genericsCollections;

public class Pair<A,B>{
    public A first;
    public B second;
    public int third;

    public Pair() {
    }

    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public void print(A a, B b) { // print(generic, generic)
        System.out.println(a + " -> " + b);
    }

    public void print(A a, B b, int c) { // print(generic, generic, int)
        System.out.println(a + " -> " + b + " -> " + c);
    }

    public A doSomething(A a, B b) {
        return a;
    }

}
/*
        class User
            attendance

        public void getMaxAttendance(List<User> user){
        }
 */
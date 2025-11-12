package oops;

public class Student {
    int id;
    String name;
    int marks;
    int roll;

    public Student(int sId, String sName, int sMarks, int sRoll) {
        id = sId;
        name = sName;
        marks = sMarks;
        roll = sRoll;
    }

    public Student(Student st){
        this(st.id,st.name,st.marks,st.roll);
    }


    public void showMarks(){
        int x = 100;
        System.out.println("X = " + x);
        doubleMarks(x);
        System.out.println("X = " + x);
    }

    public void doubleMarks(int x){
        x = x * 2;
        System.out.println(x);
    }
}

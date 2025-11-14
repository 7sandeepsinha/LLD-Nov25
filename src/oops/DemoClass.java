package oops;

public class DemoClass {

    public void showMarks(Student st){ // st.marks = 100
        System.out.println(st.marks); // 100
        doubleMarks(st);
        System.out.println(st.marks); // 200
    }

    public void doubleMarks(Student st){
        st.marks = 2 * st.marks;
        System.out.println(st.marks); // 200
        st = null;
    }


}

// Break -> 10:11 PM till 10:20 PM -> 8 mins
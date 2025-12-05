package advancedConcepts.steamsAndLambdas;

@FunctionalInterface // no usecase, only for better readability, similar to @Override
public interface Instructor<T>{
    void teach(int numberOfStudents, T topic);
}

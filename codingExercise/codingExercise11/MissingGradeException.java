package codingExercise.codingExercise11;

public class MissingGradeException extends Exception {
    private int studentId;

    public MissingGradeException(){
        throw new RuntimeException();
    }

    public int getStudentId(){
        return studentId;
    }
}
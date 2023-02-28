package codingExercise.codingExercise11;

public class InvalidDataException extends Exception{
    public InvalidDataException(){
        throw new RuntimeException();
    }

}
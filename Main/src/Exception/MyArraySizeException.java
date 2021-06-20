package Exception;

public class MyArraySizeException extends Exception{
    public  MyArraySizeException(){
        super("Массив не соответствует условиям! Необходим двумерный массив размером 4х4.");
    }
}

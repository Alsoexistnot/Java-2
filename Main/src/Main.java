import Exception.*;

public class Main {

    private static int x;

    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        String[][] array = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};
        try {
            converter(array);
            System.out.println(x);
        } catch (MyArraySizeException arraySizeException){
            System.out.println("Произошла ошибка! Неверно указан размер массива. Он должен быть двумерный с размером 4х4.");
        } catch (MyArrayDataException arrayDataException){
            System.out.println("Произошла ошибка! Указан неверный формат в ячейке массива.");
        }

    }

    public static void converter(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array[0].length == 4 && array.length == 4) {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    try {
                        x += Integer.parseInt(array[i][j]);
                    } catch (NumberFormatException nfe) {
                        throw new MyArrayDataException("В ячейке array[" + i + "][" + j + "] неверный формат.\nУказан символ/буква: " + array[i][j]);
                    }
                }
            }
        } else {
            throw new MyArraySizeException();
        }
    }
}





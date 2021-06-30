public class LessonFive {
    public static void main(String[] args) {
        int first = (int) Array.createArray();
        int second = (int) Array.createArrayWithThread();
        System.out.println("Метод без потоков сработал за: " + first + " мс");
        System.out.println("Метод с потоками сработал за: " + second + " мс");
        int difference = first - second;
        System.out.println("Разница составила: " + difference + " мс");
        float convertToSeconds = difference/1000F;
        System.out.println("Разница в секундах: " + convertToSeconds + " сек");
    }
}

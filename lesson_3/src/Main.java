import java.util.*;

public class Main {
    public static void main(String[] args) {

//        1. 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
//        Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
//        Посчитать сколько раз встречается каждое слово. (строки 10-25)

        String[] arr = {"Лето", "Зима", "Осень", "Весна", "Яблоко", "Арбуз", "Осень", "Дерево", "Яблоко", "Камень", "Арбуз", "Осень"};
        Map<String, Integer> map = new HashMap<>();
        Set<String> uniqueWords = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int iterations = 0;
            uniqueWords.add(arr[i]);
            for (int j = 0; j < arr.length; j++) {
                if (arr[i].equals(arr[j])){
                    iterations++;
                }
            }
            map.put(arr[i], iterations);
        }

        System.out.println("Список уникальных слов из массива: \n" + uniqueWords.toString() + "\n");
        System.out.println("Сколько раз каждое слово встречалось в массиве: \n" + map.toString());


        System.out.println();
        System.out.println();

//         2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
//         В этот телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода get() искать
//         номер телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов, тогда при
//         запросе такой фамилии должны выводиться все телефоны.

        Phonebook phonebook = new Phonebook();
        phonebook.add("Иванов", "89991112233");
        phonebook.add("Петров", "89992223344", "89993334455");
        phonebook.add("Сидоров", "89994445566", "89995556677", "89996667788");
        phonebook.add("Кузнецов", "89997778899", "89998889900");

        phonebook.get("Иванов");
        phonebook.get("Петров");
        phonebook.get("Кузнецов");
    }
}

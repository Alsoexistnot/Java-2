import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Phonebook {
    private Map<String, List<String>> filledPhonebook = new HashMap<>();
    public void add(String surname, String number){
        List<String> list = new ArrayList<>();
        list.add(number);
        filledPhonebook.put(surname, list);
    }
    public void add(String surname, String number, String numberTwo){
        List<String> list = new ArrayList<>();
        list.add(number);
        list.add(numberTwo);
        filledPhonebook.put(surname, list);
    }
    public void add(String surname, String number, String numberTwo, String numberThree){
        List<String> list = new ArrayList<>();
        list.add(number);
        list.add(numberTwo);
        list.add(numberThree);
        filledPhonebook.put(surname, list);
    }
    public void add(String surname, String number, String numberTwo, String numberThree, String numberFour){
        List<String> list = new ArrayList<>();
        list.add(number);
        list.add(numberTwo);
        list.add(numberThree);
        list.add(numberFour);
        filledPhonebook.put(surname, list);
    }

    public void get(String surname) {
        System.out.println("Контакт: " + surname);
        System.out.println(filledPhonebook.get(surname));
        System.out.println();
    }

}

package lesson_3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Phone {
    private Map<String, Set<String>> phoneBook = new HashMap<>();

    public void add(String surname, String phone) {
        Set<String> number = phoneBook.getOrDefault(surname, new HashSet<>());
        number.add(phone);
        phoneBook.put(surname, number);
    }

    public Set<String> get (String surname) {
        return phoneBook.get(surname);
    }
}

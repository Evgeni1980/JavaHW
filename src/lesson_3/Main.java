package lesson_3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] arr = {
                "House", "Forest", "Car", "Score",
                "Cat", "Dog", "Car", "Cat", "House",
                "Score"
        };

        List<String> list = new ArrayList<>(Arrays.asList(arr));
        System.out.print(list);
        System.out.println();

        // Вывод уникальных слов.
        Set<String> set;
        set = new HashSet<>(list);
        System.out.print(set);

        System.out.println();

        // Выывод количества повторений слов.

        Map<String, Integer> repeat = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            Integer count = repeat.getOrDefault(s, 0);
            repeat.put(s, count + 1);

        }

        System.out.print(repeat);

        // Добавление записей

        Phone book = new Phone();
        book.add("Petrov", "12345678");
        book.add("Sidorov", "87654321");
        book.add("Putin", "13579468");
        book.add("Petrov", "37945618");
        book.add("Ivanov", "10050023");

        // Вывод по фамилии

        System.out.println("Tel: " + book.get("Petrov"));
        System.out.println("Tel: " + book.get("Sidorov"));
        System.out.println("Tel: " + book.get("Putin"));
        System.out.println("Tel: " + book.get("Ivanov") );

    }
}

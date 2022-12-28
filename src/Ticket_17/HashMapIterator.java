package Ticket_17;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapIterator {

    static Map<Integer, String> map = new HashMap<>();

    public static void main(String[] args) {

        /*
        Напишите Java-программу для итерации объекта типа HashMap с
        использованием цикла while и улучшенного цикла for.
        */

        map.put(1, "First");
        map.put(2, "Second");
        map.put(3, "Third");
        map.put(4, "Fourth");
        map.put(5, "Fifth");


        iterateWithWhile(map);

        for (Map.Entry<Integer, String> pair : map.entrySet()) {
            System.out.println(pair.getKey() + ", " + pair.getValue());
        }
    }

    private static void iterateWithWhile(Map map) {
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry) iterator.next();
            System.out.println(pair.getKey() + ", " + pair.getValue());
        }
    }

}

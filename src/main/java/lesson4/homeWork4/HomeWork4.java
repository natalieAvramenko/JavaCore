package lesson4.homeWork4;

import java.util.*;

public class HomeWork4 {
    public static void main(String[] args) {
        String[] words = {"dog","cat", "wolf", "dog", "coffee",
                "tea", "cola", "coffee", "wolf", "red",
                "black", "orange", "apple", "apple", "mint",
                "java", "cat", "cheese", "tea", "cheese"};

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        System.out.println(map);
        System.out.println("");

        Set<String> uniq = new HashSet<>(Arrays.asList(words));
        System.out.println(uniq);
        System.out.println("");

        Phonebook pb = new Phonebook();

        pb.add("Savin", "123");
        pb.add("Kim", "718");
        pb.add("Fox", "328");
        pb.add("Savin", "888");

        System.out.println(pb.get("Savin"));

    }
}

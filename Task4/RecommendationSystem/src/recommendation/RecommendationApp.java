package recommendation;

import java.util.*;

public class RecommendationApp {

    static class Item {
        String name;
        List<String> tags;

        Item(String name, String... tags) {
            this.name = name;
            this.tags = Arrays.asList(tags);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Sample items database
        List<Item> items = new ArrayList<>();
        items.add(new Item("Java Programming Course", "technology", "programming", "java"));
        items.add(new Item("AI & ML Book", "technology", "ai", "machine learning"));
        items.add(new Item("Cricket Bat", "sports", "fitness"));
        items.add(new Item("Football Shoes", "sports"));
        items.add(new Item("Guitar", "music", "instrument"));
        items.add(new Item("Headphones", "music", "technology"));

        // User input
        System.out.println("Enter your interests (comma separated): ");
        System.out.println("Example: technology, music");
        String input = sc.nextLine().toLowerCase();

        List<String> userInterests = Arrays.asList(input.split(","));

        // Recommendation scoring
        Map<String, Integer> scoreMap = new HashMap<>();

        for (Item item : items) {
            int score = 0;
            for (String interest : userInterests) {
                if (item.tags.contains(interest.trim())) {
                    score++;
                }
            }
            if (score > 0) {
                scoreMap.put(item.name, score);
            }
        }

        // Display recommendations
        System.out.println("\nRecommended Items:");
        if (scoreMap.isEmpty()) {
            System.out.println("No recommendations found.");
        } else {
            scoreMap.entrySet()
                    .stream()
                    .sorted((a, b) -> b.getValue() - a.getValue())
                    .forEach(entry ->
                            System.out.println("- " + entry.getKey()
                                    + " (score: " + entry.getValue() + ")"));
        }

        sc.close();
    }
}

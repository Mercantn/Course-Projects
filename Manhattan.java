import java.util.*;

public class Manhattan {

    // Helper class to represent an event
    private static class Event {
        int x; // x-coordinate of the event
        int height; // height of the building
        boolean isStart; // true if start event, false if end event

        Event(int x, int height, boolean isStart) {
            this.x = x;
            this.height = height;
            this.isStart = isStart;
        }
    }

    public static int totalArea(int[] s, int[] e, int[] h) {
        List<Event> events = new ArrayList<>();

        // Collect all events
        for (int i = 0; i < s.length; i++) {
            events.add(new Event(s[i], h[i], true));  // Start event
            events.add(new Event(e[i], h[i], false)); // End event
        }

        // Sort events by x-coordinate; start events before end events if same x
        events.sort((a, b) -> {
            if (a.x != b.x) {
                return Integer.compare(a.x, b.x);
            }
            return Boolean.compare(a.isStart, b.isStart);
        });

        int totalArea = 0;
        int prevX = 0;
        int prevMaxHeight = 0;
        TreeMap<Integer, Integer> heightMap = new TreeMap<>();

        for (Event event : events) {
            int currentX = event.x;
            int currentHeight = event.height;

            if (event.isStart) {
                heightMap.put(currentHeight, heightMap.getOrDefault(currentHeight, 0) + 1);
            } else {
                if (heightMap.get(currentHeight) == 1) {
                    heightMap.remove(currentHeight);
                } else {
                    heightMap.put(currentHeight, heightMap.get(currentHeight) - 1);
                }
            }

            int currentMaxHeight = heightMap.isEmpty() ? 0 : heightMap.lastKey();

            if (currentX != prevX) {
                totalArea += (currentX - prevX) * prevMaxHeight;
                prevX = currentX;
            }

            prevMaxHeight = currentMaxHeight;
        }

        return totalArea;
    }
}

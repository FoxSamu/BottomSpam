package net.shadew.dskflhafljkdrj;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class Node {
    private final Map<Character, Integer> next = new LinkedHashMap<>();
    private int totalWeight = -1;

    public Node learn(char n) {
        next.put(n, next.getOrDefault(n, 0) + 1);
        totalWeight = -1;
        return this;
    }

    public Node put(char n, int chance) {
        next.put(n, chance);
        totalWeight = 0;
        return this;
    }

    public String toCode() {
        StringBuilder builder = new StringBuilder("new Node()").append(System.lineSeparator());
        for (Map.Entry<Character, Integer> n : next.entrySet()) {
            char c = n.getKey();
            int w = n.getValue();

            builder.append(".put('").append(c).append("', ").append(w).append(")").append(System.lineSeparator());
        }
        return builder.toString();
    }

    public int next(Random rng) {
        if (totalWeight < 0) {
            totalWeight = 0;
            for (int i : next.values())
                totalWeight += i;
        }

        if (totalWeight == 0)
            return -1;
        int r = rng.nextInt(totalWeight);
        for (Map.Entry<Character, Integer> n : next.entrySet()) {
            char c = n.getKey();
            int w = n.getValue();

            r -= w;
            if (r <= 0)
                return c;
        }
        return -1;
    }
}

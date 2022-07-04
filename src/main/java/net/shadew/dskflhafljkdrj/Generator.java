package net.shadew.dskflhafljkdrj;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class Generator {
    private final Map<String, Node> nodes = new LinkedHashMap<>();
    private final int learnDepth;

    public Generator(int learnDepth) {
        this.learnDepth = learnDepth;
    }

    public Generator learn(String str) {
        if (str.length() == 0)
            return this;

        int l = str.length();
        for (int d = 1; d <= learnDepth; d++) {
            for (int i = d; i < l; i++) {
                char c = str.charAt(i);
                String before = str.substring(i - d, i);
                nodes.computeIfAbsent(before, n -> new Node()).learn(c);
            }
        }

        nodes.computeIfAbsent(null, n -> new Node()).learn(str.charAt(0));
        return this;
    }

    public Generator put(String str, Node node) {
        nodes.put(str, node);
        return this;
    }

    public String toCode() {
        StringBuilder builder = new StringBuilder("new Generator");
        builder.append("(").append(learnDepth).append(")").append(System.lineSeparator());
        for (Map.Entry<String, Node> e : nodes.entrySet()) {
            builder.append(".put(").append(System.lineSeparator())
                   .append("\"").append(e.getKey()).append("\",").append(System.lineSeparator())
                   .append(e.getValue().toCode()).append(System.lineSeparator())
                   .append(")").append(System.lineSeparator());
        }
        return builder.toString();
    }

    public String generate(double length, double lengthRandom, int lengthEntropy, Random random, int start) {
        double l = length;
        if (lengthRandom > 0 && lengthEntropy > 0) {
            int s = 1;
            for (int i = 0; i < lengthEntropy * 2; i++) {
                l += random.nextDouble() * (lengthRandom / (lengthEntropy * 2)) * s;
                s = -s;
            }
        }

        int il = (int) l;

        if (il <= 0) return "";

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < il; i++) {
            int c;
            if (i == 0) {
                if (start > 0)
                    c = start;
                else
                    c = nodes.get(null).next(random);
            } else {
                c = -1;
                for (int d = Math.min(learnDepth, i); d >= 0; d--) {
                    String str = builder.substring(i - d, i);
                    Node node = nodes.get(str);
                    int c1 = node == null ? -1 : node.next(random);
                    if (c1 != -1) {
                        c = c1;
                        break;
                    }
                }
            }

            if (c == -1) break;

            builder.append((char) c);
        }

        return builder.toString();
    }
}

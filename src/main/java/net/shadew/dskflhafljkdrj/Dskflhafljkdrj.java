package net.shadew.dskflhafljkdrj;

import java.util.Random;
import java.util.Scanner;

public class Dskflhafljkdrj {
    private static final Generator gen = Trainer.train(6);

    public static String sdjkjrkeskjrhjr(int start) {
        return gen.generate(20, 15, 2, new Random(), start);
    }

    public static String sdjkjrkeskjrhjr(int start, int len) {
        return gen.generate(len, 0, 0, new Random(), start);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (true) {
            String ln = s.nextLine();
            if (ln.equals("end"))
                return;

            int n = -1;
            try {
                n = Integer.parseInt(ln);
            } catch (NumberFormatException ignored) {
            }

            long t1 = System.nanoTime();
            System.out.println(n > 0 ? sdjkjrkeskjrhjr(-1, n) : sdjkjrkeskjrhjr(-1));
            long t2 = System.nanoTime();
            System.out.println("Generated in " + (t2 - t1) / 1000 + " microseconds");
        }
    }
}

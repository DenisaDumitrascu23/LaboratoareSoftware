package lab2;

import java.util.*;

public class Exercitiul1 {

    public static void main(String[] args) {

        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        List<Integer> xPlusY = new ArrayList<>(); // a
        Set<Integer> zSet = new TreeSet<>(); // b
        List<Integer> xMinusY = new ArrayList<>(); // c
        int p = 4;
        List<Integer> xPlusYLimitedByP = new ArrayList<>(); // d

        Random rand = new Random();

        // generare valori random
        for (int i = 0; i < 5; i++)
            x.add(rand.nextInt(11));

        for (int i = 0; i < 7; i++)
            y.add(rand.nextInt(11));

        // sortare
        Collections.sort(x);
        Collections.sort(y);
        System.out.println("x = " + x);
        System.out.println("y = " + y);

        // a) xPlusY contine toate elementele
        xPlusY.addAll(x);
        xPlusY.addAll(y);
        Collections.sort(xPlusY);
        System.out.println("xPlusY = " + xPlusY);

        // b) valori comune o singura data
        for (Integer val : x) {
            if (y.contains(val)) {
                zSet.add(val);
            }
        }
        System.out.println("zSet = " + zSet);

        // c) valori din x care nu sunt in y
        for (Integer val : x) {
            if (!y.contains(val)) {
                xMinusY.add(val);
            }
        }
        System.out.println("xMinusY = " + xMinusY);

        // d) valori din x si y <= p
        for (Integer val : x) {
            if (val <= p) {
                xPlusYLimitedByP.add(val);
            }
        }
        for (Integer val : y) {
            if (val <= p) {
                xPlusYLimitedByP.add(val);
            }
        }

        Collections.sort(xPlusYLimitedByP);
        System.out.println("xPlusYLimitedByP = " + xPlusYLimitedByP);
    }
}
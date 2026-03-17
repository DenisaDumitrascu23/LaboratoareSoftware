package lab3;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class ex1 {

    public static void main(String[] args) {

        try {
            // citire din fisier
            Path path = Paths.get("in.txt");
            List<String> lines = Files.readAllLines(path);

            List<String> rezultat = new ArrayList<>();

            // prelucrare
            for (String line : lines) {

                // a) adauga newline la sfarsit de linie
                String variantaA = line + "\n";

                // b) adauga newline dupa fiecare punct
                String variantaB = line.replace(".", ".\n");

                rezultat.add(variantaA);
                rezultat.add(variantaB);
            }

            // afisare
            System.out.println("Rezultat:");
            for (String s : rezultat) {
                System.out.println(s);
            }

            // scriere in fisier
            Path outPath = Paths.get("out.txt");
            Files.write(outPath, rezultat);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
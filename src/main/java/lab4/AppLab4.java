package lab4;

import java.util.HashMap;
import java.util.Map;

public class AppLab4 {
    static void main() {
        HashMap<String, Integer> varste = new HashMap<>();
        varste.put("Ioan", 21);
        varste.put("Maria", 22);
        varste.put("Victor", 20);
        varste.put("Simina", 20);
        varste.put("Marius", 21);
        varste.put("Mihai", 21);
        varste.put("Daniela", 23);
        Map<String, String> adrese = Map.of("Ioan", "Sibiu", "Maria", "Bucuresti", "Victor",
                "Cluj","Simina", "Alba-Iulia","Marius", "Medias", "Mihai", "Cisnadie","Daniela", "Sibiu");

        HashMap<String, Tanar> tineri = new HashMap<>();

        for (String prenume : varste.keySet()) {
            int varsta = varste.get(prenume);

            String adresa = adrese.get(prenume);
            if (adresa == null) {
                adresa = "Necunoscuta";
            }

            Tanar t = new Tanar(prenume, varsta, adresa);
            tineri.put(prenume, t);
        }

        System.out.println("Varste initiale:");
        System.out.println(varste);

        varste.put("Vlad", 19);
        varste.put("Iulia", 19);

        System.out.println("Varste dupa adaugare:");
        System.out.println(varste);

        System.out.println("Tineri:");
        for (Tanar t : tineri.values()) {
            System.out.println(t);
        }
    }
}

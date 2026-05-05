package lab9;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class exercitiu {
    public static void main(String[] args) {

        Random random = new Random();
        ArrayList<Integer> lista = new ArrayList<>();

        // Generare lista cu 10 numere random [5..25]
        for (int i = 0; i < 10; i++) {
            int numar = random.nextInt(21) + 5;
            lista.add(numar);
        }
        System.out.println("Lista initiala: " + lista);

        // a) Suma elementelor
        int suma = lista.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Suma elementelor = " + suma);

        // b) Valoarea maxima si minima
        Optional<Integer> maxim = lista.stream().max(Integer::compare);
        Optional<Integer> minim = lista.stream().min(Integer::compare);
        System.out.println("Maxim = " + maxim.get());
        System.out.println("Minim = " + minim.get());

        // c) Lista cu elemente din intervalul [10..20]
        List<Integer> listaNoua = lista.stream()
                .filter(x -> x >= 10 && x <= 20)
                .collect(Collectors.toList());
        System.out.println("Elemente in [10..20]: " + listaNoua);

        // d) Transformare in Double
        List<Double> listaDouble = lista.stream()
                .map(x -> x.doubleValue())
                .collect(Collectors.toList());
        System.out.println("Lista transformata in Double: " + listaDouble);

        // e) Verificare daca exista valoarea 12
        boolean exista12 = lista.stream()
                .anyMatch(x -> x == 12);
        System.out.println("Exista valoarea 12? " + exista12);
        System.out.println();

        //Avand textul "Acesta este un program scris in java pentru expresii lambda" creati o lista a cuvintelor.
        String text = "Acesta este un program scris in java pentru expresii lambda";
        List<String> cuvinte = Arrays.asList(text.split(" "));
        System.out.println("Lista initiala:" + cuvinte);

        // a) Filtrare cuvinte cu lungime >= 5
        List<String> listaFiltrata = cuvinte.stream()
                .filter(cuvant -> cuvant.length() >= 5)
                .collect(Collectors.toList());
        System.out.println("\nCuvinte cu lungime >= 5:" + listaFiltrata);
        long numar = listaFiltrata.size();
        System.out.println("Numar cuvinte: " + numar);

        // b) Sortare lista noua
        List<String> listaSortata = listaFiltrata.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("\nLista ordonata:" + listaSortata);

        //c) afisati un element care incepe cu litera 'p'
        Optional<String> cuvantp = listaFiltrata.stream()
                .filter(cuvant -> cuvant.startsWith("p"))
                .findFirst();
        if (cuvantp.isPresent()) {
            System.out.println("\nCuvant care incepe cu 'p': " + cuvantp.get());
        } else {
            System.out.println("\nNu exista cuvant care incepe cu 'p'");
        }
    }
}
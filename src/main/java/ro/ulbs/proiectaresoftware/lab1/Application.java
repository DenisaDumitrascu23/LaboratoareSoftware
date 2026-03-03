package ro.ulbs.proiectaresoftware.lab1;

public class Application {
    public static void main(String[] args) {
        String alfabet = "";
        for (int i = 'a'; i <= 'z'; i++) {
            alfabet = alfabet + (char)i;
        }

        System.out.println(alfabet.toLowerCase());
        System.out.println(alfabet.toUpperCase());
        String[] array = new String[50];
        for (int i = 0; i < array.length; i++) {
            array[i] = "";
        }
        int k = -1;
        for (int i = 0; i < alfabet.length(); i++) {
            char c = alfabet.charAt(i);

            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                k++;
            }
            array[k] += c;
        }

        for (int i = 0; i <= k; i++) {
            System.out.println(array[i]);
        }
    }
}
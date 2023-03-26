import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Traducteur {
    private static Map<String, Map<String, String>> dictionary = new HashMap<>();

    public void traduire() {
        // Crear un árbol
        buildTree();
        
        // Pedir la palabra
        Scanner scanner = new Scanner(System.in);
        System.out.print("Saisissez un mot à traduire: ");
        String word = scanner.nextLine().toLowerCase();
        
        // Buscar las posibles traducciones en el árbol
        String translation = findTranslation(word);
        if (translation != null) {
            System.out.println("Traduction de " + word + ": " + translation);
        } else {
            System.out.println("Le mot " + word + " n'a pas de traduction dans ce dictionnaire.oui");
        }
    }

    private static void buildTree() {
        // Añadir palabras al árbol
        addWord("maison", "house", "casa");
        addWord("chien", "dog", "perro");
        addWord("devoirs", "homework", "tarea");
        addWord("femme", "woman", "mujer");
        addWord("ville", "town", "pueblo");
        addWord("oui", "yes", "si");
    }

    private static void addWord(String word, String translation1, String translation2) {
        Map<String, String> translations = new HashMap<>();
        translations.put("en", translation1);
        translations.put("es", translation2);
        dictionary.put(word, translations);
    }

    private static String findTranslation(String word) {
        if (dictionary.containsKey(word)) {
            Map<String, String> translations = dictionary.get(word);
            // Preguntar al ususario por el idioma a traducir
            Scanner scanner = new Scanner(System.in);
            System.out.print("Select the translation language (en/es): ");
            String language = scanner.nextLine().toLowerCase();
            if (translations.containsKey(language)) {
                return translations.get(language);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

}

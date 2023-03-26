import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Traducteur {
    private static Map<String, Map<String, String>> dictionary = new HashMap<>();

    public void traduire() {
        // Build the translation tree
        buildTree();
        
        // Ask the user to enter a word to translate
        Scanner scanner = new Scanner(System.in);
        System.out.print("Saisissez un mot à traduire: ");
        String word = scanner.nextLine().toLowerCase();
        
        // Look up the translation in the French to English/Spanish tree
        String translation = findTranslation(word);
        if (translation != null) {
            System.out.println("Traduction de " + word + ": " + translation);
        } else {
            System.out.println("Le mot " + word + " n'a pas de traduction dans ce dictionnaire.oui");
        }
    }

    private static void buildTree() {
        // Add words and their translations to the tree
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
            // Ask the user to select a language for the translation
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

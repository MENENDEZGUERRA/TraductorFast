import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//This class translates form spanish to en/fr
public class Translator {
    private static Map<String, Map<String, String>> dictionary = new HashMap<>();

    public static void main(String[] args) {
        // Build the translation tree
        buildTree();
        
        // Ask the user to enter a word to translate
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word to translate: ");
        String word = scanner.nextLine().toLowerCase();
        
        // Look up the translation in the Spanish to English/French tree
        String translation = findTranslation(word);
        if (translation != null) {
            System.out.println("Translation of " + word + ": " + translation);
        } else {
            System.out.println("The word " + word + " does not have a translation in this dictionary.");
        }
    }

    private static void buildTree() {
        // Add words and their translations to the tree
        addWord("casa", "house", "maison");
        addWord("perro", "dog", "chien");
        addWord("tarea", "homework", "devoirs");
        addWord("mujer", "woman", "femme");
        addWord("pueblo", "town", "ville");
        addWord("si", "yes", "oui");
    }

    private static void addWord(String word, String translation1, String translation2) {
        Map<String, String> translations = new HashMap<>();
        translations.put("en", translation1);
        translations.put("fr", translation2);
        dictionary.put(word, translations);
    }

    private static String findTranslation(String word) {
        if (dictionary.containsKey(word)) {
            Map<String, String> translations = dictionary.get(word);
            // Ask the user to select a language for the translation
            Scanner scanner = new Scanner(System.in);
            System.out.print("Select the translation language (en/fr): ");
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

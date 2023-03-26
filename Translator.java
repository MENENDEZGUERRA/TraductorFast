import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Translator {
    private static Map<String, Map<String, String>> dictionary = new HashMap<>();

    public void translate() {
        buildTree();
    
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word to translate: ");
        String word = scanner.nextLine().toLowerCase();
    
        String translation = findTranslation(word);
        if (translation != null) {
            System.out.println("Translation of " + word + ": " + translation);
        } else {
            System.out.println("The word " + word + " does not have a translation in this dictionary.");
        }
    }

    private static void buildTree() {
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

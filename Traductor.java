import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Traductor {
    
    private static Map<String, Map<String, String>> diccionario = new HashMap<>();
    
    public static void main(String[] args) {
        // Se construye el árbol de traducción
        construirArbol();
        
        // Se solicita al usuario que ingrese una palabra a traducir
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese una palabra para traducir: ");
        String palabra = scanner.nextLine().toLowerCase();
        
        // Se busca la traducción en el árbol inglés a es/fr
        String traduccion = buscarTraduccion(palabra);
        if (traduccion != null) {
            System.out.println("Traducción de " + palabra + ": " + traduccion);
        } else {
            System.out.println("La palabra " + palabra + " no tiene traducción en este diccionario.");
        }
    }
    
    private static void construirArbol() {
        // Se agregan las palabras y sus traducciones al árbol
        agregarPalabra("house", "casa", "loger");
        agregarPalabra("dog", "perro", "chien");
        agregarPalabra("homework", "tarea", "devoirs");
        agregarPalabra("woman", "mujer", "femme");
        agregarPalabra("town", "pueblo", "ville");
        agregarPalabra("yes", "si", "oui");
    }
    
    private static void agregarPalabra(String palabra, String traduccion1, String traduccion2) {
        Map<String, String> traducciones = new HashMap<>();
        traducciones.put("es", traduccion1);
        traducciones.put("fr", traduccion2);
        diccionario.put(palabra, traducciones);
    }
    
    private static String buscarTraduccion(String palabra) {
        if (diccionario.containsKey(palabra)) {
            Map<String, String> traducciones = diccionario.get(palabra);
            // Se solicita al usuario que seleccione un idioma para la traducción
            Scanner scanner = new Scanner(System.in);
            System.out.print("Seleccione el idioma de traducción (es/fr): ");
            String idioma = scanner.nextLine().toLowerCase();
            if (traducciones.containsKey(idioma)) {
                return traducciones.get(idioma);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}

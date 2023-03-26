import java.util.Scanner;

public class Main {
    //Traductores
    Translator translator = new Translator();
    Traductor traductor = new Traductor();
    Traducteur traducteur = new Traducteur();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            System.out.println("Please select an option:");
            System.out.println("1. Traductor Español a En/Fr");
            System.out.println("2. Translator English to Es/Fr");
            System.out.println("3. Traducteur Frances vers En/Fr");
            System.out.println("4. Exit/Salir/Aller à");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    option1();
                    break;
                case 2:
                    option2();
                    break;
                case 3:
                    option3();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    public static void option1() {
        System.out.println("Traductor Seleccionado");
        Traductor traductor = new Traductor();
        traductor.traducir();
    }

    public static void option2() {
        System.out.println("Translator Selected");
        Translator translator = new Translator();
        translator.translate();
    }

    public static void option3() {
        System.out.println("Traducteur Choisi");
        Traducteur traducteur = new Traducteur();
        traducteur.traduire();
    }
}

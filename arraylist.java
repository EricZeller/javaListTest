import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class arraylist {

    public static void main(String[] args) {
        List<String> meineListe = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Element hinzufügen");
            System.out.println("2. Element löschen");
            System.out.println("3. Liste anzeigen");
            System.out.println("4. Liste leeren");
            System.out.println("5. Liste umkehren");
            System.out.println("6. Programm beenden");
            System.out.print("Wähle eine Option: ");

            int option;
            while (true) {
                try {
                    option = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Ungültige Eingabe. Bitte gib eine Zahl ein.");
                    System.out.print("Wähle eine Option: ");
                }
            }

            switch (option) {
                case 1:
                    System.out.print("Gib das neue Element ein: ");
                    String neuesElement = scanner.nextLine();
                    meineListe.add(neuesElement);
                    System.out.println("Element hinzugefügt: " + neuesElement);
                    break;
                case 2:
                    if (!meineListe.isEmpty()) {
                        System.out.print("Gib die zu löschende Position ein (0 bis " + (meineListe.size() - 1) + "): ");
                        int position;
                        while (true) {
                            try {
                                position = Integer.parseInt(scanner.nextLine());
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Ungültige Eingabe. Bitte gib eine Zahl ein.");
                                System.out.print("Gib die zu löschende Position ein: ");
                            }
                        }

                        if (position >= 0 && position < meineListe.size()) {
                            String gelöschtesElement = meineListe.remove(position);
                            System.out.println("Element gelöscht: " + gelöschtesElement);
                        } else {
                            System.out.println("Ungültige Position.");
                        }
                    } else {
                        System.out.println("Die Liste ist leer. Keine Elemente zum Löschen.");
                    }
                    break;
                case 3:
                    if (!meineListe.isEmpty()) {
                        System.out.println("Aktuelle Liste:");
                        for (int i = 0; i < meineListe.size(); i++) {
                            System.out.println(i + ". " + meineListe.get(i));
                        }
                    } else {
                        System.out.println("Die Liste ist leer.");
                    }
                    break;
                case 4:
                    meineListe.clear();
                    System.out.println("Liste geleert.");
                    break;
                case 5:
                    if (!meineListe.isEmpty()) {
                        umkehren(meineListe);
                        System.out.println("Liste umgekehrt.");
                    } else {
                        System.out.println("Die Liste ist leer.");
                    }
                    break;
                case 6:
                    System.out.println("Programm beendet.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Ungültige Option. Bitte wähle 1, 2, 3, 4, 5 oder 6.");
                    break;
            }
        }
    }

    private static void umkehren(List<String> liste) {
        int start = 0;
        int ende = liste.size() - 1;

        while (start < ende) {
            // Elemente an den Positionen start und ende tauschen
            String temp = liste.get(start);
            liste.set(start, liste.get(ende));
            liste.set(ende, temp);

            start++;
            ende--;
        }
    }
}

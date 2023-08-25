import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    // nie zmieniaj nic w main
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();
        main.run(scanner);
    }

    void run(Scanner scanner) {
        // usupełnij metodę
        String fileName = "countries.csv";
        try {
            Map<String, Country> map = createMapFromFile(fileName);
            String userCode = getCodeFromUser(scanner);
            evaluateCode(map, userCode);
        } catch (FileNotFoundException e) {
            System.out.println("Brak pliku " + fileName + ".");
        }
    }

    private Map<String, Country> createMapFromFile(String fileName) throws FileNotFoundException {
        Map<String, Country> countriesMap = new HashMap<>();
        try (
                Scanner scanner = new Scanner(new File(fileName))
        ) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] splitedLine = line.split(";");
                String code = splitedLine[0];
                String name = splitedLine[1];
                int people = Integer.parseInt(splitedLine[2]);
                Country country = new Country(code, name, people);
                countriesMap.put(code, country);
            }
        }
        return countriesMap;
    }

    private String getCodeFromUser(Scanner scanner) {
        System.out.println("Podaj kod kraju, o którym chcesz zobaczyć informacje:");
        return scanner.nextLine().toUpperCase();
    }

    private void evaluateCode(Map<String, Country> map, String userCode) {
        if (map.containsKey(userCode)) {
            Country country = map.get(userCode);
            System.out.println(country);
        } else {
            System.out.println("Kod kraju " + userCode + " nie został znaleziony.");
        }
    }

}

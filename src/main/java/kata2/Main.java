package kata2;

import java.io.File;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        File file = new File("oscar_age_male.csv");
        List<OscarWinner> winners = new FileLoader(file).load();

        Map<String, Integer> hist = new OscarWinnerCalculator(5, winners).calculate();

        System.out.println("Números de oscars ganados por hombres según su edad: ");
        for (String key : hist.keySet().stream().sorted().toList()) {
            System.out.println(key + " " + hist.get(key));

        }
    }
}
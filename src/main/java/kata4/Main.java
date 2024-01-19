package kata4;

import kata2.FileLoader;
import kata2.OscarWinner;
import kata2.OscarWinnerCalculator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:oscar_winners_male.db");
        List<OscarWinner> winners = new SQLiteOscarWinnerLoader(connection).load();

        Map<String, Integer> hist = new OscarWinnerCalculator(5, winners).calculate();

        System.out.println("Números de oscars ganados por hombres según su edad: ");
        for (String key : hist.keySet().stream().sorted().toList()) {
            System.out.println(key + " " + hist.get(key));

        }
    }
}
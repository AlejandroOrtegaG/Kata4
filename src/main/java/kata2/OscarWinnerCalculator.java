package kata2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OscarWinnerCalculator implements HistogramCalculator{

    private int range;
    private List<OscarWinner> winners;

    public OscarWinnerCalculator(int range, List<OscarWinner> winners) {
        this.range = range;
        this.winners = winners;
    }

    @Override
    public Map<String, Integer> calculate() {

        Map <String, Integer> result = new HashMap<>();
        for (OscarWinner winner: winners) {
            String key = toRange(winner.getAge());
            result.put(key, result.getOrDefault(key, 0) +1);
        }
        return result;
    }

    private String toRange(int age) {
        return lowRange(age) + "-" + highRange(age);
    }

    private int highRange(int age) {
        return ((age/range) * range) + range - 1;
    }

    private int lowRange(int age) {
        return (age/range) * range;
    }
}

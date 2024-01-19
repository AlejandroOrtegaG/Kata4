package kata4;

import kata2.OscarWinner;
import kata2.OscarWinnerLoader;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SQLiteOscarWinnerLoader  implements OscarWinnerLoader {

    private Connection connection;

    public SQLiteOscarWinnerLoader(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<OscarWinner> load() {
        try {
            return load(query());
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    private ResultSet query() throws SQLException {
        return connection.createStatement().executeQuery(
                "SELECT * from oscar_winner_male"
        );
    }

    public List<OscarWinner> load (ResultSet resultSet) throws SQLException {
        List<OscarWinner> winners = new ArrayList<>();
        while (resultSet.next()){
            winners.add(winnerFrom(resultSet));
        }
        return winners;
    }

    private OscarWinner winnerFrom(ResultSet resultSet) throws SQLException {
        return new OscarWinner(
                resultSet.getInt("Year"),
                resultSet.getInt("Age"),
                resultSet.getString("Name"),
                resultSet.getString("Movie")
        );
    }
}

package kata2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class FileLoader  implements OscarWinnerLoader{

    private final File file;

    public FileLoader(File file) {
        this.file = file;
    }

    @Override
    public List<OscarWinner> load() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            return load(reader);
        } catch (Exception e){
            return Collections.emptyList();
        }
    }

    private List<OscarWinner> load(BufferedReader reader) throws IOException {
        return reader.lines().skip(1).map(this::toOscarWinner).collect(Collectors.toList());
    }

    private OscarWinner toOscarWinner(String s) {
        return toOscarWinner(s.split(","));
    }

    private OscarWinner toOscarWinner(String[] split) {
        return new OscarWinner(parseInt(split[0]),
                                parseInt(split[1]),
                                split[2],
                                split[3]);
    }
}

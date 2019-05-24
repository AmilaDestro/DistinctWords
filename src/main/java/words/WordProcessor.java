package words;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Implements data processing defined in {@link Readable} interface
 *
 * @author liudmyla.azarenko
 */
public class WordProcessor implements Readable {
    private final Set<String> distinctWords;
    private final List<String> data;

    public WordProcessor(final List<String> data) {
        this.data = data;
        this.distinctWords = new HashSet<>();
    }

    @Override
    public Set<String> processData() {
        return null;
    }
}

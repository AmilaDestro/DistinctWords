package tasks.words;

import java.util.Set;

/**
 * Interface which can process data obtained from a file
 *
 * @author liudmyla.azarenko
 */
public interface FileDataProcessor {

    /**
     * Processes received text data according to algorithm of implementing class
     */
    void processData();

    /**
     * Returns {@link Set} of distinct tasks.words from a file
     */
    Set<String> getDistinctWords();
}

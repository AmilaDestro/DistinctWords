package tasks.words;

import tasks.generics.ArrayToCollectionTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Implements receivedText processing defined in {@link FileDataProcessor} interface
 *
 * @author liudmyla.azarenko
 */
public class WordProcessor implements FileDataProcessor {
    private static final Logger LOG  = LoggerFactory.getLogger(WordProcessor.class);
    private static final String EXPRESSION = "[\\W\\s]+";

    private final Set<String> distinctWords;
    private final List<String> receivedText;
    private final ArrayToCollectionTransformer collectionTransformer;

    public WordProcessor(final List<String> receivedText) {
        this.receivedText = receivedText;
        this.distinctWords = new HashSet<>();
        this.collectionTransformer = new ArrayToCollectionTransformer<String>();
    }

    @Override
    public void processData() {
        LOG.info("Searching distinct tasks.words.");
        receivedText.forEach(text -> {
            List<String> allWords =
                    (List<String>) collectionTransformer.putObjectsFromArrayToCollection(text.split(EXPRESSION),
                                                                                         new ArrayList<>());
            Set<String> filteredWords = allWords.stream()
                                                .filter(word -> !isWordAlreadyInCollectionIgnoreCase(word))
                                                .collect(Collectors.toSet());

            distinctWords.addAll(filteredWords);
        });
        LOG.info("Search is finished.");
    }

    /**
     * Checks if passed word is already in the collection of distinct tasks.words
     * @param wordToCheck - {@link String} that will be checked
     * @return {@link Boolean} result
     */
    private Boolean isWordAlreadyInCollectionIgnoreCase(final String wordToCheck) {
        return distinctWords.stream()
                            .anyMatch(existingWord -> existingWord.equalsIgnoreCase(wordToCheck));
    }

    @Override
    public Set<String> getDistinctWords() {
        return distinctWords;
    }
}

import generics.ArrayToCollectionTransformer;
import increment.IncrementSynchronize;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reader.AbstractFileReader;
import reader.CustomFileReader;
import words.WordProcessor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * Main class of this application
 *
 * @author liudmyla.azarenko
 */
public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);
    private static final String DEFAULT_TEXT_FILE = "src\\main\\resources\\sample.txt";

    public static void main(String[] args) {
        // Task #1
        LOG.info("Performing task #1");
        final String fileToRead = (args.length == 0 ? DEFAULT_TEXT_FILE : args[0]);
        final AbstractFileReader reader = new CustomFileReader(fileToRead);
        reader.readFile();

        final List<String> fileData = reader.getFileData();
        final WordProcessor processor = new WordProcessor(fileData);
        processor.processData();

        LOG.info("Found distinct words: {}", processor.getDistinctWords());

        // Task #2
        LOG.info("Performing task #2");
        final Integer[] numbers = new Integer[] {10, 22, 17, 22, 44};

        LOG.info("Given array of {} numbers:", numbers.length);
        for(int i = 0; i < numbers.length; i++) {
            LOG.info("{}", numbers[i]);
        }

        LOG.info("It will be transformed to collection.");
        final ArrayToCollectionTransformer<Integer> collectionTransformer = new ArrayToCollectionTransformer<Integer>();
        final Collection numbersList =
                collectionTransformer.putObjectsFromArrayToCollection(numbers, new ArrayList<>());
        final Collection numbersSet =
                collectionTransformer.putObjectsFromArrayToCollection(numbers, new HashSet<>());
        LOG.info("Obtained list: {}", numbersList);
        LOG.info("Obtained set: {}", numbersSet);

        // Task #3
        LOG.info("Performing task #3");
        final Thread firstThread = new Thread(new IncrementSample());
        final Thread secondThread = new Thread(new IncrementSample());

        LOG.info("Starting the first thread");
        firstThread.start();

        LOG.info("Starting the second thread");
        secondThread.start();

        try {
            secondThread.join();
        } catch (InterruptedException e) {
            LOG.info("InterruptedException was thrown: {}", e.getCause());
        }
    }

    static class IncrementSample implements Runnable {
        final IncrementSynchronize incrementSynchronize;

        IncrementSample() {
            this.incrementSynchronize = new IncrementSynchronize();
        }

        @Override
        public void run() {
            LOG.info("getNextValue: {}", incrementSynchronize.getNextValue());
            LOG.info("getNextValueForInstance: {}", incrementSynchronize.getNextValueForInstance());
            LOG.info("getNextValueAtomic(): {}", incrementSynchronize.getNextValueAtomic());
            LOG.info("Summary value: {}", incrementSynchronize.getValue());
        }
    }
}

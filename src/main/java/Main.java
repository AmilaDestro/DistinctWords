import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reader.AbstractFileReader;
import reader.CustomFileReader;
import words.WordProcessor;

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
        final String fileToRead = (args.length == 0 ? DEFAULT_TEXT_FILE : args[0]);
        final AbstractFileReader reader = new CustomFileReader(fileToRead);
        reader.readFile();

        final List<String> fileData = reader.getFileData();
        final WordProcessor processor = new WordProcessor(fileData);
        processor.processData();

        LOG.info("Found distinct words: {}", processor.getDistinctWords());
    }
}

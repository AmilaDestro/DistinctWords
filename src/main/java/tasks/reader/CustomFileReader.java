package tasks.reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/**
 * File tasks.reader class which implements readFile method
 *
 * @author liudmyla.azarenko
 */
public class CustomFileReader extends AbstractFileReader {
    private static final Logger LOG = LoggerFactory.getLogger(CustomFileReader.class);

    public CustomFileReader(final String file) {
        super(file);
    }

    @Override
    public void readFile() {
        LOG.info("Starting to read file {}", file);

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while (reader.ready()) {
                fileData.add(reader.readLine());
            }
            reader.close();

        } catch (IOException e) {
            LOG.error("Error occurred while reading file: {}", e.getMessage());
        }
    }
}

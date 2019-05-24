package words;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


/**
 * File reader class which implements readFile method
 *
 * @author liudmyla.azarenko
 */
public class CustomFileReader extends AbstractFileReader {
    private static final Logger LOG = LoggerFactory.getLogger(CustomFileReader.class);

    public void readFile(final String filePath) {
        final File fileToRead = new File(filePath);

        try {
            readFile(fileToRead);
        } catch (IOException e) {
            LOG.info("An error occurred during file reading: {}", e.getMessage());
        }
    }

    @Override
    public void readFile(final File fileToRead) throws IOException {
        final BufferedReader reader = new BufferedReader(new FileReader(fileToRead));
        while (reader.ready()) {
            fileData.add(reader.readLine());
        }
        reader.close();
    }
}

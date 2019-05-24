package reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/**
 * File reader class which implements readFile method
 *
 * @author liudmyla.azarenko
 */
public class CustomFileReader extends AbstractFileReader {

    public CustomFileReader(final String file) {
        super(file);
    }

    @Override
    public void readFile() throws IOException {
        final BufferedReader reader = new BufferedReader(new FileReader(file));
        while (reader.ready()) {
            fileData.add(reader.readLine());
        }
        reader.close();
    }
}

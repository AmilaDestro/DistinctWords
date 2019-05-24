package words;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class that is responsible for file reading
 *
 * @author liudmyla.azarenko
 */
public abstract class AbstractFileReader {
    protected final List<String> fileData = new ArrayList<>();

    public abstract void readFile(final File fileToRead) throws IOException;

    public List<String> getFileData() {
        return fileData;
    }
}

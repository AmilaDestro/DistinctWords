package tasks.reader;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class that is responsible for file reading
 *
 * @author liudmyla.azarenko
 */
public abstract class AbstractFileReader {
    protected final List<String> fileData;
    protected final String file;

    public AbstractFileReader(final String file) {
        this.file = file;
        this.fileData = new ArrayList<>();
    }

    public abstract void readFile();

    public List<String> getFileData() {
        return fileData;
    }
}

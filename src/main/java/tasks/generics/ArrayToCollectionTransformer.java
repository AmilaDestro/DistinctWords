package tasks.generics;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * This class can transform array to specified collection (requirement of test task #2)
 *
 * @author liudmyla.azarenko
 */
public class ArrayToCollectionTransformer<T> {

    public Collection<T> putObjectsFromArrayToCollection(final T[] array, final Collection<T> collection) {
        List<T> arrayList = Arrays.asList(array);
        collection.addAll(arrayList);

        return collection;
    }
}

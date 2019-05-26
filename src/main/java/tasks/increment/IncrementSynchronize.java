package tasks.increment;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Class that performs synchronized tasks.increment of value in different ways (requirement of test task #3)
 *
 * @author liudmyla.azarenko
 */
public class IncrementSynchronize {
    private int value = 0;

    public synchronized int getNextValue() {
        return value++;
    }

    public int getNextValueForInstance() {
        synchronized (this) {
            return value++;
        }
    }

    public int getNextValueAtomic() {
        AtomicInteger atomicValue = new AtomicInteger(value);
        return atomicValue.getAndIncrement();
    }

    public int getValue() {
        return value;
    }
}

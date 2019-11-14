package grishalarin.testproject.mvp.core;

import androidx.annotation.NonNull;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Sostavkin Grisha
 */
public class PresenterCounter {

    private final Map<String, Integer> connections = new HashMap<>();

    @Inject
    public PresenterCounter() {

    }

    public void incrementCounter(@NonNull String tag) {
        Integer currentCount = connections.get(tag);
        if (currentCount == null) {
            currentCount = 1;
            connections.put(tag, currentCount);
            return;
        }
        connections.put(tag, currentCount + 1);
    }

    public boolean decrementCounter(@NonNull String tag) {
        Integer currentCount = connections.get(tag);
        if (currentCount == null) {
            throw new IllegalStateException("Invalid connections count");
        }
        if (currentCount == 1) {
            connections.remove(tag);
            return true;
        }
        connections.put(tag, currentCount - 1);
        return false;
    }
}

package grishalarin.testproject.mvp.core;

import androidx.annotation.NonNull;
import grishalarin.testproject.mvp.presenter.MvpPresenter;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Sostavkin Grisha
 */
public class PresenterStore {

    private Map<String, MvpPresenter> presenters = new HashMap<>();

    @Inject
    public PresenterStore() {

    }

    public <P extends MvpPresenter> P getPresenter(@NonNull String tag) {
        return (P) presenters.get(tag);
    }

    public void putPresenter(@NonNull String tag, @NonNull MvpPresenter presenter) {
        presenters.put(tag, presenter);
    }

    public void removePresenter(@NonNull String tag) {
        presenters.remove(tag);
    }
}


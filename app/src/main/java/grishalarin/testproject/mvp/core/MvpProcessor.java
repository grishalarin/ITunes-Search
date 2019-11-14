package grishalarin.testproject.mvp.core;

import androidx.annotation.NonNull;
import grishalarin.testproject.mvp.PresenterProvider;
import grishalarin.testproject.mvp.presenter.MvpPresenter;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author Sostavkin Grisha
 */
@Singleton
public class MvpProcessor {

    private final PresenterStore presenterStore;
    private final PresenterCounter presenterCounter;

    @Inject
    public MvpProcessor(PresenterStore presenterStore, PresenterCounter presenterCounter) {
        this.presenterStore = presenterStore;
        this.presenterCounter = presenterCounter;
    }

    public <P extends MvpPresenter> P getPresenter(@NonNull PresenterProvider<P> presenterProvider, String tag) {
        P presenter = presenterStore.getPresenter(tag);
        if (presenter == null) {
            presenter = presenterProvider.providePresenter();
            presenterStore.putPresenter(tag, presenter);
        }
        presenterCounter.incrementCounter(tag);
        return presenter;
    }

    public <P extends MvpPresenter> void freePresenter(@NonNull P presenter, String tag, boolean keepAlive) {
        if (presenterCounter.decrementCounter(tag)) {
            if (!keepAlive) {
                presenterStore.removePresenter(tag);
                presenter.destroy();
            }
        }
    }

}


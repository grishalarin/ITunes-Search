package grishalarin.testproject.mvp.presenter;

import androidx.annotation.NonNull;
import grishalarin.testproject.mvp.view.MvpView;

/**
 * @author Sostavkin Grisha
 */
public abstract class BaseMvpPresenter<V extends MvpView> implements MvpPresenter<V> {

    /**
     * Представление, ассоциированное с презентером.
     */
    protected V view;
    /**
     * Флаг, что презентер проинициализирован, т.е. начал свою работу
     */
    private boolean initialized = false;

    public void initialize() {
        if (!initialized) {
            initialized = true;
            onInitialize();
        }
    }

    protected abstract void onInitialize();

    public boolean isInitialized() {
        return initialized;
    }

    @Override
    public void bind(@NonNull V view) {
        this.view = view;
    }

    @Override
    public void unbind(@NonNull V view) {
        this.view = null;
    }

    @Override
    public void destroy() {

    }
}

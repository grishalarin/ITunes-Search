package grishalarin.testproject.mvp.presenter;

import androidx.annotation.NonNull;
import grishalarin.testproject.mvp.viewstate.MvpViewState;
import grishalarin.testproject.mvp.view.MvpView;

/**
 * @author Sostavkin Grisha
 */
public abstract class BaseMvpViewStatePresenter<V extends MvpView, VS extends MvpViewState<V>> implements MvpPresenter<V> {

    /**
     * Представление, ассоциированное с презентером.
     */
    protected final V view;
    /**
     * {@link MvpViewState} прослойка
     */
    private final VS viewState;
    /**
     * Флаг, что презентер проинициализирован, т.е. начал свою работу
     */
    private boolean initialized = false;

    public BaseMvpViewStatePresenter(VS viewState) {
        this.viewState = viewState;
        this.view = (V) viewState;
    }

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
        viewState.attachView(view);
    }

    @Override
    public void unbind(@NonNull V view) {
        viewState.detachView(view);
    }

    @Override
    public void destroy() {

    }
}

package grishalarin.testproject.mvp.viewstate;

import grishalarin.testproject.mvp.view.MvpView;

/**
 * @author Sostavkin Grisha
 */
public interface MvpViewState<V extends MvpView> {

    /**
     * Присоединение view.
     *
     * @param view Присоединенная view
     */
    void attachView(V view);

    /**
     * Отсоединение view.
     *
     * @param view Отсоединенная view
     */
    void detachView(V view);
}
package grishalarin.testproject.mvp;

import grishalarin.testproject.mvp.presenter.MvpPresenter;

/**
 * @author Sostavkin Grisha
 */
public interface PresenterProvider<P extends MvpPresenter> {
    P providePresenter();
}

package grishalarin.testproject.mvp.presenter;

import androidx.annotation.NonNull;
import grishalarin.testproject.mvp.view.MvpView;

/**
 * @author Sostavkin Grisha
 */
public interface MvpPresenter<V extends MvpView> {
    /**
     * Привязывает {@link MvpView} к презентеру
     *
     * @param view Представление
     */
    void bind(@NonNull V view);

    /**
     * Отвязывает {@link MvpView} от презентера
     *
     * @param view
     */
    void unbind(@NonNull V view);

    /**
     * Вызывается при очищении ссылки на презентер.
     * Последняя точка, в которой нужно отвязаться от всех static ссылок.
     */
    void destroy();
}

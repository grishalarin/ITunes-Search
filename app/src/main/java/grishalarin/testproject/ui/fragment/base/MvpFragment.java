package grishalarin.testproject.ui.fragment.base;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import grishalarin.testproject.AppComponent;
import grishalarin.testproject.mvp.MvpDelegate;
import grishalarin.testproject.mvp.view.MvpView;

/**
 * @author Sostavkin Grisha
 */
public abstract class MvpFragment extends Fragment {

    private MvpDelegate mvpDelegate;
    /**
     * Флаг, что был вызван {@link #onSaveInstanceState(Bundle)}
     */
    private boolean mIsStateSaved;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mvpDelegate = new MvpDelegate(AppComponent.Companion.get().mvpProcessor(), (MvpView) this);
        mvpDelegate.init(savedInstanceState);
    }

    public MvpDelegate getMvpDelegate() {
        return mvpDelegate;
    }

    @Override
    public void onStart() {
        super.onStart();
        mvpDelegate.bindView();
    }

    @Override
    public void onResume() {
        super.onResume();
        mIsStateSaved = false;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mvpDelegate.saveState(outState);
        mIsStateSaved = true;
    }

    @Override
    public void onStop() {
        mvpDelegate.unbindView();
        super.onStop();
    }

    @Override
    public void onDestroy() {
        mvpDelegate.destroy(keepAlive());
        super.onDestroy();
    }

    protected boolean keepAlive() {
        boolean keepAlive = true;

        if (mIsStateSaved) {
            mIsStateSaved = false;
        } else {
            boolean anyParentIsRemoving = false;

            Fragment parent = getParentFragment();
            while (!anyParentIsRemoving && parent != null) {
                anyParentIsRemoving = parent.isRemoving();
                parent = parent.getParentFragment();
            }

            if (isRemoving() || anyParentIsRemoving || getActivity().isFinishing()) {
                keepAlive = false;
            }
        }
        return keepAlive;
    }
}

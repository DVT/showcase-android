package za.co.dvt.android.showcase.presentation.base;


import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Base class that implements the Presenter interface and provides a base implementation for
 * attachView() and detachView(). It also handles keeping a reference to the mvpView that
 * can be accessed from the children classes by calling getView().
 */
public abstract class BasePresenter<T extends MvpView> implements MvpPresenter<T> {

    private T view;

    private CompositeDisposable compositeSubscription = new CompositeDisposable();

    @Override
    public void attachView(T mvpView) {
        view = mvpView;
    }

    @Override
    public void detachView() {
        clearSubscriptions();
        view = null;
    }

    public void clearSubscriptions() {
        compositeSubscription.clear();
    }

    public T getView() {
        return view;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) {
            throw new MvpViewNotAttachedException();
        }
    }

    public boolean isViewAttached() {
        return view != null;
    }

    public void addDisposable(Disposable disposable) {
        this.compositeSubscription.add(disposable);
    }

    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.attachView(MvpView) before" + " requesting data to the Presenter");
        }
    }
}

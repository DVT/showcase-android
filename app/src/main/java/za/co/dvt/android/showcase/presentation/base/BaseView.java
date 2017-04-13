package za.co.dvt.android.showcase.presentation.base;

/**
 * @author rebeccafranks
 * @since 2017/04/13
 */
public interface BaseView<T> {

    void setPresenter(T presenter);

    boolean isActive();

}


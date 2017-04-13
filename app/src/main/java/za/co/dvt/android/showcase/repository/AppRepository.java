package za.co.dvt.android.showcase.repository;

import java.util.List;

import io.reactivex.Maybe;
import za.co.dvt.android.showcase.model.AppModel;

/**
 * @author rebeccafranks
 * @since 2017/04/13
 */
public interface AppRepository {

    Maybe<List<AppModel>> getListApps();

}

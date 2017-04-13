package za.co.dvt.android.showcase.repository.impl;

import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import durdinapps.rxfirebase2.RxFirebaseDatabase;
import io.reactivex.Maybe;
import za.co.dvt.android.showcase.model.AppModel;
import za.co.dvt.android.showcase.repository.AppRepository;

/**
 * @author rebeccafranks
 * @since 2017/04/13
 */

public class FirebaseAppRepository implements AppRepository {

    private final FirebaseDatabase firebaseDatabase;

    public FirebaseAppRepository(FirebaseDatabase firebaseDatabase) {
        this.firebaseDatabase = firebaseDatabase;
    }

    @Override
    public Maybe<List<AppModel>> getListApps() {
        return RxFirebaseDatabase
                .observeSingleValueEvent(firebaseDatabase.getReference().child("apps"), AppModel::createList);
    }

}

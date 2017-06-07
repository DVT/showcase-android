package za.co.dvt.android.showcase.repository.impl;

import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

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
        return Maybe.empty();
       /* return firebaseDatabase.getReference().child("apps").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });*/
    }

}

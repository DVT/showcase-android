package za.co.dvt.android.showcase.model;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;
import java.util.List;

import me.mattlogan.auto.value.firebase.annotation.FirebaseValue;

/**
 * @author rebeccafranks
 * @since 2017/04/13
 */
@AutoValue
@FirebaseValue
public abstract class AppModel {

    public abstract String name();

    public abstract String shortDescription();

    public abstract boolean enabled();

    @Nullable
    public abstract String iconUrl();

    public abstract String functionality();

    @Nullable
    public abstract String technologyUsed();

    @Nullable
    public abstract String client();

    public static AppModel create(DataSnapshot dataSnapshot) {
        return dataSnapshot.getValue(AutoValue_AppModel.FirebaseValue.class).toAutoValue();
    }

    public Object toFirebaseValue() {
        return new AutoValue_AppModel.FirebaseValue(this);
    }

    public static List<AppModel> createList(DataSnapshot snapshot) {
        List apps = new ArrayList();
        for (DataSnapshot child : snapshot.getChildren()) {
            apps.add(create(child));
        }
        return apps;
    }

}

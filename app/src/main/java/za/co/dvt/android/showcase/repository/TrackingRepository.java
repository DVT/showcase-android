package za.co.dvt.android.showcase.repository;

import za.co.dvt.android.showcase.model.AppModel;

/**
 * @author rebeccafranks
 * @since 2017/04/13
 */

public interface TrackingRepository {

    void trackViewUserLogin();

    void trackViewListApps();

    void trackViewAppDetail(AppModel appModel);

    void trackViewContactUs();

    void trackViewAboutDVT();

}

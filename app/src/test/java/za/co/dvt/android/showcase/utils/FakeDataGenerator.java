package za.co.dvt.android.showcase.utils;

import java.util.ArrayList;
import java.util.List;

import za.co.dvt.android.showcase.model.AppModel;

public class FakeDataGenerator {


    public static List<AppModel> generateApps() {
        AppModel appModel = AppModel.create("Fake App Name", "Short description",
                true, "https://dvt.co.za/img.jpg", "Functionality", "tech used", "client");
        List<AppModel> appModels = new ArrayList<>();
        appModels.add(appModel);

        return appModels;

    }
}
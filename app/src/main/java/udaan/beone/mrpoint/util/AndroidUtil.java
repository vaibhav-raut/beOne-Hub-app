package udaan.beone.mrpoint.util;

import android.app.Activity;
import android.content.Intent;

import udaan.beone.mrpoint.activity.LoginActivity;
import udaan.beone.mrpoint.data.DataManager;

/**
 * Created by Vaibhav on 3/14/2016.
 */
public class AndroidUtil {

    public static void launchActivity(Activity a, Class b) {

        Intent i = new Intent(a, b);
        Intent is[] = new Intent[1];
        is[0] = i;
        a.startActivities(is);
    }

    public static void logout(Activity a) {
        DataManager.instance().onLogout();
        launchActivity(a, LoginActivity.class);
    }
}

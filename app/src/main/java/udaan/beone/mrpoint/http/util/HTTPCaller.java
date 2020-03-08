package udaan.beone.mrpoint.http.util;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import udaan.beone.mrpoint.util.AndroidUtil;

/**
 * A login screen that offers login via email/password.
 */
public abstract class HTTPCaller {

    protected Activity activity;
    protected String call;

    public HTTPCaller(Activity activity, String call) {
        this.activity = activity;
        this.call = call;
    }

    public Activity getActivity() {
        return activity;
    }

    public String getCall() {
        return call;
    }

    public abstract void httpSuccessCallback(String jsonResponce);
    public void httpFailureCallback(String message) {
        Log.e("Udaan", "Call: " + call + " : Failed; Error " + message);
        Toast.makeText(activity, call + " : Failed; Error " + message, Toast.LENGTH_SHORT).show();
        AndroidUtil.logout(activity);
    }
    public void httpErrorCallback(String message) {
        Log.e("Udaan", "Call: " + call + " : Failed; Error " + message);
        Toast.makeText(activity, call + " : Failed; Error " + message, Toast.LENGTH_SHORT).show();
        AndroidUtil.logout(activity);
    }

    public static class ActiveDummy extends HTTPCaller {
        public ActiveDummy(Activity activity, String call) {
            super(activity, call);
        }
        public void httpSuccessCallback(String jsonResponce) {
            Log.e("Udaan", "Call: " + call + " is Successful!");
            Toast.makeText(activity, "Call: " + call + " is Successful!", Toast.LENGTH_SHORT).show();
        }
    }

    public static class PassiveDummy extends HTTPCaller {
        public PassiveDummy(Activity activity, String call) {
            super(activity, call);
        }
        @Override
        public void httpSuccessCallback(String jsonResponce) {
        }
        @Override
        public void httpFailureCallback(String message) {
        }
        @Override
        public void httpErrorCallback(String message) {
        }
    }

}


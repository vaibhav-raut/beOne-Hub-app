package udaan.beone.mrpoint.http.util;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import udaan.beone.mrpoint.data.DataManager;
import udaan.beone.mrpoint.util.AndroidUtil;
import udaan.beone.mrpoint.util.DateUtil;

/**
 * Created by Vaibhav on 3/11/2016.
 */
public class HTTPTask extends AsyncTask<Void, Void, Void> {

    public static final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("application/json");

    final public static long TOKEN_EXPIRE = DateUtil.MIN * 55;

    private HTTPCaller caller;
    private String jsonRequestStr;
    private String call;
    List<String> urlArgs;
    private boolean success;
    private String jsonResponseStr;
    private String message;

    public HTTPTask(HTTPCaller caller, String jsonRequestStr, String call, List<String> urlArgs) {
        this.caller = caller;
        this.jsonRequestStr = jsonRequestStr;
        this.call = call;
        this.urlArgs = urlArgs;
        success = false;
    }

    @Override
    protected Void doInBackground(Void... params) {

        try {

            OkHttpClient client = new OkHttpClient();
//            Log.d("Udaan", "doInBackground: jsonRequestStr: " + jsonRequestStr);
//            Log.d("Udaan", "doInBackground: call: " + call);

            String url = HTTPUtil.getCallURL(call);
            if(urlArgs != null && !urlArgs.isEmpty()) {
                for(String arg: urlArgs) {
                    url = url + "/" + arg;
                }
            }

            Log.d("Udaan", "doInBackground: url: " + url);

            // Set URL In Request Builder
            Request.Builder requestBuilder = new Request.Builder().url(url);

            // Set Header Parameters
            if(HTTPUtil.isNonTokenCall(call)) {
                requestBuilder.addHeader("Accept", "application/json")
                        .addHeader("Content-Type", "application/json");

//                Log.d("Udaan", "doInBackground: NonTokenCall");
            } else {
                checkForTokenExpiry();
                requestBuilder.addHeader("Accept", "application/json")
                        .addHeader("Content-Type", "application/json")
                        .addHeader("AUTH-Token", DataManager.instance().getAuthToken())
                        .addHeader("MEM-Ac-No", Long.toString(DataManager.instance().getLoginMemberAcNo()))
                        .addHeader("SEL-GRP-Ac-No", Long.toString(DataManager.instance().getSelectedGroupAcNo()));

//                Log.d("Udaan", "doInBackground: TokenCall");
            }

            switch(HTTPUtil.getCallType(call)) {
                case HTTPConst.PUT_CALL:
                    if(jsonRequestStr != null && !jsonRequestStr.isEmpty()) {
                        requestBuilder.put(RequestBody.create(MEDIA_TYPE_MARKDOWN, jsonRequestStr));
                        Log.d("Udaan", "doInBackground: PUT_CALL jsonRequestStr: " + jsonRequestStr);
                    } else {
                        success = false;
                        caller.httpErrorCallback(null);
                        return null;
                    }
                    break;

                case HTTPConst.POST_CALL:
                    if(jsonRequestStr != null && !jsonRequestStr.isEmpty()) {
                        requestBuilder.post(RequestBody.create(MEDIA_TYPE_MARKDOWN, jsonRequestStr));
                        Log.d("Udaan", "doInBackground: POST_CALL jsonRequestStr: " + jsonRequestStr);
                    } else {
                        success = false;
                        caller.httpErrorCallback(null);
                        return null;
                    }
                    break;

                case HTTPConst.GET_CALL:
                    requestBuilder.get();
//                    Log.d("Udaan", "doInBackground: GET_CALL");
                    break;

                case HTTPConst.DELETE_CALL:
                    if(jsonRequestStr == null || jsonRequestStr.isEmpty()) {
                        requestBuilder.delete();
                    } else {
                        requestBuilder.delete(RequestBody.create(MEDIA_TYPE_MARKDOWN, jsonRequestStr));
                    }
                    Log.d("Udaan", "doInBackground: DELETE_CALL jsonRequestStr: " + jsonRequestStr);
                    break;
            }

            Request request = requestBuilder.build();
//            Log.d("Udaan", "doInBackground: Request Built");

            Response response = client.newCall(request).execute();

//            Log.d("Udaan", "doInBackground: Response");

            if(response.code() == 200) {
                jsonResponseStr = response.body().string();
                Log.d("Udaan", "doInBackground: result: " + jsonResponseStr);

                if(jsonResponseStr != null && !jsonResponseStr.isEmpty()) {
                    if(HTTPUtil.saveResponseData(call, jsonResponseStr)) {
                        success = true;
                    }
                }
            }
            if(!success) {
                message = (response.code() + ": " + response.message());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        if(success) {
            caller.httpSuccessCallback(jsonResponseStr);
        } else {
            caller.httpFailureCallback(message);
        }
    }

    protected void checkForTokenExpiry() {
        if(DataManager.instance().getAuthToken() == null ||
                (System.currentTimeMillis() - DataManager.instance().getAuthTokenTime()) > TOKEN_EXPIRE) {
            AndroidUtil.logout(caller.getActivity());
        }
    }
}

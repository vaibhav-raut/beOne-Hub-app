package udaan.beone.mrpoint.activity;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import udaan.beone.mrpoint.R;
import udaan.beone.mrpoint.activity.dialog.OkDialog;
import udaan.beone.mrpoint.data.DataManager;
import udaan.beone.mrpoint.http.model.LoginRequestREST;
import udaan.beone.mrpoint.http.util.HTTPCaller;
import udaan.beone.mrpoint.http.util.HTTPConst;
import udaan.beone.mrpoint.http.util.HTTPTask;
import udaan.beone.mrpoint.util.AndroidUtil;
import udaan.beone.mrpoint.util.EnumConst;
import udaan.beone.mrpoint.widget.TextInputLayout;


public class LoginActivity extends AppCompatActivity {

    private RelativeLayout mRoot;
    private TextInputLayout mDitrictCodeLayout;
    private TextInputLayout mGroupNoLayout;
    private TextInputLayout mMemberNoLayout;
    private TextInputLayout mPasswordLayout;
    private TextInputLayout mIPLayout;

    private EditText mInputDitrictCode;
    private EditText mInputGroupNo;
    private EditText mInputMemberNo; 
    private EditText mInputPassword;
    private EditText mInputIP;
    private AcPersist acPersist;
    private Button loginBn;
    private ProgressBar progressBar;

//    private FloatingActionButton mFAB;
    private View.OnClickListener mSnackBarClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

//    private View.OnClickListener mFabClickListener = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            Snackbar.make(mRoot, "FAB Clicked", Snackbar.LENGTH_SHORT)
//                    .show();
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mRoot = (RelativeLayout) findViewById(R.id.root_activity_login);

        mDitrictCodeLayout = (TextInputLayout) findViewById(R.id.district_code_layout);
        mGroupNoLayout = (TextInputLayout) findViewById(R.id.group_no_layout);
        mMemberNoLayout = (TextInputLayout) findViewById(R.id.member_no_layout);
        mPasswordLayout = (TextInputLayout) findViewById(R.id.password_layout);
        mIPLayout = (TextInputLayout) findViewById(R.id.ip_layout);

        mInputDitrictCode = (EditText) findViewById(R.id.input_district_code);
        mInputGroupNo = (EditText) findViewById(R.id.input_group_no);
        mInputMemberNo = (EditText) findViewById(R.id.input_member_no);
        mInputPassword = (EditText) findViewById(R.id.input_password);

        mInputIP = (EditText) findViewById(R.id.input_ip);

        loginBn = (Button) findViewById(R.id.login_bn);

//        mFAB = (FloatingActionButton) findViewById(R.id.fab);
//        mFAB.setOnClickListener(mFabClickListener);
        acPersist  = getAcPersist();
        acPersist.reloadUserLogin();

        if(!HTTPConst.localIPActive()) {
            mIPLayout.setVisibility(View.GONE);
        } else {
            mIPLayout.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onBackPressed() {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void submit(View view) {

        boolean isDistrictCodeValid = isDistrictCodeValid();
        boolean isGroupNoValid = isGroupNoValid();
        boolean isMemberNoValid = isMemberNoValid();
        boolean isPasswordValid = isPasswordValid();

        if(!isDistrictCodeValid) {
            mInputDitrictCode.setError("Invalid District Code!");
        }
        else if(!isGroupNoValid) {
            mInputGroupNo.setError("Invalid Group No!");
        }
        else if(!isMemberNoValid) {
            mInputMemberNo.setError("Invalid Member No!");
        }
        else if(!isPasswordValid) {
            mInputPassword.setError("Invalid Password!");
        }
        else {
            if(HTTPConst.localIPActive()) {
                String ipStr = mInputIP.getText().toString();
                DataManager.instance().setIpNo(ipStr);
            }

            loginBn.setEnabled(false);
            progressBar = (ProgressBar) this.findViewById(R.id.progress_bar);
            progressBar.setVisibility(View.VISIBLE);

            LoginRequestREST request = new LoginRequestREST();
            request.setMemberDistrictCode(mInputDitrictCode.getText().toString());
            request.setGroupNo(Long.parseLong(mInputGroupNo.getText().toString()));
            request.setMemberNo(Long.parseLong(mInputMemberNo.getText().toString()));
            request.setPasscode(mInputPassword.getText().toString());

            DataManager.instance().setLoginRequestREST(request);

            HTTPTask task = new HTTPTask(new LoginCaller(this, HTTPConst.AUTH_LOGIN),
                    LoginRequestREST.JSONRepo.buildJSONString(request),
                    HTTPConst.AUTH_LOGIN, null);

            task.execute();

            Log.d("Debug", "onClick: login is successful!");
        }
    }

    private boolean isDistrictCodeValid() {
        return (mInputDitrictCode.getText() != null  &&
                isDistrictCodeValid(mInputDitrictCode.getText().toString()));
    }

    private boolean isGroupNoValid() {
        return (mInputGroupNo.getText() != null  &&
                isGroupNoValid(mInputGroupNo.getText().toString()));
    }

    private boolean isMemberNoValid() {
        return (mInputMemberNo.getText() != null  &&
                isMemberNoValid(mInputMemberNo.getText().toString()));
    }

    private boolean isPasswordValid() {
        return (mInputPassword.getText() != null &&
                isPasswordValid(mInputPassword.getText().toString()));

    }

    private boolean isDistrictCodeValid(String s) {
        return (s != null &&
                s.length() == 4);
    }

    private boolean isGroupNoValid(String s) {
        return (s != null &&
                s.length() > 0);
    }

    private boolean isMemberNoValid(String s) {
        return (s != null &&
                s.length() > 0);
    }

    private boolean isPasswordValid(String s) {
        return (s != null &&
                s.length() >= 6 &&
                s.length() < 32);

    }

    protected class LoginCaller extends HTTPCaller {
        public LoginCaller(Activity activity, String call) {
            super(activity, call);
        }

        @Override
        public void httpSuccessCallback(String jsonResponce) {
            Toast.makeText(activity, "Login is Successful!", Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);

            if(DataManager.instance().getLoginInfoREST().getGroupType().equals(EnumConst.GroupType_Mega_HUB)) {
                // Save the User Login Info
                acPersist.saveUserLogin();

                // Launch Home Page
                AndroidUtil.launchActivity(activity, HubActivity.class);
            }
            else {
                // Clear the User Login Info
                acPersist.clearUserLogin();

                new OkDialog(activity, "Invalid Login!", "Only Mega HUB Users can Login!").show();

                AndroidUtil.logout(activity);
            }
        }
        @Override
        public void httpFailureCallback(String message) {
            Log.e("Udaan", "Call: " + call + " is Failed!");
            Toast.makeText(activity, "Call: " + call + " is Failed!", Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
            loginBn.setEnabled(true);
        }
        @Override
        public void httpErrorCallback(String message) {
            Log.e("Udaan", "Call: " + call + " is Failed!");
            Toast.makeText(activity, "Call: " + call + " is Failed!", Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
            loginBn.setEnabled(true);
        }
    }

    public AcPersist getAcPersist() {
//        if (android.os.Build.VERSION.SDK_INT >= 22) {
//            return new AcPersist22(this);
//        }else{
            return new AcPersistLegacy(this);
//        }
    }

    public abstract class AcPersist {

        protected LoginActivity loginActivity;

        public AcPersist(LoginActivity loginActivity) {
            this.loginActivity = loginActivity;
        }
        public abstract void reloadUserLogin();
        public abstract void saveUserLogin();
        public abstract void clearUserLogin();
    }

    @TargetApi(22)
    public class AcPersist22 extends AcPersist {

        public AcPersist22(LoginActivity loginActivity) {
            super(loginActivity);
        }
        @Override
        public void reloadUserLogin() {

            AccountManager manager = AccountManager.get(loginActivity);
            Account[] accounts = manager.getAccountsByType(DataManager.ACCOUNT_TYPE);
            boolean dataLoaded = false;

            if(accounts != null) {
                for (Account account : accounts) {

                    if(dataLoaded) {
                        manager.removeAccountExplicitly(account);
                    }

                    String name = account.name;
                    String[] userIdParts = name.split(DataManager.ACCOUNT_USERNAME_DELIMITER);
                    String password = manager.getPassword(account);

                    if(userIdParts.length == 3 &&
                            isDistrictCodeValid(userIdParts[0]) &&
                            isGroupNoValid(userIdParts[1]) &&
                            isMemberNoValid(userIdParts[2]) &&
                            isPasswordValid(password)) {

                        mInputDitrictCode.setText(userIdParts[0]);
                        mInputGroupNo.setText(userIdParts[1]);
                        mInputMemberNo.setText(userIdParts[2]);
                        mInputPassword.setText(password);

                        dataLoaded = true;
                    }
                    else {
                        manager.removeAccountExplicitly(account);
                    }
                }
            }
        }
        @Override
        public void saveUserLogin() {
            AccountManager manager = AccountManager.get(loginActivity);
            Account[] accounts = manager.getAccountsByType(DataManager.ACCOUNT_TYPE);

            if(accounts != null) {
                for (Account account : accounts) {
                    manager.removeAccountExplicitly(account);
                }
            }

            String username = mInputDitrictCode.getText().toString() + DataManager.ACCOUNT_USERNAME_DELIMITER +
                    mInputGroupNo.getText().toString() + DataManager.ACCOUNT_USERNAME_DELIMITER +
                    mInputMemberNo.getText().toString();
            String password = mInputPassword.getText().toString();

            final Account account = new Account(username, DataManager.ACCOUNT_TYPE);
            manager.addAccountExplicitly(account, password, null);
        }
        @Override
        public void clearUserLogin() {
        }
    }

    public class AcPersistLegacy extends AcPersist {

        public AcPersistLegacy(LoginActivity loginActivity) {
            super(loginActivity);
        }
        @Override
        public void reloadUserLogin() {

            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(loginActivity);
            String userId = sharedPreferences.getString(DataManager.ACCOUNT_USER, null);
            String password = sharedPreferences.getString(DataManager.ACCOUNT_PASSWORD, null);

            String ipStr = null;
            if(HTTPConst.localIPActive()) {
                ipStr = sharedPreferences.getString(DataManager.ACCOUNT_LOCAL_IP, "");
            }

            if(userId != null && password != null) {
                String[] userIdParts = userId.split(DataManager.ACCOUNT_USERNAME_DELIMITER);

                if (userIdParts.length == 3 &&
                        isDistrictCodeValid(userIdParts[0]) &&
                        isGroupNoValid(userIdParts[1]) &&
                        isMemberNoValid(userIdParts[2]) &&
                        isPasswordValid(password)) {

                    mInputDitrictCode.setText(userIdParts[0]);
                    mInputGroupNo.setText(userIdParts[1]);
                    mInputMemberNo.setText(userIdParts[2]);
                    mInputPassword.setText(password);

                    if(HTTPConst.localIPActive()) {
                        mInputIP.setText(ipStr);
                    }
                }
            }
        }
        @Override
        public void saveUserLogin() {

            String userId = mInputDitrictCode.getText().toString() + DataManager.ACCOUNT_USERNAME_DELIMITER +
                    mInputGroupNo.getText().toString() + DataManager.ACCOUNT_USERNAME_DELIMITER +
                    mInputMemberNo.getText().toString();
            String password = mInputPassword.getText().toString();

            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(loginActivity);
            sharedPreferences.edit().putString(DataManager.ACCOUNT_USER, userId).apply();
            sharedPreferences.edit().putString(DataManager.ACCOUNT_PASSWORD, password).apply();

            if(HTTPConst.localIPActive()) {
                String ipStr = mInputIP.getText().toString();
                sharedPreferences.edit().putString(DataManager.ACCOUNT_LOCAL_IP, ipStr).apply();
            }
        }
        @Override
        public void clearUserLogin() {
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(loginActivity);
            sharedPreferences.edit().putString(DataManager.ACCOUNT_USER, null).apply();
            sharedPreferences.edit().putString(DataManager.ACCOUNT_PASSWORD, null).apply();
        }
    }
}

package udaan.beone.mrpoint.activity;
/**
 * Author Vaibhav
 * Date 15/06/15
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import udaan.beone.mrpoint.R;
import udaan.beone.mrpoint.activity.adapter.ShowItemAdapter;
import udaan.beone.mrpoint.http.model.StockItem;
import udaan.beone.mrpoint.http.util.HTTPCaller;
import udaan.beone.mrpoint.http.util.HTTPConst;
import udaan.beone.mrpoint.http.util.HTTPTask;
import udaan.beone.mrpoint.util.AndroidUtil;
import udaan.beone.mrpoint.util.DataUtil;


public class VerifyTagActivity extends AppCompatActivity implements OnClickListener{

    protected TextView gsActionTitle;

    protected Button gsClearAllBn;
    protected Button gsDoneBn;
    protected Button gsVerifyBn;
    protected EditText gsStockItemId;
    protected TextView gsTagVerified;

    protected RecyclerView mRecyclerView;
    protected ShowItemAdapter adapter;

    protected ProgressBar progressBar;

    protected int totalTagVerifedNo = DataUtil.ZERO_INTEGER;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Main Activity Init
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_tag);

        gsClearAllBn = (Button) findViewById(R.id.gs_clear_all_bn);
        gsDoneBn = (Button) findViewById(R.id.gs_done_bn);
        gsVerifyBn = (Button) findViewById(R.id.gs_verify_item_bn);

        gsStockItemId = (EditText) findViewById(R.id.gs_stock_item_id);

        gsTagVerified = (TextView) findViewById(R.id.gs_item_verified_v);

        // Initialize recycler view
        mRecyclerView = (RecyclerView) findViewById(R.id.show_item_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ShowItemAdapter(this);
        mRecyclerView.setAdapter(adapter);

        gsClearAllBn.setOnClickListener(this);
        gsDoneBn.setOnClickListener(this);
        gsVerifyBn.setOnClickListener(this);

        gsTagVerified.setText(Integer.toString(totalTagVerifedNo));
    }

    @Override
    public void onClick(View var1) {

        switch(var1.getId()) {

            case R.id.gs_clear_all_bn: {

                totalTagVerifedNo = DataUtil.ZERO_INTEGER;
                gsTagVerified.setText(Integer.toString(totalTagVerifedNo));

                if(adapter != null) {
                    adapter.clearAllItems();
                }
                break;
            }

            case R.id.gs_done_bn: {
                clear();
                AndroidUtil.launchActivity(this, HubActivity.class);
                break;
            }

            case R.id.gs_verify_item_bn: {


                String stockItemStr = gsStockItemId.getText().toString();
                if (stockItemStr == null || stockItemStr.isEmpty()) {
                    Toast.makeText(this, "Please enter Stock Item Id before Select!", Toast.LENGTH_SHORT).show();
                    return;
                }

                long stockItemId = Long.parseLong(stockItemStr);
                gsStockItemId.setText("");

                if (stockItemId <= 0) {
                    Toast.makeText(this, "Invalid Stock Item Id!", Toast.LENGTH_LONG).show();
                    gsStockItemId.setText("");
                    return;
                }

                gsClearAllBn.setEnabled(false);
                gsDoneBn.setEnabled(false);
                gsVerifyBn.setEnabled(false);

                List<String> urlArgs = new ArrayList<String>(1);
                urlArgs.add(Long.toString(stockItemId));

                HTTPTask task = new HTTPTask(new VerifyTagCaller(this, HTTPConst.INV_VERIFY_STOCK_ID),
                        null, HTTPConst.INV_VERIFY_STOCK_ID, urlArgs);
                task.execute();

                progressBar = (ProgressBar) this.findViewById(R.id.progress_bar);
                progressBar.setVisibility(View.VISIBLE);

                break;
            }
        }
    }

    @Override
    protected void onPostResume () {
        super.onPostResume();
    }
    @Override
    public void onBackPressed() {
    }

    private void clear() {
        if(adapter != null) {
            adapter.clearAllItems();
        }

        gsClearAllBn = null;
        gsDoneBn = null;
        gsVerifyBn = null;
        gsStockItemId = null;
        gsTagVerified = null;
        mRecyclerView = null;
        adapter = null;
    }

    public class VerifyTagCaller extends HTTPCaller {
        private VerifyTagActivity activity;

        public VerifyTagCaller(VerifyTagActivity activity, String call) {
            super(activity, call);
            this.activity = activity;
        }
        @Override
        public void httpSuccessCallback(String jsonResponce){
            if(jsonResponce != null && !jsonResponce.isEmpty()) {

                StockItem item = (StockItem) StockItem.JSONRepo.buildObject(jsonResponce);
                if (item == null) {
                    httpFailureCallback(jsonResponce);
                    return;
                }

                adapter.addItem(item);

                totalTagVerifedNo++;
                gsTagVerified.setText(Integer.toString(totalTagVerifedNo));
            }

            progressBar.setVisibility(View.GONE);

            gsClearAllBn.setEnabled(true);
            gsDoneBn.setEnabled(true);
            gsVerifyBn.setEnabled(true);

            Toast.makeText(activity, call + " is Successful!", Toast.LENGTH_SHORT).show();
        }
        @Override
        public void httpFailureCallback(String message) {
            progressBar.setVisibility(View.GONE);

            gsClearAllBn.setEnabled(true);
            gsDoneBn.setEnabled(true);
            gsVerifyBn.setEnabled(true);

            Log.e("Udaan", "Call: " + call + " is Failed! jsonResponce : " + message);
            Toast.makeText(activity, call + " : Failed; Error " + message, Toast.LENGTH_SHORT).show();
        }
        @Override
        public void httpErrorCallback(String message) {
            progressBar.setVisibility(View.GONE);

            gsClearAllBn.setEnabled(true);
            gsDoneBn.setEnabled(true);
            gsVerifyBn.setEnabled(true);

            Log.e("Udaan", "Call: " + call + " is Failed! jsonResponce : " + message);
            Toast.makeText(activity, call + " : Failed; Error " + message, Toast.LENGTH_SHORT).show();
        }
    }
}

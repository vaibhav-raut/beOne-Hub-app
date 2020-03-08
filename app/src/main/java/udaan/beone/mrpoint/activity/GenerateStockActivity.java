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
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

import udaan.beone.mrpoint.R;
import udaan.beone.mrpoint.activity.adapter.GenerateStockAdapter;
import udaan.beone.mrpoint.http.model.Lot;
import udaan.beone.mrpoint.http.util.HTTPCaller;
import udaan.beone.mrpoint.http.util.HTTPConst;
import udaan.beone.mrpoint.http.util.HTTPTask;
import udaan.beone.mrpoint.util.AndroidUtil;
import udaan.beone.mrpoint.util.DataUtil;

public abstract class GenerateStockActivity extends AppCompatActivity implements OnClickListener,
        GenerateStockAdapter.OnStockNoListener {

    protected TextView gsActionTitle;

    protected Button gsRefreshBn;
    protected Button gsDoneBn;
    protected Button gsGenerateBn;
    protected Button gsSelectBn;
    protected Button gsClearBn;

    protected EditText gsEType;

    protected LinearLayout stockTypeLL;
    protected LinearLayout stockTypeStat1LL;
    protected LinearLayout stockTypeStat2LL;
    protected LinearLayout stockTypeStat3LL;

    protected TextView typeTV;
    protected TextView typeIdTV;

    protected TextView purchaseTV;
    protected TextView createdTV;
    protected TextView verifiedTV;
    protected TextView toStockTV;
    protected TextView toStockGenTV;

    protected RecyclerView mRecyclerView;
    protected GenerateStockAdapter adapter;
    protected ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Main Activity Init
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_stock);

        gsActionTitle = (TextView) findViewById(R.id.gs_action_title);

        gsRefreshBn = (Button) findViewById(R.id.gs_refresh_bn);
        gsDoneBn = (Button) findViewById(R.id.gs_done_bn);
        gsGenerateBn = (Button) findViewById(R.id.gs_generate_bn);
        gsSelectBn = (Button) findViewById(R.id.gs_select_stock_type_bn);
        gsClearBn = (Button) findViewById(R.id.gs_clear_bn);

        gsEType = (EditText) findViewById(R.id.gs_e_stock_type);

        stockTypeLL = (LinearLayout) findViewById(R.id.gs_stock_type_layout);
        stockTypeStat1LL = (LinearLayout) findViewById(R.id.gs_stat1_layout);
        stockTypeStat2LL = (LinearLayout) findViewById(R.id.gs_stat2_layout);
        stockTypeStat3LL = (LinearLayout) findViewById(R.id.gs_stat3_layout);

        typeTV = (TextView) findViewById(R.id.gs_stock_type_v);
        typeIdTV = (TextView) findViewById(R.id.gs_stock_type_id_v);

        purchaseTV = (TextView) findViewById(R.id.gs_purchase_v);
        createdTV = (TextView) findViewById(R.id.gs_created_v);
        verifiedTV = (TextView) findViewById(R.id.gs_verified_v);
        toStockTV = (TextView) findViewById(R.id.gs_to_stock_v);
        toStockGenTV = (TextView) findViewById(R.id.gs_to_stock_gen_v);

        // Initialize recycler view
        mRecyclerView = (RecyclerView) findViewById(R.id.show_item_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new GenerateStockAdapter(this, null);
        mRecyclerView.setAdapter(adapter);

        gsRefreshBn.setOnClickListener(this);
        gsDoneBn.setOnClickListener(this);
        gsGenerateBn.setOnClickListener(this);
        gsSelectBn.setOnClickListener(this);
        gsClearBn.setOnClickListener(this);

        gsRefreshBn.setEnabled(false);
        gsGenerateBn.setEnabled(false);
        gsClearBn.setEnabled(false);
    }

    public abstract void clearSub();
    public abstract boolean isValidTypeSelected();
    public abstract void selectType(String typeStr);
    protected abstract void refreshLotData();

    @Override
    public void onClick(View var1) {

        switch(var1.getId()) {

            case R.id.gs_refresh_bn: {
                refreshLotData();
                break;
            }

            case R.id.gs_done_bn: {
                clear();
                AndroidUtil.launchActivity(this, HubActivity.class);
                break;
            }

            case R.id.gs_generate_bn: {

                if(adapter != null && adapter.getLots() != null && adapter.getLots().size() > 0) {

                    setBnEnabled(false);

                    progressBar = (ProgressBar) this.findViewById(R.id.progress_bar);
                    progressBar.setVisibility(View.VISIBLE);

                    List<Lot.LotS> lots = adapter.getLotsToGenerate();

                    ObjectMapper mapper = new ObjectMapper();
                    String jsonString = null;
                    try {
                        jsonString = mapper.writeValueAsString(lots);
                    } catch (IOException e) {
                        Toast.makeText(this, "Please Select Stock to Generate!", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    HTTPTask task = new HTTPTask(new GenerateStockCaller(this, HTTPConst.INV_GENERATE_STOCK_FROM_LOTS),
                            jsonString, HTTPConst.INV_GENERATE_STOCK_FROM_LOTS, null);
                    task.execute();
                }
                else {
                    Toast.makeText(this, "Please Select Stock to Generate!", Toast.LENGTH_SHORT).show();
                }

                break;
            }

            case R.id.gs_select_stock_type_bn: {

                String typeStr = gsEType.getText().toString();
                if (typeStr == null || typeStr.length() < 3) {
                    Toast.makeText(this, "Please Type more than 2 Characters!", Toast.LENGTH_SHORT).show();
                    return;
                }

                setBnEnabled(false);

                progressBar = (ProgressBar) this.findViewById(R.id.progress_bar);
                progressBar.setVisibility(View.VISIBLE);

                selectType(typeStr);
                break;
            }

            case R.id.gs_clear_bn: {
                stockTypeLL.setVisibility(View.GONE);
                stockTypeStat1LL.setVisibility(View.GONE);
                stockTypeStat2LL.setVisibility(View.GONE);
                stockTypeStat3LL.setVisibility(View.GONE);
                typeTV.setText("");
                typeIdTV.setText("");
                adapter.clearAll();
                clearSub();
                break;
            }
        }
    }

    @Override
    public void onStockNoChange(int noPurchased, int noCreated, int noVerified, int noToStock, int noToGenerate) {
        if(noPurchased > 0) {
            stockTypeStat1LL.setVisibility(View.VISIBLE);
            stockTypeStat2LL.setVisibility(View.VISIBLE);
            stockTypeStat3LL.setVisibility(View.VISIBLE);

            purchaseTV.setText(Integer.toString(noPurchased));
            createdTV.setText(Integer.toString(noCreated));
            verifiedTV.setText(Integer.toString(noVerified));
            toStockTV.setText(Integer.toString(noToStock));
            toStockGenTV.setText(Integer.toString(noToGenerate));

        } else {
            stockTypeStat1LL.setVisibility(View.GONE);
            stockTypeStat2LL.setVisibility(View.GONE);
            stockTypeStat3LL.setVisibility(View.GONE);
        }

        gsGenerateBn.setEnabled(noToGenerate > 0);
    }

    protected void setBnEnabled(boolean status) {

        if(status && isValidTypeSelected()) {
            gsRefreshBn.setEnabled(status);
            gsClearBn.setEnabled(status);
        } else {
            gsRefreshBn.setEnabled(false);
            gsClearBn.setEnabled(false);
        }

        int toStockGenNo = 0;
        String toStockGenStr = toStockGenTV.getText().toString();
        if(toStockGenStr != null && !toStockGenStr.isEmpty()) {
            toStockGenNo = Integer.parseInt(toStockGenStr);
        }
        if(status && toStockGenNo > 0) {
            gsGenerateBn.setEnabled(status);
        } else {
            gsGenerateBn.setEnabled(false);
        }

        gsDoneBn.setEnabled(status);
        gsSelectBn.setEnabled(status);
    }

    protected void updateLots(List<Lot> lots) {
        if(adapter != null) {
            adapter.clear();
        }
        adapter = new GenerateStockAdapter(this, lots);
        mRecyclerView.setAdapter(adapter);
    }

    private void clear() {

        gsRefreshBn = null;
        gsDoneBn = null;
        gsGenerateBn = null;
        gsSelectBn = null;
        gsEType = null;

        stockTypeLL = null;
        typeTV = null;
        typeIdTV = null;

        purchaseTV = null;
        createdTV = null;
        verifiedTV = null;
        toStockTV = null;
        toStockGenTV = null;
        mRecyclerView = null;
        adapter = null;
    }

    public class LoadLotsCaller extends HTTPCaller {
        private GenerateStockActivity activity;

        public LoadLotsCaller(GenerateStockActivity activity, String call) {
            super(activity, call);
            this.activity = activity;
        }
        public void httpSuccessCallback(String jsonResponce){

            if(jsonResponce != null && !jsonResponce.isEmpty()) {

                ObjectMapper mapper = new ObjectMapper();
                List<Lot> lots = null;
                try {
                    lots = (List<Lot>)mapper.readValue(jsonResponce,
                            mapper.getTypeFactory().constructCollectionType(List.class, Lot.class));
                } catch (IOException e) {
                    Toast.makeText(activity, "No Lot available for given Stock Type!", Toast.LENGTH_SHORT).show();
                }

                if(lots != null && !lots.isEmpty()) {
                    activity.updateLots(lots);
                }
                else {
                    Toast.makeText(activity, "No Lot available for given Stock Type!", Toast.LENGTH_SHORT).show();
                }
            }
            else {
                Toast.makeText(activity, "No Lot available for given Stock Type!", Toast.LENGTH_SHORT).show();
            }

            progressBar.setVisibility(View.GONE);
            Toast.makeText(activity, gsActionTitle.getText().toString() + " is Successful!", Toast.LENGTH_SHORT).show();

            setBnEnabled(true);
        }
        public void httpFailureCallback(String message) {
            progressBar.setVisibility(View.GONE);

            setBnEnabled(true);

            Log.e("Udaan", "Call: " + call + " is Failed!");
            Toast.makeText(activity, "Call: " + call + " is Failed! Please try Again!", Toast.LENGTH_SHORT).show();
        }
        public void httpErrorCallback(String message) {
            progressBar.setVisibility(View.GONE);

            setBnEnabled(true);

            Log.e("Udaan", "Call: " + call + " is Failed!");
            Toast.makeText(activity, "Call: " + call + " is Failed! Please try Again!", Toast.LENGTH_SHORT).show();
        }
    }

    public class GenerateStockCaller extends HTTPCaller {
        private GenerateStockActivity activity;

        public GenerateStockCaller(GenerateStockActivity activity, String call) {
            super(activity, call);
            this.activity = activity;
        }
        public void httpSuccessCallback(String jsonResponce){

            progressBar.setVisibility(View.GONE);
            Toast.makeText(activity, gsActionTitle.getText().toString() + " is Successful!", Toast.LENGTH_SHORT).show();

            setBnEnabled(true);

            refreshLotData();
        }
        public void httpFailureCallback(String message) {
            progressBar.setVisibility(View.GONE);

            setBnEnabled(true);

            Log.e("Udaan", "Call: " + call + " is Failed!");
            Toast.makeText(activity, "Call: " + call + " is Failed! Please try Again!", Toast.LENGTH_SHORT).show();
        }
        public void httpErrorCallback(String message) {
            progressBar.setVisibility(View.GONE);

            setBnEnabled(true);

            Log.e("Udaan", "Call: " + call + " is Failed!");
            Toast.makeText(activity, "Call: " + call + " is Failed! Please try Again!", Toast.LENGTH_SHORT).show();
        }
    }
}

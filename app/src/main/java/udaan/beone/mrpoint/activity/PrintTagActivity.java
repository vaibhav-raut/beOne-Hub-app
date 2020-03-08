package udaan.beone.mrpoint.activity;
/**
 * Author Vaibhav
 * Date 15/06/16
 */

import android.content.Context;
import android.os.Bundle;
import android.print.PrintManager;
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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

import udaan.beone.mrpoint.R;
import udaan.beone.mrpoint.activity.adapter.StockTagAdapter;
import udaan.beone.mrpoint.activity.print.PrintTagAdapter;
import udaan.beone.mrpoint.http.model.ItemTagM;
import udaan.beone.mrpoint.http.model.ItemTagO;
import udaan.beone.mrpoint.http.util.HTTPCaller;
import udaan.beone.mrpoint.http.util.HTTPConst;
import udaan.beone.mrpoint.http.util.HTTPTask;
import udaan.beone.mrpoint.util.DataUtil;


public abstract class PrintTagActivity extends AppCompatActivity implements OnClickListener,
        StockTagAdapter.OnStockTagListener, PrintTagAdapter.OnPrintJobFinish{

    protected TextView gsActionTitle;

    protected LinearLayout gsSelectTypeIdLL;
    protected LinearLayout stockTypeStat1LL;
    protected LinearLayout gsSuccessMessageLL1;
    protected LinearLayout gsSuccessMessageLL2;

    protected Button gsRefreshBn;
    protected Button gsDoneBn;
    protected Button gsActionBn;

    protected EditText gsTypeId;
    protected Button gsSelectTypeBn;
    protected Button gsClearBn;

    protected Spinner gsNoOfStickers;

    protected TextView typeTV;
    protected TextView typeIdTV;

    protected Button gsPrintSuccessNoBn;
    protected Button gsPrintSuccessYesBn;

    protected TextView totalTags;
    protected TextView totalTagsToPrint;

    protected RecyclerView mRecyclerView;
    protected StockTagAdapter adapter;

    protected ProgressBar progressBar;

    protected ItemTagO itemTagO;
    protected List<ItemTagM> toPrintItemTags;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Main Activity Init
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_tag);

        gsActionTitle = (TextView) findViewById(R.id.gs_action_title);

        gsRefreshBn = (Button) findViewById(R.id.gs_refresh_bn);
        gsDoneBn = (Button) findViewById(R.id.gs_done_bn);
        gsActionBn = (Button) findViewById(R.id.gs_action_bn);

        gsSelectTypeIdLL = (LinearLayout) findViewById(R.id.gs_select_type_id_ll);
        gsTypeId = (EditText) findViewById(R.id.gs_type_id);
        gsSelectTypeBn = (Button) findViewById(R.id.gs_select_type_bn);
        gsClearBn = (Button) findViewById(R.id.gs_clear_bn);

        gsNoOfStickers = (Spinner) findViewById(R.id.gs_no_of_stickers);
        gsNoOfStickers.setSelection(1);

        stockTypeStat1LL = (LinearLayout) findViewById(R.id.gs_stock_type_layout);
        typeTV = (TextView) findViewById(R.id.gs_stock_type_v);
        typeIdTV = (TextView) findViewById(R.id.gs_stock_type_id_v);

        gsSuccessMessageLL1 = (LinearLayout) findViewById(R.id.gs_success_message_ll_1);
        gsSuccessMessageLL2 = (LinearLayout) findViewById(R.id.gs_success_message_ll_2);
        gsPrintSuccessNoBn = (Button) findViewById(R.id.gs_print_success_no_bn);
        gsPrintSuccessYesBn = (Button) findViewById(R.id.gs_print_success_yes_bn);

        totalTags = (TextView) findViewById(R.id.gs_total_tags_v);
        totalTagsToPrint = (TextView) findViewById(R.id.gs_total_tags_to_print_v);

        // Initialize recycler view
        mRecyclerView = (RecyclerView) findViewById(R.id.stock_tag_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        gsRefreshBn.setOnClickListener(this);
        gsDoneBn.setOnClickListener(this);
        gsActionBn.setOnClickListener(this);
        gsSelectTypeBn.setOnClickListener(this);
        gsClearBn.setOnClickListener(this);
        gsPrintSuccessNoBn.setOnClickListener(this);
        gsPrintSuccessYesBn.setOnClickListener(this);

        gsRefreshBn.setEnabled(false);
        gsActionBn.setEnabled(false);
        gsClearBn.setEnabled(false);
    }

    public abstract void clearSub();
    public abstract boolean isValidTypeSelected();
    public abstract void selectType(String typeStr);
    protected abstract void reloadTagData();
    protected void setBnEnabled(boolean status) {

        if(status && isValidTypeSelected()) {
            gsRefreshBn.setEnabled(status);
            gsClearBn.setEnabled(status);
        } else {
            gsRefreshBn.setEnabled(false);
            gsClearBn.setEnabled(false);
        }

        int totalTagsToPrintNo = 0;
        String totalTagsToPrintStr = totalTagsToPrint.getText().toString();
        if(totalTagsToPrintStr != null && !totalTagsToPrintStr.isEmpty()) {
            totalTagsToPrintNo = Integer.parseInt(totalTagsToPrintStr);
        }
        if(status && totalTagsToPrintNo > 0) {
            gsActionBn.setEnabled(status);
        } else {
            gsActionBn.setEnabled(false);
        }

        gsDoneBn.setEnabled(status);
        gsSelectTypeBn.setEnabled(status);
    }
    @Override
    public void onClick(View var1) {

        switch(var1.getId()) {

            case R.id.gs_refresh_bn: {
                reloadTagData();
                break;
            }

            case R.id.gs_done_bn: {
                clear();
                super.onBackPressed();
                break;
            }

            case R.id.gs_action_bn: {

                // Build Item Tags To Print
                buildItemTagsToPrint();

                if(toPrintItemTags != null && !toPrintItemTags.isEmpty()) {

                    setBnEnabled(false);

                    PrintManager printManager = (PrintManager) this.getSystemService(Context.PRINT_SERVICE);
                    String jobName = this.getString(R.string.app_name) + " Document";
                    int noOfStickers = Integer.parseInt((String)gsNoOfStickers.getSelectedItem());

                    printManager.print(jobName, new PrintTagAdapter(this, this, toPrintItemTags, noOfStickers), null);
                }
                else {
                    Toast.makeText(this, "No Item Tags Available to Print!", Toast.LENGTH_SHORT).show();
                }

                break;
            }

            case R.id.gs_select_type_bn: {

                String typeStr = gsTypeId.getText().toString();
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
                stockTypeStat1LL.setVisibility(View.GONE);
                typeTV.setText("");
                typeIdTV.setText("");
                resetAdapterData();
                clearSub();
                break;
            }

            case R.id.gs_print_success_no_bn: {

                bnEnableForPrint(true);
                break;
            }

            case R.id.gs_print_success_yes_bn: {

                markTagPrinted();
                bnEnableForPrint(true);
                break;
            }
        }
    }

    @Override
    public void onStockTagNosPrintChange(int tagNos, int tagsToPrintNo) {

        totalTags.setText(DataUtil.toString(tagNos));
        totalTagsToPrint.setText(DataUtil.toString(tagsToPrintNo));

        gsActionBn.setEnabled(tagsToPrintNo > 0);
    }

    @Override
    protected void onPostResume () {
        super.onPostResume();
    }
    @Override
    public void onBackPressed() {
    }
    public void buildItemTagsToPrint() {
        toPrintItemTags = new ArrayList<ItemTagM>();
        List<StockTagAdapter.StockTagItem> stockTagItems = adapter.getItems();

        if(itemTagO != null && itemTagO.getByTypes() != null && !itemTagO.getByTypes().isEmpty() &&
                stockTagItems != null && !stockTagItems.isEmpty()) {

            int typeNo = itemTagO.getByTypes().size();
            for (int i = 0; i < typeNo; i++) {
                for (int j = 0; j < stockTagItems.get(i).getItemNosToPrint(); j++) {
                    toPrintItemTags.add(itemTagO.getByTypes().get(i).getItemTags().get(j));
                }
            }
        }
    }

    public void onPrintJobSuccess() {
        bnEnableForPrint(false);
    }
    public void bnEnableForPrint(boolean status) {

        setBnEnabled(status);
        gsSelectTypeIdLL.setEnabled(status);
        mRecyclerView.setEnabled(status);
        gsNoOfStickers.setEnabled(status);

        if(status) {
            gsSuccessMessageLL1.setVisibility(View.GONE);
            gsSuccessMessageLL2.setVisibility(View.GONE);
        } else {
            gsSuccessMessageLL1.setVisibility(View.VISIBLE);
            gsSuccessMessageLL2.setVisibility(View.VISIBLE);
        }
    }

    public void onPrintJobFailuer() {
    }
    public void markTagPrinted() {

        progressBar = (ProgressBar) this.findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);

        String jsonString = null;
        try {
            jsonString = new ObjectMapper().writeValueAsString(toPrintItemTags);
        } catch (Exception e) {
        }

        HTTPTask task = new HTTPTask(new MarkTagPrintedCaller(this, HTTPConst.INV_MARK_ITEM_TAGS_PRINTED), jsonString,
                HTTPConst.INV_MARK_ITEM_TAGS_PRINTED, null);
        task.execute();
    }

    private void clear() {

        gsRefreshBn = null;
        gsDoneBn = null;
        gsActionBn = null;
        totalTags = null;
        totalTagsToPrint = null;
        mRecyclerView = null;
        adapter = null;
    }

    private void resetAdapterData() {
        if(adapter != null) {
            adapter.clearAllItems();
        }
        totalTags.setText(DataUtil.toString(DataUtil.ZERO_INTEGER));
        totalTagsToPrint.setText(DataUtil.toString(DataUtil.ZERO_INTEGER));
    }
    public class ActiveItemTagCaller extends HTTPCaller {
        private PrintTagActivity activity;

        public ActiveItemTagCaller(PrintTagActivity activity, String call) {
            super(activity, call);
            this.activity = activity;
        }
        @Override
        public void httpSuccessCallback(String jsonResponce){

            if(jsonResponce != null && !jsonResponce.isEmpty()) {

                itemTagO = (ItemTagO) ItemTagO.JSONRepo.buildObject(jsonResponce);
                if (itemTagO == null) {
                    httpFailureCallback(jsonResponce);
                    resetAdapterData();
                    return;
                }

                if(itemTagO.getByTypes() == null || itemTagO.getByTypes().isEmpty()) {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(activity, "No Item Tag Available for Printing!", Toast.LENGTH_SHORT).show();
                    resetAdapterData();
                    return;
                }

                adapter = new StockTagAdapter(activity, itemTagO);
                mRecyclerView.setAdapter(adapter);

                totalTags.setText(Integer.toString(itemTagO.getItemNos()));
                totalTagsToPrint.setText(Integer.toString(itemTagO.getItemNos()));
                gsActionBn.setEnabled(itemTagO.getItemNos() > 0);
            }

            progressBar.setVisibility(View.GONE);
            Toast.makeText(activity, call + " is Successful!", Toast.LENGTH_SHORT).show();
        }
        @Override
        public void httpFailureCallback(String message) {
            progressBar.setVisibility(View.GONE);
            Log.e("Udaan", "Call: " + call + " is Failed!");
            Toast.makeText(activity, call + " is Failed! Please try Again!", Toast.LENGTH_SHORT).show();
            resetAdapterData();
        }
        @Override
        public void httpErrorCallback(String message) {
            progressBar.setVisibility(View.GONE);
            Log.e("Udaan", "Call: " + call + " is Failed!");
            Toast.makeText(activity, call + " is Failed! Please try Again!", Toast.LENGTH_SHORT).show();
            resetAdapterData();
        }
    }

    public class MarkTagPrintedCaller extends HTTPCaller {
        private PrintTagActivity activity;

        public MarkTagPrintedCaller(PrintTagActivity activity, String call) {
            super(activity, call);
            this.activity = activity;
        }
        @Override
        public void httpSuccessCallback(String jsonResponce){
            progressBar.setVisibility(View.GONE);
            Log.e("Udaan", "Call: " + call + " is Successful!");
            Toast.makeText(activity, call + " is Successful!", Toast.LENGTH_SHORT).show();
            reloadTagData();
        }
        @Override
        public void httpFailureCallback(String message) {
            progressBar.setVisibility(View.GONE);
            Log.e("Udaan", "Call: " + call + " is Failed!");
            Toast.makeText(activity, call + " is Failed! Please try Again!", Toast.LENGTH_SHORT).show();
        }
        @Override
        public void httpErrorCallback(String message) {
            progressBar.setVisibility(View.GONE);
            Log.e("Udaan", "Call: " + call + " is Failed!");
            Toast.makeText(activity, call + " is Failed! Please try Again!", Toast.LENGTH_SHORT).show();
        }
    }

//    public class ConfirmPrintDialog extends ActionDialog {
//        private PrintTagActivity activity;
//        public ConfirmPrintDialog(PrintTagActivity context, String title, String message, String button1Name, String button2Name) {
//            super(context, title, message, button1Name, button2Name);
//            this.activity = context;
//        }
//        @Override
//        public void onClick(View v) {
//            switch (v.getId()) {
//                case R.id.ac_button_1:
//                    this.dismiss();
//                    break;
//
//                case R.id.ac_button_2:
//                    activity.markTagPrinted();
//                    this.dismiss();
//                    break;
//            }
//        }
//    }
}

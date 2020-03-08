package udaan.beone.mrpoint.activity;
/**
 * Author Vaibhav
 * Date 15/06/16
 */

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import udaan.beone.mrpoint.R;
import udaan.beone.mrpoint.activity.dialog.SelectStockTypeDialog;
import udaan.beone.mrpoint.http.model.StockTypeName;
import udaan.beone.mrpoint.http.util.HTTPCaller;
import udaan.beone.mrpoint.http.util.HTTPConst;
import udaan.beone.mrpoint.http.util.HTTPTask;

public class StockTypeGenStockActivity extends GenerateStockActivity implements SelectStockTypeDialog.OnStockTypeListener {

    protected StockTypeName stockType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Main Activity Init
        super.onCreate(savedInstanceState);

//        gsEType.setHint("Stock Type");

        gsActionTitle.setText("Stock @ Stock Type");

        ((TextView) findViewById(R.id.gs_stock_type)).setText("Stock Type");
        ((TextView) findViewById(R.id.gs_stock_type_id)).setText("ID");
    }

    public void clearSub() {
        stockType = null;
        gsRefreshBn.setEnabled(false);
        gsGenerateBn.setEnabled(false);
        gsClearBn.setEnabled(false);
    }
    @Override
    public boolean isValidTypeSelected() {
        return stockType != null;
    }

    public void selectType(String typeStr) {

        List<String> urlArgs = new ArrayList<String>(1);
        urlArgs.add(typeStr);

        HTTPTask task = new HTTPTask(new SearchStockTypeCaller(this, HTTPConst.INV_SEARCH_STOCK_TYPE),
                null, HTTPConst.INV_SEARCH_STOCK_TYPE, urlArgs);
        task.execute();
    }

    protected void refreshLotData() {

        if(stockType != null) {
            setBnEnabled(false);

            progressBar = (ProgressBar) this.findViewById(R.id.progress_bar);
            progressBar.setVisibility(View.VISIBLE);

            List<String> urlArgs = new ArrayList<String>(1);
            urlArgs.add(Long.toString(stockType.getStockTypeId()));

            HTTPTask task = new HTTPTask(new LoadLotsCaller(this, HTTPConst.INV_GET_LOTS_TO_STOCK_FOR_TYPE),
                    null, HTTPConst.INV_GET_LOTS_TO_STOCK_FOR_TYPE, urlArgs);
            task.execute();
        }
    }

    @Override
    public void onStockTypeSelect(StockTypeName stockTypeName) {

        this.stockType = stockTypeName;
        gsRefreshBn.setEnabled(stockTypeName != null);
        gsClearBn.setEnabled(stockTypeName != null);

        typeTV.setText(stockType.getStockTypeName());
        typeIdTV.setText(Long.toString(stockType.getStockTypeId()));
        stockTypeLL.setVisibility(View.VISIBLE);

        refreshLotData();
    }

    @Override
    protected void onPostResume () {
        super.onPostResume();
    }
    @Override
    public void onBackPressed() {
    }

    public class SearchStockTypeCaller extends HTTPCaller {
        private StockTypeGenStockActivity activity;

        public SearchStockTypeCaller(StockTypeGenStockActivity activity, String call) {
            super(activity, call);
            this.activity = activity;
        }
        public void httpSuccessCallback(String jsonResponce){

            List<StockTypeName> stockTypeNames = null;
            if(jsonResponce != null && !jsonResponce.isEmpty()) {

                ObjectMapper mapper = new ObjectMapper();
                try {
                    stockTypeNames = (List<StockTypeName>)mapper.readValue(jsonResponce,
                            mapper.getTypeFactory().constructCollectionType(List.class, StockTypeName.class));
                } catch (IOException e) {
                    Toast.makeText(activity, "No Stock Type available for given characters", Toast.LENGTH_SHORT).show();
                }
            }
            else {
                Toast.makeText(activity, "No Stock Type available for given characters", Toast.LENGTH_SHORT).show();
            }

            gsEType.setText("");
            progressBar.setVisibility(View.GONE);

            setBnEnabled(true);

            if(stockTypeNames != null && !stockTypeNames.isEmpty()) {
                new SelectStockTypeDialog(activity, activity, stockTypeNames).show();
            }
            else {
                Toast.makeText(activity, "No Stock Type available for given characters", Toast.LENGTH_SHORT).show();
            }
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

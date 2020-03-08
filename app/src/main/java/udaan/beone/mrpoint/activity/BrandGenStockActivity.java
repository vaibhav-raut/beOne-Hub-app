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
import udaan.beone.mrpoint.activity.dialog.SelectBrandDialog;
import udaan.beone.mrpoint.http.model.BrandName;
import udaan.beone.mrpoint.http.util.HTTPCaller;
import udaan.beone.mrpoint.http.util.HTTPConst;
import udaan.beone.mrpoint.http.util.HTTPTask;

public class BrandGenStockActivity extends GenerateStockActivity implements SelectBrandDialog.OnBrandListener {

    protected BrandName brand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Main Activity Init
        super.onCreate(savedInstanceState);

//        gsEType.setHint("Stock Type");

        gsActionTitle.setText("Stock @ Brand");

        ((TextView) findViewById(R.id.gs_stock_type)).setText("Brand");
        ((TextView) findViewById(R.id.gs_stock_type_id)).setText("ID");
    }

    @Override
    public void clearSub() {
        brand = null;
        gsRefreshBn.setEnabled(false);
        gsGenerateBn.setEnabled(false);
        gsClearBn.setEnabled(false);
    }
    @Override
    public boolean isValidTypeSelected() {
        return brand != null;
    }

    @Override
    public void selectType(String typeStr) {

        List<String> urlArgs = new ArrayList<String>(1);
        urlArgs.add(typeStr);

        HTTPTask task = new HTTPTask(new SearchBrandCaller(this, HTTPConst.INV_SEARCH_BRAND),
                null, HTTPConst.INV_SEARCH_BRAND, urlArgs);
        task.execute();
    }

    @Override
    protected void refreshLotData() {

        if(brand != null) {
            setBnEnabled(false);

            progressBar = (ProgressBar) this.findViewById(R.id.progress_bar);
            progressBar.setVisibility(View.VISIBLE);

            List<String> urlArgs = new ArrayList<String>(1);
            urlArgs.add(Long.toString(brand.getBrandId()));

            HTTPTask task = new HTTPTask(new LoadLotsCaller(this, HTTPConst.INV_GET_LOTS_TO_STOCK_FOR_BRAND),
                    null, HTTPConst.INV_GET_LOTS_TO_STOCK_FOR_BRAND, urlArgs);
            task.execute();
        }
    }

    @Override
    protected void onPostResume () {
        super.onPostResume();
    }
    @Override
    public void onBackPressed() {
    }

    @Override
    public void onBrandSelect(BrandName brandName) {
        this.brand = brandName;
        gsRefreshBn.setEnabled(brandName != null);
        gsClearBn.setEnabled(brandName != null);

        typeTV.setText(brand.getBrandName());
        typeIdTV.setText(Long.toString(brand.getBrandId()));
        stockTypeLL.setVisibility(View.VISIBLE);

        refreshLotData();
    }

    public class SearchBrandCaller extends HTTPCaller {
        private BrandGenStockActivity activity;

        public SearchBrandCaller(BrandGenStockActivity activity, String call) {
            super(activity, call);
            this.activity = activity;
        }
        public void httpSuccessCallback(String jsonResponce){

            List<BrandName> brandNames = null;
            if(jsonResponce != null && !jsonResponce.isEmpty()) {

                ObjectMapper mapper = new ObjectMapper();
                try {
                    brandNames = (List<BrandName>)mapper.readValue(jsonResponce,
                            mapper.getTypeFactory().constructCollectionType(List.class, BrandName.class));
                } catch (IOException e) {
                    Toast.makeText(activity, "No Brand available for given characters", Toast.LENGTH_SHORT).show();
                }
            }
            else {
                Toast.makeText(activity, "No Brand available for given characters", Toast.LENGTH_SHORT).show();
            }

            gsEType.setText("");
            progressBar.setVisibility(View.GONE);

            setBnEnabled(true);

            if(brandNames != null && !brandNames.isEmpty()) {
                new SelectBrandDialog(activity, activity, brandNames).show();
            }
            else {
                Toast.makeText(activity, "No Brand available for given characters", Toast.LENGTH_SHORT).show();
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

package udaan.beone.mrpoint.activity.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import java.util.List;

import udaan.beone.mrpoint.R;
import udaan.beone.mrpoint.http.model.StockTypeName;

/**
 * Created by Vaibhav on 23-05-2016.
 */
public class SelectStockTypeDialog extends Dialog implements OnClickListener {

    protected Activity activity;
    protected OnStockTypeListener listener;
    protected List<StockTypeName> stockTypeNames;

    public SelectStockTypeDialog(Activity activity, OnStockTypeListener listener, List<StockTypeName> stockTypeNames) {

        super(activity);
        this.activity = activity;
        this.listener = listener;
        this.stockTypeNames = stockTypeNames;

        // custom dialog
        setContentView(R.layout.dialog_select_stock_type);
        setTitle("Select Stock Type");

        ((Button) findViewById(R.id.d_cancel)).setOnClickListener(this);

        if(stockTypeNames == null || stockTypeNames.isEmpty()) {
            return;
        }

        if(stockTypeNames.size() >= 1) {
            ((TextView) findViewById(R.id.d_stock_type_id_1)).setText(Long.toString(stockTypeNames.get(0).getStockTypeId()));
            ((TextView) findViewById(R.id.d_stock_type_name_1)).setText(stockTypeNames.get(0).getStockTypeName());
            ((TextView) findViewById(R.id.d_brand_name_1)).setText(stockTypeNames.get(0).getBrandName());
            ((TextView) findViewById(R.id.d_select_1)).setOnClickListener(new SelectClickListener(listener, stockTypeNames.get(0), this));

            ((LinearLayout) findViewById(R.id.d_stock_type_ll_1)).setVisibility(View.VISIBLE);
        }

        if(stockTypeNames.size() >= 2) {
            ((TextView) findViewById(R.id.d_stock_type_id_2)).setText(Long.toString(stockTypeNames.get(1).getStockTypeId()));
            ((TextView) findViewById(R.id.d_stock_type_name_2)).setText(stockTypeNames.get(1).getStockTypeName());
            ((TextView) findViewById(R.id.d_brand_name_2)).setText(stockTypeNames.get(1).getBrandName());
            ((TextView) findViewById(R.id.d_select_2)).setOnClickListener(new SelectClickListener(listener, stockTypeNames.get(1), this));

            ((LinearLayout) findViewById(R.id.d_stock_type_ll_2)).setVisibility(View.VISIBLE);
        }

        if(stockTypeNames.size() >= 3) {
            ((TextView) findViewById(R.id.d_stock_type_id_3)).setText(Long.toString(stockTypeNames.get(2).getStockTypeId()));
            ((TextView) findViewById(R.id.d_stock_type_name_3)).setText(stockTypeNames.get(2).getStockTypeName());
            ((TextView) findViewById(R.id.d_brand_name_3)).setText(stockTypeNames.get(2).getBrandName());
            ((TextView) findViewById(R.id.d_select_3)).setOnClickListener(new SelectClickListener(listener, stockTypeNames.get(2), this));

            ((LinearLayout) findViewById(R.id.d_stock_type_ll_3)).setVisibility(View.VISIBLE);
        }

        if(stockTypeNames.size() >= 4) {
            ((TextView) findViewById(R.id.d_stock_type_id_4)).setText(Long.toString(stockTypeNames.get(3).getStockTypeId()));
            ((TextView) findViewById(R.id.d_stock_type_name_4)).setText(stockTypeNames.get(3).getStockTypeName());
            ((TextView) findViewById(R.id.d_brand_name_4)).setText(stockTypeNames.get(3).getBrandName());
            ((TextView) findViewById(R.id.d_select_4)).setOnClickListener(new SelectClickListener(listener, stockTypeNames.get(3), this));

            ((LinearLayout) findViewById(R.id.d_stock_type_ll_4)).setVisibility(View.VISIBLE);
        }

        if(stockTypeNames.size() >= 5) {
            ((TextView) findViewById(R.id.d_stock_type_id_5)).setText(Long.toString(stockTypeNames.get(4).getStockTypeId()));
            ((TextView) findViewById(R.id.d_stock_type_name_5)).setText(stockTypeNames.get(4).getStockTypeName());
            ((TextView) findViewById(R.id.d_brand_name_5)).setText(stockTypeNames.get(4).getBrandName());
            ((TextView) findViewById(R.id.d_select_5)).setOnClickListener(new SelectClickListener(listener, stockTypeNames.get(4), this));

            ((LinearLayout) findViewById(R.id.d_stock_type_ll_5)).setVisibility(View.VISIBLE);
        }

//        {
//            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            View v = vi.inflate(R.layout.dialog_select_stock_type, null);
//
//            LinearLayout lm = (LinearLayout) v.findViewById(R.id.select_stock_type_ll);
//
//            LayoutParams llParam = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
//
//            LayoutParams stockTypeIdParam = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1f);
//            LayoutParams stockTypeNameParam = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 2f);
//            LayoutParams brandNameParam = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 2f);
//            LayoutParams selectParam = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1f);
//
//            //Create four
//            for (StockTypeName stockTypeName : stockTypeNames) {
//
//                // Create LinearLayout
//                LinearLayout ll = new LinearLayout(getContext());
//                ll.setLayoutParams(llParam);
//                ll.setOrientation(LinearLayout.HORIZONTAL);
//
//                // Create stockTypeId
//                TextView typeIdTV = new TextView(getContext());
//                typeIdTV.setLayoutParams(stockTypeIdParam);
//                typeIdTV.setText(Long.toString(stockTypeName.getStockTypeId()));
//                typeIdTV.setTextColor(activity.getResources().getColor(R.color.colorTextPrimary));
//                typeIdTV.setTextSize(R.dimen.data_table_text_size);
//                typeIdTV.setBackgroundResource(R.drawable.rectangle_border);
//                typeIdTV.setGravity(Gravity.CENTER);
//                typeIdTV.setMaxLines(1);
//                typeIdTV.setPadding(2, 2, 2, 2);
//                typeIdTV.setElevation(2f);
//                ll.addView(typeIdTV);
//
//                // Create stockTypeName
//                TextView stockTypeNameTV = new TextView(getContext());
//                stockTypeNameTV.setLayoutParams(stockTypeNameParam);
//                stockTypeNameTV.setText(stockTypeName.getStockTypeName());
//                stockTypeNameTV.setTextColor(activity.getResources().getColor(R.color.colorTextPrimary));
//                stockTypeNameTV.setTextSize(R.dimen.data_table_text_size);
//                stockTypeNameTV.setBackgroundResource(R.drawable.rectangle_border);
//                stockTypeNameTV.setGravity(Gravity.CENTER);
//                stockTypeNameTV.setMaxLines(1);
//                stockTypeNameTV.setPadding(2, 2, 2, 2);
//                stockTypeNameTV.setElevation(2f);
//                ll.addView(stockTypeNameTV);
//
//                // Create stockTypeName
//                TextView brandNameTV = new TextView(getContext());
//                brandNameTV.setLayoutParams(brandNameParam);
//                brandNameTV.setText(stockTypeName.getBrandName());
//                brandNameTV.setTextColor(activity.getResources().getColor(R.color.colorTextPrimary));
//                brandNameTV.setTextSize(R.dimen.data_table_text_size);
//                brandNameTV.setBackgroundResource(R.drawable.rectangle_border);
//                brandNameTV.setGravity(Gravity.CENTER);
//                brandNameTV.setMaxLines(1);
//                brandNameTV.setPadding(2, 2, 2, 2);
//                brandNameTV.setElevation(2f);
//                ll.addView(brandNameTV);
//
//                // Create select
//                TextView selectTV = new TextView(getContext());
//                selectTV.setLayoutParams(selectParam);
//                selectTV.setText("Select");
//                selectTV.setTypeface(null, Typeface.BOLD);
//                selectTV.setTextColor(activity.getResources().getColor(R.color.colorButtonCyan));
//                selectTV.setTextSize(R.dimen.data_table_text_size);
//                selectTV.setBackgroundResource(R.drawable.rectangle_border);
//                selectTV.setGravity(Gravity.CENTER);
//                selectTV.setMaxLines(1);
//                selectTV.setPadding(2, 2, 2, 2);
//                selectTV.setElevation(2f);
//                selectTV.setOnClickListener(new SelectClickListener(listener, stockTypeName));
//                ll.addView(selectTV);
//                ll.setVisibility(View.VISIBLE);
//
//                //Add button to LinearLayout defined in XML
//                lm.addView(ll);
//                lm.setVisibility(View.VISIBLE);
//            }
//        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.d_cancel:
                this.dismiss();
                break;
        }
    }

    public static class SelectClickListener implements View.OnClickListener{
        protected OnStockTypeListener listener;
        protected StockTypeName stockTypeName;
        protected Dialog dialog;

        public SelectClickListener(OnStockTypeListener listener, StockTypeName stockTypeName, Dialog dialog) {
            this.listener = listener;
            this.stockTypeName = stockTypeName;
            this.dialog = dialog;
        }
        public void onClick(View v) {
            dialog.dismiss();
            listener.onStockTypeSelect(stockTypeName);
        }
    }

    public interface OnStockTypeListener {
        public void onStockTypeSelect(StockTypeName stockTypeName);
    }
}

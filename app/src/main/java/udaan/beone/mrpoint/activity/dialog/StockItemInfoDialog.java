package udaan.beone.mrpoint.activity.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import udaan.beone.mrpoint.R;
import udaan.beone.mrpoint.http.model.StockItem;
import udaan.beone.mrpoint.util.DataUtil;

/**
 * Created by Vaibhav on 23-05-2016.
 */
public class StockItemInfoDialog extends Dialog implements View.OnClickListener {

    public StockItemInfoDialog(Activity activity, StockItem item) {

        super(activity);

        // custom dialog
        setContentView(R.layout.dialog_stock_item_info);
        setTitle("Stock Item Info");

        ((TextView) findViewById(R.id.stock_item_id_v)).setText(Long.toString(item.getStockItemId()));
        ((TextView) findViewById(R.id.stock_item_name_v)).setText(item.getStockItemName());
        ((TextView) findViewById(R.id.design_no_v)).setText(item.getDesignNo());
        ((TextView) findViewById(R.id.stock_type_name_v)).setText(item.getStockTypeName());
        ((TextView) findViewById(R.id.brand_name_v)).setText(item.getBrandName());
        ((TextView) findViewById(R.id.item_status_v)).setText(item.getItemStatus());
        ((TextView) findViewById(R.id.item_condition_v)).setText(item.getItemCondition());
        ((TextView) findViewById(R.id.mr_price_v)).setText(DataUtil.roundUp(item.getMrPrice(), 0).toString());
        ((TextView) findViewById(R.id.dis_mr_price_v)).setText(DataUtil.roundUp(item.getDisMrPrice(), 0).toString());
        ((TextView) findViewById(R.id.mrp_price_v)).setText(DataUtil.roundUp(item.getMrpPrice(), 0).toString());
        ((TextView) findViewById(R.id.dis_mrp_price_v)).setText(DataUtil.roundUp(item.getDisMrpPrice(), 0).toString());
        ((TextView) findViewById(R.id.sold_price_v)).setText(DataUtil.roundUp(item.getSoldPrice(), 0).toString());
        ((TextView) findViewById(R.id.discount_am_v)).setText(DataUtil.roundUp(item.getDiscountAm(), 0).toString());
        ((TextView) findViewById(R.id.vat_am_v)).setText(DataUtil.roundUp(item.getVatAm(), 0).toString());

        ((Button) findViewById(R.id.d_button_ok)).setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.d_button_ok:
                this.dismiss();
                break;
        }
    }
}

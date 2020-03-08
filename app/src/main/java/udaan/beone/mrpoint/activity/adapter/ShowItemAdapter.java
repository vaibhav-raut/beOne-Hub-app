package udaan.beone.mrpoint.activity.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

import udaan.beone.mrpoint.R;
import udaan.beone.mrpoint.activity.VerifyTagActivity;
import udaan.beone.mrpoint.activity.dialog.StockItemInfoDialog;
import udaan.beone.mrpoint.http.model.StockItem;
import udaan.beone.mrpoint.util.DataUtil;

/**
 * Created by Vaibhav on 22-05-2016.
 */

public class ShowItemAdapter extends RecyclerView.Adapter<ShowItemAdapter.SelectedStockViewHolder> {

    private LinkedList<StockItem> items;
    private VerifyTagActivity mContext;

    public ShowItemAdapter(VerifyTagActivity context) {
        items = new LinkedList<StockItem>();
        this.mContext = context;
    }

    public List<StockItem> getItems() {
        return items;
    }
    public boolean addItem(StockItem item) {

        boolean duplicate = false;
        for(StockItem itemL : items) {
            if(itemL.getStockItemId() == item.getStockItemId()) {
                duplicate = true;
                break;
            }
        }

        if(!duplicate) {
            this.items.add(item);
            notifyItemInserted(items.size());
        }

        return !duplicate;
    }
    public void showItemInfo(StockItem item) {
        new StockItemInfoDialog(mContext, item).show();
    }
    public void clearAllItems() {
        if(items != null) {
            int itemCount = this.items.size();
            this.items.clear();
            notifyItemRangeRemoved(1, itemCount);
        }
    }

    @Override
    public SelectedStockViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rc_row_verified_tag, null);

        SelectedStockViewHolder viewHolder = new SelectedStockViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SelectedStockViewHolder viewHolder, int i) {
        StockItem item = null;
        if(i > 0) {
            item = items.get(i - 1);
        }

        //Setting text view title
        viewHolder.setData(item, i);

        // Add OnClickListener for the Card List
        viewHolder.setOnClickListener();

        viewHolder.setTag(viewHolder);
    }

    @Override
    public int getItemCount() {
        return (null != items ? (items.size() + 1) : 1);
    }

    View.OnClickListener itemInfoListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            SelectedStockViewHolder holder = (SelectedStockViewHolder) view.getTag();
            int position = holder.getAdapterPosition();

            if (position > 0) {
                StockItem item = items.get(position - 1);
                showItemInfo(item);
            }
        }
    };
    public class SelectedStockViewHolder extends RecyclerView.ViewHolder {
        protected TextView rsItemId;
        protected TextView rsBrand;
        protected TextView rsStockType;
        protected TextView rsItemMrp;
        protected TextView rsItemWsp;

        public SelectedStockViewHolder(View view) {
            super(view);
            this.rsItemId = (TextView) view.findViewById(R.id.rs_item_id);
            this.rsBrand = (TextView) view.findViewById(R.id.rs_brand);
            this.rsStockType = (TextView) view.findViewById(R.id.rs_stock_type);
            this.rsItemMrp = (TextView) view.findViewById(R.id.rs_item_mrp);
            this.rsItemWsp = (TextView) view.findViewById(R.id.rs_item_mr);
        }

        public void setData(StockItem item, int i) {

            if(i == 0) {
                //Setting text view title
                this.rsItemId.setText(Html.fromHtml("Item Id"));
                this.rsBrand.setText(Html.fromHtml("Brand"));
                this.rsStockType.setText(Html.fromHtml("StockType"));
                this.rsItemMrp.setText(Html.fromHtml("MRP"));
                this.rsItemWsp.setText(Html.fromHtml("WSP"));

                this.rsItemId.setBackgroundResource(R.drawable.rectangle_border_fill50);
                this.rsBrand.setBackgroundResource(R.drawable.rectangle_border_fill50);
                this.rsStockType.setBackgroundResource(R.drawable.rectangle_border_fill50);
                this.rsItemMrp.setBackgroundResource(R.drawable.rectangle_border_fill50);
                this.rsItemWsp.setBackgroundResource(R.drawable.rectangle_border_fill50);
            } else {
                //Setting text view data
                this.rsItemId.setText(Html.fromHtml(Long.toString(item.getStockItemId())));
                this.rsBrand.setText(Html.fromHtml(item.getBrandName()));
                this.rsStockType.setText(Html.fromHtml(item.getStockTypeName()));
                this.rsItemMrp.setText(Html.fromHtml(DataUtil.roundHalfUp(item.getDisMrpPrice(), 0).toString()));
                this.rsItemWsp.setText(Html.fromHtml(DataUtil.roundHalfUp(item.getDisMrPrice(), 0).toString()));
            }
        }

        public void setOnClickListener() {

            // Add OnClickListener for the Card List
            rsItemId.setOnClickListener(itemInfoListener);
            rsBrand.setOnClickListener(itemInfoListener);
            rsStockType.setOnClickListener(itemInfoListener);
            rsItemMrp.setOnClickListener(itemInfoListener);
            rsItemWsp.setOnClickListener(itemInfoListener);
        }

        public void setTag(SelectedStockViewHolder holder) {

            this.rsItemId.setTag(holder);
            this.rsBrand.setTag(holder);
            this.rsStockType.setTag(holder);
            this.rsItemMrp.setTag(holder);
            this.rsItemWsp.setTag(holder);
        }
    }
}


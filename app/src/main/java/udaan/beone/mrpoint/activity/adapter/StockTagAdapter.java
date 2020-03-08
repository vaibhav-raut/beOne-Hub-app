package udaan.beone.mrpoint.activity.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import udaan.beone.mrpoint.R;
import udaan.beone.mrpoint.activity.PrintTagActivity;
import udaan.beone.mrpoint.http.model.ItemTagO;
import udaan.beone.mrpoint.util.DataUtil;

/**
 * Created by Vaibhav on 22-05-2016.
 */

public class StockTagAdapter extends RecyclerView.Adapter<StockTagAdapter.StockTagViewHolder> {

    protected ItemTagO itemTagO;
    protected List<StockTagItem> items;
    protected PrintTagActivity mContext;

    public StockTagAdapter(PrintTagActivity context, ItemTagO itemTagO) {
        this.mContext = context;
        this.itemTagO = itemTagO;
        this.items = buildStockTagItems(itemTagO);
    }

    public List<StockTagItem> getItems() {
        return items;
    }
//    public boolean addItem(StockTagItem item) {
//
//        this.items.add(item);
//        notifyItemInserted(items.size());
//        return true;
//    }
    public void deleteItem(int position) {
        this.itemTagO.getByTypes().remove(position - 1);
        this.items.remove(position - 1);
        notifyItemRemoved(position);
    }
    public void showItemInfo(int position, StockTagItem item) {
//        new StockItemInfoDialog(mContext, this, position, item).show();
    }
    public void clearAllItems() {
        if(items != null) {
            int itemCount = this.items.size();
            this.items.clear();
            notifyItemRangeRemoved(1, itemCount);
        }
    }

    @Override
    public StockTagViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rc_row_stock_tag, null);

        StockTagViewHolder viewHolder = new StockTagViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(StockTagViewHolder viewHolder, int i) {
        StockTagItem item = null;
        if(i > 0) {
            item = items.get(i - 1);

            // Add OnClickListener for the Card List
            viewHolder.setOnClickListener();

            viewHolder.setTag(viewHolder);
        }

        //Setting text view title
        viewHolder.setData(item, i);
    }

    @Override
    public int getItemCount() {
        return (null != items ? (items.size() + 1) : 1);
    }

    protected void onItemNoChange() {
        int itemNos = 0;
        int tagNosPrint = 0;
        for(StockTagItem item: items) {
            itemNos += item.itemNos;
            tagNosPrint += item.itemNosToPrint;
        }
        itemTagO.setItemNos(itemNos);
        mContext.onStockTagNosPrintChange(itemNos, tagNosPrint);
    }

    View.OnClickListener itemDeleteListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            StockTagViewHolder holder = (StockTagViewHolder) view.getTag();
            int position = holder.getAdapterPosition();

            if (position > 0) {
                StockTagItem item = items.get(position - 1);

                deleteItem(position);
                onItemNoChange();
           }
        }
    };

    View.OnFocusChangeListener itemNoChangeListener = new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View var1, boolean hasFocus) {

            if(!hasFocus) {
                StockTagViewHolder holder = (StockTagViewHolder) var1.getTag();
                int position = holder.getAdapterPosition();

                if (position > 0) {
                    String noStr = holder.rsItemToPrintNo.getText().toString().trim();
                    if(noStr.isEmpty()) {
                        noStr = "0";
                        holder.rsItemToPrintNo.setText(noStr);
                    }
                    int newNoToPrint = Integer.parseInt(noStr);
                    if(newNoToPrint <= items.get(position - 1).getItemNos()) {
                        items.get(position - 1).setItemNosToPrint(newNoToPrint);
                        onItemNoChange();
                    } else {
                        holder.rsItemToPrintNo.setText(Html.fromHtml(Integer.toString(items.get(position - 1).getItemNos())));
                        items.get(position - 1).setItemNosToPrint(items.get(position - 1).getItemNos());
                        onItemNoChange();
                    }
                }
            }
        }
    };

    View.OnClickListener itemInfoListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            StockTagViewHolder holder = (StockTagViewHolder) view.getTag();
            int position = holder.getAdapterPosition();

            if (position > 0) {
                StockTagItem item = items.get(position - 1);
                showItemInfo(position, item);
            }
        }
    };

    public class StockTagViewHolder extends RecyclerView.ViewHolder {
        protected TextView rsBrand;
        protected TextView rsStockType;
        protected TextView rsItemMrp;
        protected TextView rsItemNos;
        protected EditText rsItemToPrintNo;
        protected TextView rsDeleteItem;

        public StockTagViewHolder(View view) {
            super(view);
            this.rsBrand = (TextView) view.findViewById(R.id.rs_brand);
            this.rsStockType = (TextView) view.findViewById(R.id.rs_stock_type);
            this.rsItemMrp = (TextView) view.findViewById(R.id.rs_item_mrp);
            this.rsItemNos = (TextView) view.findViewById(R.id.rs_item_nos);
            this.rsItemToPrintNo = (EditText) view.findViewById(R.id.rs_item_to_print_no);
            this.rsDeleteItem = (TextView) view.findViewById(R.id.rs_delete_item);
        }

        public void setData(StockTagItem item, int i) {

            if(i == 0) {
                //Setting text view title
                this.rsBrand.setText("Brand");
                this.rsStockType.setText("StockType");
                this.rsItemMrp.setText("MRP");
                this.rsItemNos.setText("Nos");
                this.rsItemToPrintNo.setText("To");
                this.rsDeleteItem.setText("");

                this.rsBrand.setBackgroundResource(R.drawable.rectangle_border_fill100);
                this.rsStockType.setBackgroundResource(R.drawable.rectangle_border_fill100);
                this.rsItemMrp.setBackgroundResource(R.drawable.rectangle_border_fill100);
                this.rsItemNos.setBackgroundResource(R.drawable.rectangle_border_fill100);
                this.rsItemToPrintNo.setBackgroundResource(R.drawable.rectangle_border_fill100);
                this.rsItemToPrintNo.setEnabled(false);
                this.rsDeleteItem.setBackgroundResource(R.drawable.rectangle_border_fill100);
            } else {
                //Setting text view data
                this.rsBrand.setText(item.getBrandName());
                this.rsStockType.setText(item.getStockTypeName());
                this.rsItemMrp.setText(DataUtil.toString(item.getMrpPriceAm()));
                this.rsItemNos.setText(DataUtil.toString(item.getItemNos()));
                this.rsItemToPrintNo.setText(DataUtil.toString(item.getItemNosToPrint()));
                this.rsDeleteItem.setText("X");

                this.rsBrand.setBackgroundResource(R.drawable.rectangle_border_fill50);
                this.rsStockType.setBackgroundResource(R.drawable.rectangle_border_fill50);
                this.rsItemMrp.setBackgroundResource(R.drawable.rectangle_border_fill50);
                this.rsItemNos.setBackgroundResource(R.drawable.rectangle_border_fill50);
                this.rsItemToPrintNo.setBackgroundResource(R.drawable.rectangle_border);
                this.rsItemToPrintNo.setEnabled(true);
                this.rsDeleteItem.setBackgroundResource(R.drawable.rectangle_border);
            }
        }

        public void setOnClickListener() {

            // Add OnClickListener for the Card List
            rsBrand.setOnClickListener(itemInfoListener);
            rsStockType.setOnClickListener(itemInfoListener);
            rsItemMrp.setOnClickListener(itemInfoListener);
            rsItemNos.setOnClickListener(itemInfoListener);
            rsItemToPrintNo.setOnFocusChangeListener(itemNoChangeListener);
            rsDeleteItem.setOnClickListener(itemDeleteListener);
        }

        public void setTag(StockTagViewHolder holder) {

            this.rsBrand.setTag(holder);
            this.rsStockType.setTag(holder);
            this.rsItemMrp.setTag(holder);
            this.rsItemNos.setTag(holder);
            this.rsItemToPrintNo.setTag(holder);
            this.rsDeleteItem.setTag(holder);
        }
    }

    public interface OnStockTagListener {
        public void onStockTagNosPrintChange(int tagNos, int tagsToPrintNo);
    }

    protected List<StockTagItem> buildStockTagItems(ItemTagO itemTagO) {
        List<StockTagItem> items = new ArrayList<StockTagItem>(itemTagO.getByTypes().size());

        for(ItemTagO.ByType byType: itemTagO.getByTypes()) {
            items.add(new StockTagItem(byType));
        }

        return items;
    }
    public static class StockTagItem {
        private long stockTypeId;
        private String tagStatus;
        private String stockTypeName;
        private String brandName;
        private BigDecimal mrpPriceAm;
        private int itemNos;
        private int itemNosToPrint;

        public StockTagItem(ItemTagO.ByType item) {
            this.stockTypeId = item.getStockTypeId();
            this.tagStatus = item.getTagStatus();
            this.stockTypeName = item.getStockTypeName();
            this.brandName = item.getBrandName();
            this.mrpPriceAm = item.getMrpPriceAm();
            this.itemNos = item.getItemNos();
            this.itemNosToPrint = item.getItemNos();
        }

        public long getStockTypeId() {
            return stockTypeId;
        }

        public void setStockTypeId(long stockTypeId) {
            this.stockTypeId = stockTypeId;
        }

        public String getTagStatus() {
            return tagStatus;
        }

        public void setTagStatus(String tagStatus) {
            this.tagStatus = tagStatus;
        }

        public String getStockTypeName() {
            return stockTypeName;
        }

        public void setStockTypeName(String stockTypeName) {
            this.stockTypeName = stockTypeName;
        }

        public String getBrandName() {
            return brandName;
        }

        public void setBrandName(String brandName) {
            this.brandName = brandName;
        }

        public BigDecimal getMrpPriceAm() {
            return mrpPriceAm;
        }

        public void setMrpPriceAm(BigDecimal mrpPriceAm) {
            this.mrpPriceAm = mrpPriceAm;
        }

        public int getItemNos() {
            return itemNos;
        }

        public void setItemNos(int itemNos) {
            this.itemNos = itemNos;
        }

        public int getItemNosToPrint() {
            return itemNosToPrint;
        }

        public void setItemNosToPrint(int itemNosToPrint) {
            this.itemNosToPrint = itemNosToPrint;
        }
    }
}


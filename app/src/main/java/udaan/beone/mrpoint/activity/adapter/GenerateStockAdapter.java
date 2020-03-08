package udaan.beone.mrpoint.activity.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import udaan.beone.mrpoint.R;
import udaan.beone.mrpoint.activity.GenerateStockActivity;
import udaan.beone.mrpoint.http.model.Lot;
import udaan.beone.mrpoint.http.model.Lot.LotS;
import udaan.beone.mrpoint.util.DataUtil;

/**
 * Created by Vaibhav on 22-05-2016.
 */

public class GenerateStockAdapter extends RecyclerView.Adapter<GenerateStockAdapter.GenerateStockViewHolder> {

    private GenerateStockActivity mContext;
    private List<Lot> lots;

    public GenerateStockAdapter(GenerateStockActivity context, List<Lot> lots) {
        this.mContext = context;
        this.lots = lots;
        onItemNoChange();
    }
    public void clear() {
        mContext = null;
        lots = null;
    }
    public List<Lot> getLots() {
        return lots;
    }
    public List<LotS> getLotsToGenerate() {
        List<LotS> toLots = new ArrayList<LotS>(lots.size());
        if(lots != null) {
            for (Lot lot : lots) {
                if (lot.getNoDamaged() > 0) {
                    toLots.add(Lot.buildLotSToGenerate(lot));
                }
            }
        }
        return toLots;
    }
    public void addLot(Lot lot) {
        if(lots == null) {
            lots = new ArrayList<Lot>();
        }
        lot.setNoDamaged(0);
        this.lots.add(lot);
        onItemNoChange();
        notifyItemInserted(lots.size());
    }
    public void setLots(List<Lot> lots) {
        this.lots = lots;
        if(this.lots != null) {
            for (Lot lot : this.lots) {
                lot.setNoDamaged(0);
            }
        }
        onItemNoChange();
        notifyDataSetChanged();
    }
    public void deleteItem(int position) {
        this.lots.remove(position - 1);
        onItemNoChange();
        notifyItemRemoved(position);
    }
    public void clearAll() {
        if(lots == null) {
            lots = new ArrayList<Lot>();
        } else {
            lots.clear();
        }
        onItemNoChange();
        notifyDataSetChanged();
    }
    protected void showItemInfo(int position, Lot lot) {
//        new SelectedItemInfoDialog(mContext, this, position, lot).show();
    }
    protected void onItemNoChange() {
        int noPurchased = 0;
        int noCreated = 0;
        int noVerified = 0;
        int noToStock = 0;
        int noToStockGen = 0;

        if(lots != null && !lots.isEmpty()) {
            for (Lot lot : lots) {
                noPurchased += lot.getNoPurchased();
                noCreated += lot.getNoCreated();
                noVerified += (lot.getNoPurchased() - lot.getNoToStock() - lot.getNoCreated());
                noToStock += lot.getNoToStock();
                noToStockGen += lot.getNoDamaged();
            }
        }
        if(mContext != null) {
            mContext.onStockNoChange(noPurchased, noCreated, noVerified, noToStock, noToStockGen);
        }
    }

    @Override
    public GenerateStockViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rc_row_generate_stock, null);
        GenerateStockViewHolder viewHolder = new GenerateStockViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(GenerateStockViewHolder viewHolder, int i) {
        Lot lot = null;
        if(i > 0 && lots != null && !lots.isEmpty()) {
            lot = lots.get(i - 1);

            // Add OnClickListener for the Card List
            viewHolder.setOnClickListener();

            viewHolder.setTag(viewHolder);
        }

        //Setting text view title
        viewHolder.setData(lot, i);
    }

    @Override
    public int getItemCount() {
        return (null != lots ? (lots.size() + 1) : 1);
    }

    View.OnClickListener itemDeleteListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            GenerateStockViewHolder holder = (GenerateStockViewHolder) view.getTag();
            int position = holder.getAdapterPosition();

            if (position > 0) {
                if(lots != null) {
                    Lot lot = lots.get(position - 1);
                    deleteItem(position);
                    onItemNoChange();
                }
            }
        }
    };

    View.OnClickListener itemInfoListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            GenerateStockViewHolder holder = (GenerateStockViewHolder) view.getTag();
            int position = holder.getAdapterPosition();

            if (position > 0) {
                if(lots != null) {
                    Lot lot = lots.get(position - 1);
                    showItemInfo(position, lot);
                }
            }
        }
    };

    View.OnFocusChangeListener itemNoChangeListener = new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View var1, boolean hasFocus) {

            if(!hasFocus) {
                GenerateStockViewHolder holder = (GenerateStockViewHolder) var1.getTag();
                int position = holder.getAdapterPosition();

                if (position > 0) {
                    String noStr = holder.gsToStockGen.getText().toString().trim();
                    if(noStr.isEmpty()) {
                        noStr = "0";
                        holder.gsToStockGen.setText(noStr);
                    }
                    int noToStockGen = Integer.parseInt(noStr);
                    if(lots != null) {
                        if (noToStockGen <= lots.get(position - 1).getNoToStock()) {
                            lots.get(position - 1).setNoDamaged(noToStockGen);
                            onItemNoChange();
                        } else {
                            holder.gsToStockGen.setText(Integer.toString(lots.get(position - 1).getNoToStock()));
                            lots.get(position - 1).setNoDamaged(lots.get(position - 1).getNoToStock());
                            onItemNoChange();
                        }
                    }
                }
            }
        }
    };

    public class GenerateStockViewHolder extends RecyclerView.ViewHolder {
        protected TextView gsLotId;
        protected TextView gsStockType;
        protected TextView gsPurchased;
        protected TextView gsToStock;
        protected TextView gsToStockGen;
        protected TextView rsDeleteItem;

        public GenerateStockViewHolder(View view) {
            super(view);
            this.gsLotId = (TextView) view.findViewById(R.id.gs_lot_id);
            this.gsStockType = (TextView) view.findViewById(R.id.gs_stock_type);
            this.gsPurchased = (TextView) view.findViewById(R.id.gs_purchased);
            this.gsToStock = (TextView) view.findViewById(R.id.gs_to_stock);
            this.gsToStockGen = (TextView) view.findViewById(R.id.gs_to_stock_gen);
            this.rsDeleteItem = (TextView) view.findViewById(R.id.rs_delete_item);
        }

        public void setData(Lot lot, int i) {

            if(i == 0) {
                //Setting text view title
                this.gsLotId.setText("Lot Id");
                this.gsStockType.setText("Stock Type");
                this.gsPurchased.setText("PP");
                this.gsToStock.setText("To");
                this.gsToStockGen.setText("Gen");
                this.rsDeleteItem.setText("");

                this.gsLotId.setBackgroundResource(R.drawable.rectangle_border_fill100);
                this.gsStockType.setBackgroundResource(R.drawable.rectangle_border_fill100);
                this.gsPurchased.setBackgroundResource(R.drawable.rectangle_border_fill100);
                this.gsToStock.setBackgroundResource(R.drawable.rectangle_border_fill100);
                this.gsToStockGen.setBackgroundResource(R.drawable.rectangle_border_fill100);
                this.rsDeleteItem.setBackgroundResource(R.drawable.rectangle_border_fill100);
            } else {
                //Setting text view data
                this.gsLotId.setText(DataUtil.toString(lot.getLotId()));
                this.gsStockType.setText(lot.getName());
                this.gsPurchased.setText(DataUtil.toString(lot.getItemPriceAm()));
                this.gsToStock.setText(DataUtil.toString(lot.getNoToStock()));
                this.gsToStockGen.setText(DataUtil.toString(lot.getNoDamaged()));
                this.rsDeleteItem.setText("X");

                this.gsLotId.setBackgroundResource(R.drawable.rectangle_border_fill50);
                this.gsStockType.setBackgroundResource(R.drawable.rectangle_border_fill50);
                this.gsPurchased.setBackgroundResource(R.drawable.rectangle_border_fill50);
                this.gsToStock.setBackgroundResource(R.drawable.rectangle_border_fill50);
                this.gsToStockGen.setBackgroundResource(R.drawable.rectangle_border);
                this.rsDeleteItem.setBackgroundResource(R.drawable.rectangle_border);
            }
        }

        public void setOnClickListener() {

            // Add OnClickListener for the Card List
            gsLotId.setOnClickListener(itemInfoListener);
            gsStockType.setOnClickListener(itemInfoListener);
            gsPurchased.setOnClickListener(itemInfoListener);
            gsToStock.setOnClickListener(itemInfoListener);
            gsToStockGen.setOnFocusChangeListener(itemNoChangeListener);
            rsDeleteItem.setOnClickListener(itemDeleteListener);
        }

        public void setTag(GenerateStockViewHolder holder) {

            this.gsLotId.setTag(holder);
            this.gsStockType.setTag(holder);
            this.gsPurchased.setTag(holder);
            this.gsToStock.setTag(holder);
            this.gsToStockGen.setTag(holder);
            this.rsDeleteItem.setTag(holder);
        }
    }

    public interface OnStockNoListener {
        public void onStockNoChange(int noPurchased, int noCreated, int noVerified, int noToStock, int noToGenerate);
    }

}


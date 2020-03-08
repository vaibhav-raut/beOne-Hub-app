//package udaan.beone.mrpoint.activity.fragment;
//
//import android.app.Activity;
//import android.app.Dialog;
//import android.os.Bundle;
//import android.support.v4.app.DialogFragment;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import java.util.List;
//
//import udaan.beone.mrpoint.R;
//import udaan.beone.mrpoint.activity.dialog.SelectStockTypeDialog.OnStockTypeListener;
//import udaan.beone.mrpoint.http.model.StockTypeName;
//
///**
// * Created by Vaibhav on 12-06-2016.
// */
//public class SelectStockTypeFragment extends DialogFragment {
//    public final static String CONTEXT = "Context";
//    public final static String LISTENER = "Listener";
//    public final static String DIALOG = "Dialog";
//    public final static String LIST = "List";
//
//    private RecyclerView mRecyclerView;
//    private StockTypeAdapter adapter;
//    private Activity mContext;
//    private OnStockTypeListener listener;
//    private Dialog dialog;
//    private List<StockTypeName> stockTypeNames;
//    // this method create view for your Dialog
//
//    public SelectStockTypeFragment() {}
//
//    public SelectStockTypeFragment(Activity context, OnStockTypeListener listener, Dialog dialog, List<StockTypeName> stockTypeNames) {
//        this.mContext = context;
//        this.listener = listener;
//        this.dialog = dialog;
//        this.stockTypeNames = stockTypeNames;
//    }
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//
//        this.mContext = (Activity) getArguments().getString(CONTEXT);
//
//
//        //inflate layout with recycler view
//        View v = inflater.inflate(R.layout.fragment_select_stock_type, container, false);
//        mRecyclerView = (RecyclerView) dialog.findViewById(R.id.show_stock_type_view);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        //setadapter
//        adapter = new StockTypeAdapter(mContext, listener, dialog, stockTypeNames);
//        mRecyclerView.setAdapter(adapter);
//        //get your recycler view and populate it.
//        return v;
//    }
//
//    public class StockTypeAdapter extends RecyclerView.Adapter<StockTypeAdapter.StockTypeViewHolder> {
//
//        private Activity mContext;
//        private OnStockTypeListener listener;
//        private Dialog dialog;
//        private List<StockTypeName> stockTypeNames;
//
//        public StockTypeAdapter(Activity context, OnStockTypeListener listener, Dialog dialog, List<StockTypeName> stockTypeNames) {
//            this.mContext = context;
//            this.listener = listener;
//            this.dialog = dialog;
//            this.stockTypeNames = stockTypeNames;
//        }
//
//        @Override
//        public StockTypeViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
//            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rc_row_select_stock_type, null);
//            StockTypeViewHolder viewHolder = new StockTypeViewHolder(view);
//            return viewHolder;
//        }
//
//        @Override
//        public void onBindViewHolder(StockTypeViewHolder viewHolder, int i) {
//            StockTypeName stockTypeName = null;
//            if(i > 0) {
//                stockTypeName = stockTypeNames.get(i - 1);
//            }
//
//            //Setting text view title
//            viewHolder.setData(stockTypeName, i);
//
//            // Add OnClickListener for the Card List
//            viewHolder.setOnClickListener();
//
//            viewHolder.setTag(viewHolder);
//        }
//
//        @Override
//        public int getItemCount() {
//            return (null != stockTypeNames ? (stockTypeNames.size() + 1) : 1);
//        }
//
//        View.OnClickListener itemSelectListener = new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                StockTypeViewHolder holder = (StockTypeViewHolder) view.getTag();
//                int position = holder.getAdapterPosition();
//
//                if (position > 0) {
//                    StockTypeName stockTypeName = stockTypeNames.get(position - 1);
//                    listener.onStockTypeSelect(stockTypeName);
//                    dialog.dismiss();
//                }
//            }
//        };
//
//        public class StockTypeViewHolder extends RecyclerView.ViewHolder {
//            protected TextView dStockTypeId;
//            protected TextView dStockTypeName;
//            protected TextView dBrandName;
//            protected TextView dSelect;
//
//            public StockTypeViewHolder(View view) {
//                super(view);
//                this.dStockTypeId = (TextView) view.findViewById(R.id.d_stock_type_id);
//                this.dStockTypeName = (TextView) view.findViewById(R.id.d_stock_type_name);
//                this.dBrandName = (TextView) view.findViewById(R.id.d_brand_name);
//                this.dSelect = (TextView) view.findViewById(R.id.d_select);
//            }
//
//            public void setData(StockTypeName stockTypeName, int i) {
//
//                if(i == 0) {
//                    //Setting text view title
//                    this.dStockTypeId.setText("Id");
//                    this.dStockTypeName.setText("Stock Type");
//                    this.dBrandName.setText("Brand");
//                    this.dSelect.setText("");
//
//                    this.dStockTypeId.setBackgroundResource(R.drawable.rectangle_border_fill100);
//                    this.dStockTypeName.setBackgroundResource(R.drawable.rectangle_border_fill100);
//                    this.dBrandName.setBackgroundResource(R.drawable.rectangle_border_fill100);
//
//                } else {
//                    //Setting text view data
//                    this.dStockTypeId.setText(Long.toString(stockTypeName.getStockTypeId()));
//                    this.dStockTypeName.setText(stockTypeName.getStockTypeName());
//                    this.dBrandName.setText(stockTypeName.getBrandName());
//                }
//            }
//
//            public void setOnClickListener() {
//
//                // Add OnClickListener for the Card List
//                dSelect.setOnClickListener(itemSelectListener);
//            }
//
//            public void setTag(StockTypeViewHolder holder) {
//
//                this.dSelect.setTag(holder);
//            }
//        }
//    }
//}

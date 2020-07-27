package org.techtown.listviewtest.adapter;

import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.techtown.listviewtest.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CustomViewHolder> {

    private ArrayList<SampleData> mList;

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView count;
        protected TextView strName;
        protected TextView strText;

        public CustomViewHolder(View view) {
            super(view);
            this.count = (TextView) view.findViewById(R.id.count);
            this.strName = (TextView) view.findViewById(R.id.strName);
            this.strText = (TextView) view.findViewById(R.id.strText);
        }
    }

    public RecyclerViewAdapter(ArrayList<SampleData> list) {
        this.mList = list;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_item, parent, false);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.CustomViewHolder viewholder, int position) {
        viewholder.count.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        viewholder.strName.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        viewholder.strText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);

        viewholder.count.setGravity(Gravity.CENTER);
        viewholder.strName.setGravity(Gravity.CENTER);
        viewholder.strText.setGravity(Gravity.CENTER);

        viewholder.count.setText(mList.get(position).getCount());
        viewholder.strName.setText(mList.get(position).getStrName());
        viewholder.strText.setText(mList.get(position).getStrText());
    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0 );
    }


}

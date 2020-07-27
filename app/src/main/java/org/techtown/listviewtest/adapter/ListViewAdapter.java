package org.techtown.listviewtest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.techtown.listviewtest.R;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {

    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    ArrayList<SampleData> sample;

    public ListViewAdapter(Context context) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    public ListViewAdapter(Context context, ArrayList<SampleData> data) {
        mContext = context;
        sample = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }


    @Override
    public int getCount() {
        return sample.size();
    }

    @Override
    public Object getItem(int i) {
        return sample.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        ViewHolder holder;

        if(converView == null){
            converView = mLayoutInflater.inflate(R.layout.listview_item, null);
            holder = new ViewHolder();

            holder.count = (TextView)converView.findViewById(R.id.count);
            holder.strName = (TextView)converView.findViewById(R.id.strName);
            holder.strText = (TextView)converView.findViewById(R.id.strText);

            converView.setTag(holder);
        } else {
            holder = (ViewHolder) converView.getTag();
        }

        holder.count.setText(sample.get(position).getCount());
        holder.strName.setText(sample.get(position).getStrName());
        holder.strText.setText(sample.get(position).getStrText());

        return converView;
    }

    private class ViewHolder {
        TextView count;
        TextView strName;
        TextView strText;
    }
}

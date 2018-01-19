package com.example.yumimama.weightloss;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by yumimama on 1/18/18.
 */

public class historyListAdapter extends BaseAdapter {

    private Context hContext;
    private List<historyData> mHistoryList;

    public historyListAdapter(Context hContext, List<historyData> mHistoryList) {
        this.hContext = hContext;
        this.mHistoryList = mHistoryList;
    }

    @Override
    public int getCount() {
        return mHistoryList.size();
    }

    @Override
    public Object getItem(int position) {
        return mHistoryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(hContext, R.layout.item_history, null);
        TextView tvDate = (TextView)v.findViewById(R.id.date);
        TextView tvWh = (TextView)v.findViewById(R.id.ls_wh);
        TextView tvTips = (TextView)v.findViewById(R.id.ls_tip);

        tvDate.setText(mHistoryList.get(position).getDate());
        tvWh.setText(mHistoryList.get(position).getWh());
        tvTips.setText(mHistoryList.get(position).getTips());

        v.setTag(mHistoryList.get(position).getId());

        return v;
    }
}

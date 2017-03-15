package com.example.administrator.xinning_wcs.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.xinning_wcs.R;
import com.example.administrator.xinning_wcs.object.YnObject2;
import com.romainpiel.shimmer.Shimmer;

import java.util.List;


/**
 * Created by wangyungang on 2016/6/15.
 */
public class CntAdapter3 extends BaseAdapter {
    private  Context mContext;
    public List<YnObject2> mDatas;

    public CntAdapter3(List<YnObject2> msg, Context context) {
        mDatas = msg;
        mContext = context;
    }


    @Override
    public int getCount() {
        return (mDatas != null ? mDatas.size() : 0);
    }

    @Override
    public Object getItem(int position) {
        return (mDatas != null ? mDatas.get(position) : null);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item3, null);
            viewHolder=new ViewHolder();
            viewHolder.mrpTextView=(TextView)convertView.findViewById(R.id.mrpTextView);
            viewHolder.gtinTextView=(TextView)convertView.findViewById(R.id.gtinTextView);
            viewHolder.prcTextView=(TextView)convertView.findViewById(R.id.prcTextView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (position % 2 == 0) {
            convertView.setBackgroundResource(R.color.list_line1_bg);
        } else {
            convertView.setBackgroundResource(R.color.list_line2_bg);
        }
        YnObject2 yn2 = mDatas.get(position);
        viewHolder.mrpTextView.setText(yn2.getMrp());
        viewHolder.gtinTextView.setText(yn2.getGtin());
        viewHolder.prcTextView.setText(yn2.getPrc());
        return convertView;
    }

    class ViewHolder {
        TextView mrpTextView;
        TextView gtinTextView;
        TextView prcTextView;

    }


}

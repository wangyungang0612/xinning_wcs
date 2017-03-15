package com.example.administrator.xinning_wcs.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.xinning_wcs.R;
import com.example.administrator.xinning_wcs.object.NameObject;
import com.example.administrator.xinning_wcs.object.YnObject2;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by wangyungang on 2016/6/15.
 */
public class CntAdapter4 extends BaseAdapter {
    private  Context mContext;
    public List<NameObject> mDatas;
    public CntAdapter4(List<NameObject> msg, Context context) {
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item4, null);
            viewHolder=new ViewHolder();
            viewHolder.nameTextView=(TextView)convertView.findViewById(R.id.nameTextView);
            viewHolder.liaohao2TextView=(TextView)convertView.findViewById(R.id.liaohao2TextView);
            viewHolder.name2TextView=(TextView)convertView.findViewById(R.id.name2TextView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (position % 2 == 0) {
            convertView.setBackgroundResource(R.color.list_line1_bg);
        } else {
            convertView.setBackgroundResource(R.color.list_line2_bg);
        }
        NameObject name = mDatas.get(position);
        viewHolder.nameTextView.setText(name.getName());
        viewHolder.liaohao2TextView.setText(name.getLiaohao2());
        viewHolder.name2TextView.setText(name.getName2());
        return convertView;
    }

    class ViewHolder {
        TextView nameTextView;
        TextView liaohao2TextView;
        TextView name2TextView;
    }


}

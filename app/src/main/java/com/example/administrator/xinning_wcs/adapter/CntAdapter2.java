package com.example.administrator.xinning_wcs.adapter;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.xinning_wcs.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by wangyungang on 2016/6/15.
 */
public class CntAdapter2 extends BaseAdapter {
    Context context;
    private List<String> resu = new ArrayList<String>();//分型线
    private List<String> bundle = new ArrayList<String>();//门体型号
    private List<String> overpack = new ArrayList<String>();//库存
    private int clo = 0;
    OnItemClickLitener mOnItemClickLitener;




public CntAdapter2(List<String> resu, List<String> bundle, List<String> overpack, Context context) {
      //  L.e("wyg --- list : " + doorList);
        this.resu = resu;
        this.bundle = bundle;
        this.overpack = overpack;
        this.context = context;
    }

    /**
     * ItemClick的回调接口
     */
    public interface OnItemClickLitener {
        public void onItemClick(View view, int position);
    }

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    @Override
    public int getCount() {
        return resu.size();
    }

    @Override
    public Object getItem(int position) {
        return resu.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item2,null);
            viewHolder=new ViewHolder();
            viewHolder.resuTextView=(TextView)convertView.findViewById(R.id.resuTextView);
            viewHolder.bundleTextView=(TextView)convertView.findViewById(R.id.bundleTextView);
            viewHolder.overpackTextView=(TextView)convertView.findViewById(R.id.overpackTextView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (position % 2 == 0) {
            convertView.setBackgroundResource(R.color.list_line1_bg);
        } else {
            convertView.setBackgroundResource(R.color.list_line2_bg);
        }
        viewHolder.resuTextView.setText(resu.get(position));
        viewHolder.resuTextView.setTextColor(Color.RED);
        viewHolder.bundleTextView.setText(bundle.get(position));
        viewHolder.overpackTextView.setText(overpack.get(position));
        return convertView;
    }

    class ViewHolder {
        TextView resuTextView;
        TextView bundleTextView;
        TextView overpackTextView;


    }




}

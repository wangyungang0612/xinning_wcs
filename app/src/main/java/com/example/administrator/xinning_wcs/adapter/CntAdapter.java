package com.example.administrator.xinning_wcs.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.xinning_wcs.R;
import com.example.administrator.xinning_wcs.object.FenjiankouObject;

import java.util.List;


/**
 * Created by wangyungang on 2016/6/15.
 */
public class CntAdapter extends BaseAdapter {
    private  Context mContext;
    public List<FenjiankouObject> mDatas;

    public CntAdapter(List<FenjiankouObject> msg, Context context) {
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item1, null);
            viewHolder=new ViewHolder();
            viewHolder.liaohaoTextView=(TextView)convertView.findViewById(R.id.liaohaoTextView);
            viewHolder.poTextView=(TextView)convertView.findViewById(R.id.poTextView);
            viewHolder.po_lineTextView=(TextView)convertView.findViewById(R.id.po_lineTextView);
            viewHolder.po_allnumTextView=(TextView)convertView.findViewById(R.id.po_allnumTextView);
            viewHolder.no_numTextView=(TextView)convertView.findViewById(R.id.no_numTextView);
            viewHolder.allban_numTextView=(TextView)convertView.findViewById(R.id.allban_numTextView);
            viewHolder.weiban_numTextView=(TextView)convertView.findViewById(R.id.weiban_numTextView);
            viewHolder.fenjianTextView=(TextView)convertView.findViewById(R.id.fenjian_numTextView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (position % 2 == 0) {
            convertView.setBackgroundResource(R.color.list_line1_bg);
        } else {
            convertView.setBackgroundResource(R.color.list_line2_bg);
        }

        FenjiankouObject fenjiankouObject = mDatas.get(position);
        viewHolder.liaohaoTextView.setText(fenjiankouObject.getLiaohao());
        viewHolder.poTextView.setText(fenjiankouObject.getPo());
        viewHolder.po_lineTextView.setText(fenjiankouObject.getPo_line());
        viewHolder.po_allnumTextView.setText(fenjiankouObject.getPo_allnum());
        viewHolder.no_numTextView.setText(fenjiankouObject.getNo_num());
        viewHolder.allban_numTextView.setText(fenjiankouObject.getAllban_num());
        viewHolder.weiban_numTextView.setText(fenjiankouObject.getWeiban_num());
        viewHolder.fenjianTextView.setText(fenjiankouObject.getFenjian_model());
        return convertView;
    }

    class ViewHolder {
        TextView liaohaoTextView;
        TextView poTextView;
        TextView po_lineTextView;
        TextView po_allnumTextView;
        TextView no_numTextView;
        TextView allban_numTextView;
        TextView weiban_numTextView;
        TextView fenjianTextView;
    }


}

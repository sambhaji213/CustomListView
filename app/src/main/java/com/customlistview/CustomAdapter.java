package com.customlistview;

/**
 * Created by sambhaji on 9/7/16.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomAdapter extends BaseAdapter{
    String [] result;
    Context context;
    int [] imageId;

    private static LayoutInflater inflater=null;

    public CustomAdapter(MainActivity mainActivity, String[] prgmNameList, int[] prgmImages) {
        result = prgmNameList;
        context = mainActivity;
        imageId = prgmImages;
        inflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder
    {
        TextView textView;
        ImageView imageView;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.row_item, null);
        holder.textView = (TextView) rowView.findViewById(R.id.textView);
        holder.imageView = (ImageView) rowView.findViewById(R.id.imageView);
        holder.textView.setText(result[position]);
        holder.imageView.setImageResource(imageId[position]);
        rowView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "You Clicked "+result[position], Toast.LENGTH_LONG).show();
            }
        });
        return rowView;
    }

}

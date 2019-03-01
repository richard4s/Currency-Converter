package com.example.imaxinacion.currencyconverter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
//import androidx.NonNull;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class CustomSpinnerAdapter extends ArrayAdapter {

    String[] currencyTitles;
    int[] spinnerImages;
    String[] currencyNames;
    Context mContext;

    public CustomSpinnerAdapter(@NonNull Context context, String[] currencyTitles, int[] spinnerImages, String[] currencyNames) {
        super(context, R.layout.custom_spinner);
        this.currencyTitles = currencyTitles;
        this.spinnerImages = spinnerImages;
        this.currencyNames = currencyNames;
        this.mContext = context;
    }

    private static class ViewHolder {
        ImageView mFlag;
        TextView mTitle;
        TextView mName;
    }

    @Override
    public int getCount() {
        return currencyTitles.length;
    }

    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();
        if(convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.custom_spinner, parent, false);
            mViewHolder.mFlag = (ImageView) convertView.findViewById(R.id.imgNation);
            mViewHolder.mName = (TextView) convertView.findViewById(R.id.txtCurrency);
            mViewHolder.mTitle = (TextView) convertView.findViewById(R.id.txtTitle);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        mViewHolder.mFlag.setImageResource(spinnerImages[position]);
        mViewHolder.mTitle.setText(currencyTitles[position]);
        mViewHolder.mName.setText(currencyNames[position]);

        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getView(position, convertView, parent);
    }
}

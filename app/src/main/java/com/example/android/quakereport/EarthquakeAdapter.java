package com.example.android.quakereport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dguti on 10/24/2016.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> content) {
        super(context,0,content);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Earthquake current = getItem(position);



        if (convertView == null){ convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent,false);}

        TextView magnitude = (TextView) convertView.findViewById(R.id.magnitude);
        magnitude.setText(current.getMagnitude());

        TextView epicenterText  = (TextView) convertView.findViewById(R.id.epicenter);
        epicenterText.setText(current.getEpicenter());

        TextView dateText =  (TextView) convertView.findViewById(R.id.date);
        dateText.setText(current.getDate());

        return convertView;



    }
}

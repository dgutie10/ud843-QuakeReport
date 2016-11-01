package com.example.android.quakereport;


import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by dguti on 10/24/2016.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOCATION_SEPARATOR  = " of ";


    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> content) {
        super(context,0,content);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Earthquake current = getItem(position);

        if (convertView == null){ convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent,false);}

        // Magnitude String population
        TextView magnitude = (TextView) convertView.findViewById(R.id.magnitude);
        magnitude.setText(formatMagnitude(current.getMagnitude()));

        //Sting circle background
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitude.getBackground();
        int magnitudeColor = getMagnitudeColor(current.getMagnitude());
        magnitudeCircle.setColor(magnitudeColor);


        //Location string
        String originalLocation = current.getEpicenter();
        String primaryLocation;
        String locationOffset;

        if (originalLocation.contains(LOCATION_SEPARATOR)){
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        }else{
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;
        }

        TextView primaryText  = (TextView) convertView.findViewById(R.id.primary_location);
        primaryText.setText(primaryLocation);
        TextView offsetText  = (TextView) convertView.findViewById(R.id.location_offset);
        offsetText.setText(locationOffset);


        //Date Time population
        Date dateFormat = new Date(Long.parseLong(current.getDate()));

        SimpleDateFormat dateFormatter =new SimpleDateFormat("MMM dd, yyyy");
        TextView dateText =  (TextView) convertView.findViewById(R.id.date);
        dateText.setText(dateFormatter.format(dateFormat));

        dateFormatter =new SimpleDateFormat("h:mm a");
        TextView timeText =  (TextView) convertView.findViewById(R.id.time);
        timeText.setText(dateFormatter.format(dateFormat));

        return convertView;
    }

    private  int getMagnitudeColor(double magnitude){
        int magnitudeColorId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor){
            case 1:
                magnitudeColorId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorId = R.color.magnitude2;
                break;
            case 3 :
                magnitudeColorId = R.color.magnitude3;
                break;
            case 4 :
                magnitudeColorId = R.color.magnitude4;
                break;
            case 5 :
                magnitudeColorId = R.color.magnitude5;
                break;
            case 6 :
                magnitudeColorId = R.color.magnitude6;
                break;
            case 7 :
                magnitudeColorId = R.color.magnitude7;
                break;
            case 8 :
                magnitudeColorId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorId = R.color.magnitude9;
                break;
            default:
                magnitudeColorId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(),magnitudeColorId);
    }

    private String formatMagnitude(double magnitude){
        DecimalFormat magFormat = new DecimalFormat("0.0");
        return magFormat.format(magnitude);
    }
}

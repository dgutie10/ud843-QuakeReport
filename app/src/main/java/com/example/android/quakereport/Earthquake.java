package com.example.android.quakereport;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dguti on 10/24/2016.
 */

public class Earthquake {
    private double magnitude;
    private String epicenter;
    private String date;
    private String url;

    public Earthquake(double mMagnitude, String mEpicenter, String mDate, String mUrl) {
        magnitude = mMagnitude;
        epicenter = mEpicenter;
        date = mDate;
        url = mUrl;
    }

    public double getMagnitude() {return magnitude;}

    public String getEpicenter() {
        return epicenter;
    }

    public String getDate() {return date ;}

    public String getUrl() {return url;}
}

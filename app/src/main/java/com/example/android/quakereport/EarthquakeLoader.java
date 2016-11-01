package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

import static com.example.android.quakereport.EarthquakeActivity.LOG_TAG;

/**
 * Created by diegog on 11/1/2016.
 */

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    private String url;

    public EarthquakeLoader(Context context, String mUrl) {
        super(context);
        url=mUrl;
    }

    @Override
    protected void onStartLoading() {
        Log.i(LOG_TAG,"onStartLoading called....");
        forceLoad();
    }

    @Override
    public List<Earthquake> loadInBackground() {
        Log.i(LOG_TAG,"loadInBackground initiated");
        if(url == null) return null;

        List<Earthquake> result = QueryUtils.fetchEarthquakeData(url);
        return result;
    }
}

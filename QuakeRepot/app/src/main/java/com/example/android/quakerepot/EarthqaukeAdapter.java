package com.example.android.quakerepot;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.text.DecimalFormat;
import java.util.List;

import static java.security.AccessController.getContext;

public class EarthqaukeAdapter extends ArrayAdapter<Earthquake>  {

    private static final String LOCATION_SEPARATOR = "of";

    public EarthqaukeAdapter(Context context, List<Earthquake> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_earthqukae_list_item, parent, false);
        }

        Earthquake currentEarthquake = getItem(position);

        TextView magnitude = (TextView)listItemView.findViewById(R.id.magnitude);
        TextView p_location = (TextView)listItemView.findViewById(R.id.p_location);
        TextView s_location = (TextView)listItemView.findViewById(R.id.s_location);
        TextView date = (TextView)listItemView.findViewById(R.id.date);
        TextView time = (TextView)listItemView.findViewById(R.id.quake_time);
        GradientDrawable magnitudeCircle = (GradientDrawable)magnitude.getBackground();

        String location = currentEarthquake.getlocation();
        String p_loc, s_loc;
        if(location.contains(LOCATION_SEPARATOR)){
            String[] parts = location.split(LOCATION_SEPARATOR);
            p_loc = parts[0];
            s_loc = parts[1] + LOCATION_SEPARATOR;
        }else{
            p_loc = location;
            s_loc = "Near the";
        }

        int magnitudeColor = ContextCompat.getColor(getContext(), currentEarthquake.getMagnitudeColor());

        magnitude.setText(currentEarthquake.getMagnitude());
        date.setText(currentEarthquake.getDate());
        time.setText(currentEarthquake.getTime());
        p_location.setText(p_loc);
        s_location.setText(s_loc);
        magnitudeCircle.setColor(magnitudeColor);

        return listItemView;
    }
}

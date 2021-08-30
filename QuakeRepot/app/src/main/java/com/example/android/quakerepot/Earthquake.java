package com.example.android.quakerepot;

import androidx.core.content.ContextCompat;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.security.AccessController.getContext;

public class Earthquake {

    private String  location, url;
    private Double magnitude;
    private long date;

    public Earthquake(Double magnitude, String location, long date, String url) {
        this.magnitude = magnitude;
        this.location = location;
        this.date = date;
        this.url = url;
    }

    private Date dateObject = new Date(date);

    public String getDate() {
        String formatedDate = formatedate(dateObject);
        return formatedDate;
    }

    public String getTime() {
        String formateTime = formatetime(dateObject);
        return formateTime;
    }

    public String getlocation() {
        return location;
    }

    public String getMagnitude() {
        String formatedMagnitude = formatemagnitude(magnitude);
        return formatedMagnitude;
    }

    public String getUrl() {
        return url;
    }

    public int getMagnitudeColor() {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return magnitudeColorResourceId;
    }


    private String formatedate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyy");
        return dateFormat.format(dateObject);
    }

    private String formatetime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    private String formatemagnitude(Double magnitude) {
        DecimalFormat magnitudeFormate = new DecimalFormat("0.0");
        return magnitudeFormate.format(magnitude);
    }
}

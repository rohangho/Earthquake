package com.example.android.quakereport;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DecimalFormat;
import android.graphics.drawable.GradientDrawable;

/**
 * Created by ROHAN on 30-06-2017.
 */

public class CustomAdapter  extends ArrayAdapter<Custom> {


    public CustomAdapter(Activity context, ArrayList<Custom> earthquakes) {
        super(context, 0, earthquakes);
    }
    private static final String divider=" of ";
    public View getView(int position, View convertView, ViewGroup parent) {
        View listView = convertView;
        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }



        Custom current = getItem(position);
        if(current.getCountryname().contains(divider)){
            String[] parts=current.getCountryname().split(divider);
            String parts1=parts[0];
            String parts2=parts[1];
            TextView off=(TextView)listView.findViewById(R.id.off_location);
            off.setText(parts1);
            TextView countryname=(TextView) listView.findViewById(R.id.countryname);
            countryname.setText(parts2);
        }
        else{TextView countryname = (TextView) listView.findViewById(R.id.countryname);
            countryname.setText(current.getCountryname());}


        TextView magmitude = (TextView) listView.findViewById(R.id.Richter);
        String formattedmagnitude=formatmagnitude(current.getmag());
        magmitude.setText(formattedmagnitude);


        GradientDrawable magnitudeCircle = (GradientDrawable) magmitude.getBackground();
        int magnitudeColor = getMagnitudeColor(current.getmag());
        magnitudeCircle.setColor(magnitudeColor);



        Date dateObject = new Date(current.getDay());
        TextView dateView = (TextView) listView.findViewById(R.id.year);
        String formattedDate = formatDate(dateObject);
        dateView.setText(formattedDate);
        TextView timeView = (TextView) listView.findViewById(R.id.time);

        String formattedTime = formatTime(dateObject);
        timeView.setText(formattedTime);

        return listView;
    }
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    private String formatmagnitude(double magnitude){

        DecimalFormat magnitudeformat=new DecimalFormat("0.0");
    return  magnitudeformat.format(magnitude);
    }

    private int getMagnitudeColor(double magnitude) {
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
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }


}
